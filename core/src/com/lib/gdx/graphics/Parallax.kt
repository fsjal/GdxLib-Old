package com.lib.gdx.graphics

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureWrap
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.Array
import com.lib.gdx.graphics.util.use
import com.lib.gdx.util.i

class Parallax(private val batch: SpriteBatch) {

    private val parallaxes = Array<ParallaxItem>()

    fun add(item: ParallaxItem) = parallaxes.add(item)

    fun addAt(item: ParallaxItem, position: Int) = parallaxes.insert(position, item)

    fun update(x: Float, y: Float) {
        parallaxes.forEach { it.update(x, y) }
    }

    fun draw() {
        batch.use {
            parallaxes.filter { it.autoDraw }.forEach { it.draw(batch) }
        }
    }

    fun dispose() {
        parallaxes.forEach { it.dispose() }

    }

    operator fun get(position: Int): ParallaxItem = parallaxes[position]
}

class ParallaxItem(private val texture: Texture, private val px: Float = 1f, private val py: Float = 1f, val autoDraw: Boolean = true,
                   uWrap: TextureWrap = TextureWrap.Repeat, vWrap: TextureWrap = TextureWrap.ClampToEdge) {

    private var x: Float = 0f
    private var y: Float = 0f
    private var srcX = 0
    private var srcY = 0

    init {
        texture.setWrap(uWrap, vWrap)
    }

    fun update(x: Float, y: Float) {
        srcX = (x * px).i
        srcY = (y * py).i
    }

    fun draw(batch: SpriteBatch) {
        batch.draw(texture, x, y, srcX, srcY, texture.width, texture.height)
    }

    fun dispose() {
        texture.dispose()
    }
}