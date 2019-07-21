package com.lib.gdx.graphics.util

import com.badlogic.gdx.graphics.g2d.TextureAtlas

/**
 * Sugar syntax for atlas[asset NAME]
 */
operator fun TextureAtlas.get(asset: String): TextureAtlas.AtlasRegion = findRegion(asset)