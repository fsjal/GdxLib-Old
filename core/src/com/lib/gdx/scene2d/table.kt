package com.lib.gdx.scene2d

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.lib.gdx.graphics.util.drawable

fun table(init: Table.() -> Unit = { }) = Table().apply(init)

fun Table.verticalGroup(init: VerticalGroup.() -> Unit = { }) = add(VerticalGroup().apply(init))

fun Table.horizontalGroup(init: HorizontalGroup.() -> Unit = { }) = add(HorizontalGroup().apply(init))

fun Table.stack(init: Stack.() -> Unit = { }) = add(Stack().apply(init))

fun <T: Actor> Table.container(actor: T, init: Container<T>.() -> Unit = { }) = add(Container<T>(actor).apply(init))

fun Table.image(init: Image.() -> Unit = { }) = add(Image().apply(init))

fun Table.image(skin: Skin, drawableName: String, init: Image.() -> Unit = { }) = add(Image(skin, drawableName).apply(init))

fun Table.image(textureRegion: TextureRegion) = add(Image(textureRegion))

fun Table.imageButton(init: ImageButton.ImageButtonStyle.() -> Unit = { }) = add(ImageButton(ImageButton.ImageButtonStyle().apply(init)))

fun Table.imageButton(skin: Skin, styleName: String, init: ImageButton.() -> Unit = { }) = add(ImageButton(skin, styleName).apply(init))

fun Table.imageButton(up: TextureRegion, down: TextureRegion, init: ImageButton.() -> Unit = { }) = add(ImageButton(up.drawable, down.drawable).apply(init))

fun Table.label(label: String, skin: Skin, styleName: String, init: Label.() -> Unit = { }) = add(Label(label, skin, styleName).apply(init))

fun Table.label(label: String, init: Label.LabelStyle.() -> Unit = { }) = add(Label(label, Label.LabelStyle().apply(init)))