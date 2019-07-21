package com.lib.gdx.scene2d

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import com.lib.gdx.graphics.util.drawable

fun image(init: Image.() -> Unit) = Image().apply(init)

fun image(skin: Skin, drawableName: String, init: Image.() -> Unit) = Image(skin, drawableName).apply(init)

fun imageButton(init: ImageButton.ImageButtonStyle.() -> Unit) = ImageButton(ImageButton.ImageButtonStyle().apply(init))

fun imageButton(skin: Skin, styleName: String, init: ImageButton.() -> Unit = { }) = ImageButton(skin, styleName).apply(init)

fun imageButton(up: TextureRegion, down: TextureRegion, init: ImageButton.() -> Unit = { }) = ImageButton(up.drawable, down.drawable).apply(init)

fun label(label: String, init: Label.LabelStyle.() -> Unit = { }) = Label(label, Label.LabelStyle().apply(init))