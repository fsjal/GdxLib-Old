package com.lib.gdx.graphics.util

import com.badlogic.gdx.graphics.g2d.Batch

/**
 * use batch.use instead of wrapping with begin/end methods
 */
inline fun Batch.use(block: Batch.() -> Unit) {
    begin()
    block()
    end()
}

fun Batch.draw(region: RegionData) = with(region) {
    draw(data, x, y, originX, originY, width, height, scaleX, scaleY, rotation)
}

fun Batch.draw(texture: TextureData) = with(texture) {
    draw(data, x, y, originX, originY, width, height, scaleX, scaleY, rotation, srcX, srcY, srcWidth, srcHeight, flipX, flipY)
}
