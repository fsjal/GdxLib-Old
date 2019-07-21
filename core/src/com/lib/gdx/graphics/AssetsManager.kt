package com.lib.gdx.graphics

import com.badlogic.gdx.assets.AssetLoaderParameters
import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader
import java.lang.reflect.Field
import kotlin.reflect.KClass

class AssetsManager : AssetManager() {

    init {
        setLoader(FreeTypeFontGenerator::class.java, FreeTypeFontGeneratorLoader(fileHandleResolver))
    }

    fun load(clazz: KClass<*>) {
        val cls = clazz.java
        val fields = cls.declaredFields.filter { it.isAnnotationPresent(Asset::class.java) }

        fields.forEach { field ->
            val annotation = field.getAnnotation(Asset::class.java)
            val type = annotation.type.java as Class<Any>
            val path = field().toString()
            val paramString = if (annotation.param != "") annotation.param else null
            val param = paramString?.let {
                val paramField = cls.getDeclaredField(it)
                if (paramField.isAnnotationPresent(AssetParam::class.java)) paramField() else null
            } as AssetLoaderParameters<Any>?

            param?.let { load(path, type, it) } ?: load(path, type)
        }
    }

    fun unload(clazz: KClass<*>) {
        clazz.java.declaredFields.filter { it.isAnnotationPresent(Asset::class.java) }.forEach { unload(it().toString()) }
    }

    inline fun update(onUpdate: (Float) -> Unit) {
        var isFinished = false

        while (!isFinished) {
            isFinished = update()
            onUpdate(progress)
        }
    }
}

internal operator fun Field.invoke(instance: Any? = null): Any {
    isAccessible = true
    val obj = this.get(instance)
    isAccessible = false
    return obj
}