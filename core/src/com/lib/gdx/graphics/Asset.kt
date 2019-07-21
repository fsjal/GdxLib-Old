package com.lib.gdx.graphics

import com.badlogic.gdx.graphics.Texture
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
annotation class Asset(val type: KClass<*> = Texture::class, val param: String = "", val path: String = "")