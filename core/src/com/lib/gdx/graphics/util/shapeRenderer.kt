package com.lib.gdx.graphics.util

import com.badlogic.gdx.graphics.glutils.ShapeRenderer

inline fun ShapeRenderer.use(type: ShapeRenderer.ShapeType, block: () -> Unit) {
    begin(type)
    block()
    end()
}

fun ShapeRenderer.rect(region: RegionData) = with(region) { rect(x, y, originX, originY, width, height, scaleX, scaleY, rotation) }

fun ShapeRenderer.rect(region: TextureData) = with(region) { rect(x, y, originX, originY, width, height, scaleX, scaleY, rotation) }