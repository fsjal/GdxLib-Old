package com.lib.gdx.graphics.util

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable

val TextureRegion.drawable get() = TextureRegionDrawable(this)