package com.lib.gdx.graphics

import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.ArrayMap
import kotlin.properties.Delegates

/**
 * Encapsulation animation.
 * You should rename sprites running_0.png, running_1.png, running_2.png, the texture packer will create index automatically for you.
 * @param atlasPath
 */
class SpriteAnimation(atlasPath: String) {

    private val animations = ArrayMap<String, Animation<TextureRegion>>()
    private var counter = 0f
    private val atlas = TextureAtlas(atlasPath)
    var current: String by Delegates.observable("", { _,_,_ -> counter = 0f })

    fun add(name: String, duration: Float, playMode: Animation.PlayMode = Animation.PlayMode.NORMAL) {
        animations.put(name, Animation(duration, atlas.findRegions(name), playMode))
    }

    fun flip(x: Boolean, y: Boolean) {
        animations[current].keyFrames.forEach { it.flip(x, y) }
    }

    fun draw(delta: Float, loop: Boolean = true, draw: (TextureRegion) -> Unit) {
        draw(animations[current].getKeyFrame(counter, loop))
        counter += delta
    }

    fun dispose() {
        atlas.dispose()
    }
}