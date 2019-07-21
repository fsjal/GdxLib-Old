package com.lib.gdx.core

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.lib.gdx.ashley.EntityEngine
import com.lib.gdx.graphics.Asset
import com.lib.gdx.graphics.AssetsManager
import com.lib.gdx.graphics.Disposable
import com.badlogic.gdx.utils.Disposable as GdxDisposable
import com.lib.gdx.graphics.invoke

abstract class Screen : Screen {

    lateinit var assetsManager: AssetsManager
    lateinit var game: ExtendedGame
    lateinit var batch: SpriteBatch
    lateinit var engine: EntityEngine

    override fun hide() {
        engine.clear()
        dispose()
    }

    override fun show() {
        this::class.java.declaredFields
                .filter { it.isAnnotationPresent(Asset::class.java) }
                .forEach {
                    val path = it.getAnnotation(Asset::class.java).path
                    it.isAccessible = true
                    it.set(this, assetsManager[path])
                    it.isAccessible = false
                }
    }

    override fun render(delta: Float) {

    }

    override fun pause() {

    }

    override fun resume() {

    }

    override fun resize(width: Int, height: Int) {

    }

    override fun dispose() {
        this::class.java.declaredFields
                .filter { it.isAnnotationPresent(Disposable::class.java) && it(this) is GdxDisposable }
                .forEach {
                    val obj = it(this) as GdxDisposable
                    val name = it.name
                    println("$name removed from screen")
                    obj.dispose()
                }
//                .map { it(this) as GdxDisposable }
//                .forEach { it.dispose() }
    }
}