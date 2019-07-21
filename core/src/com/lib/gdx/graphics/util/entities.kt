package com.lib.gdx.graphics.util

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

data class RegionData(var data: TextureRegion, var x: Float, var y: Float, var width: Float, var height: Float,
                      var originX: Float = 0f, var originY: Float = 0f, var scaleX: Float = 1f, var scaleY: Float = 1f,
                      var rotation: Float = 0f, var clockWise: Boolean = false)

data class TextureData(var data: Texture, var x: Float, var y: Float, var width: Float, var height: Float,
                       var originX: Float = 0f, var originY: Float = 0f, var scaleX: Float = 1f, var scaleY: Float = 1f,
                       var srcX: Int = 0, var srcY: Int = 0, var srcWidth: Int = 0, var srcHeight: Int = 0,
                       var flipX: Boolean = false, var flipY: Boolean = false, var rotation: Float = 0f)
