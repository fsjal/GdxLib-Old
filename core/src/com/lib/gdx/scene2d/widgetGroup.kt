package com.lib.gdx.scene2d

import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Group
import com.badlogic.gdx.scenes.scene2d.ui.*
import com.lib.gdx.graphics.util.drawable

fun WidgetGroup.verticalGroup(init: VerticalGroup.() -> Unit) = addActor(VerticalGroup().apply(init))

fun WidgetGroup.horizontalGroup(init: HorizontalGroup.() -> Unit) = addActor(HorizontalGroup().apply(init))

fun WidgetGroup.stack(init: Stack.() -> Unit) = addActor(Stack().apply(init))

fun <T: Actor> WidgetGroup.container(actor: T, init: Container<T>.() -> Unit = { }) = addActor(Container<T>(actor).apply(init))

// inline fun <reified T: Group> Group.addWidget(init: T.() -> Unit) = addActor(T::class.java.newInstance().apply { init() })

fun verticalGroup(init: VerticalGroup.() -> Unit) = VerticalGroup().apply(init)

fun horizontalGroup(init: HorizontalGroup.() -> Unit) = HorizontalGroup().apply(init)

fun stack(init: Stack.() -> Unit) = Stack().apply(init)

fun <T: Actor> container(actor: T, init: Container<T>.() -> Unit = { }) = Container(actor).apply(init)

operator fun <T: Actor> Group.get(name: String): T = findActor(name)

fun WidgetGroup.image(init: Image.() -> Unit) = addActor(Image().apply(init))

fun WidgetGroup.image(textureRegion: TextureRegion) = addActor(Image(textureRegion))

fun WidgetGroup.image(skin: Skin, drawableName: String) = addActor(Image(skin, drawableName))

fun WidgetGroup.imageButton(init: ImageButton.ImageButtonStyle.() -> Unit) = addActor(ImageButton(ImageButton.ImageButtonStyle().apply(init)))

fun WidgetGroup.imageButton(up: TextureRegion, down: TextureRegion, init: ImageButton.() -> Unit = { }) = addActor(ImageButton(up.drawable, down.drawable).apply(init))

fun WidgetGroup.imageButton(skin: Skin, styleName: String, init: ImageButton.() -> Unit = { }) = addActor(ImageButton(skin, styleName).apply(init))

fun WidgetGroup.label(label: String, init: Label.LabelStyle.() -> Unit = { }) = addActor(Label(label, Label.LabelStyle().apply(init)))

fun WidgetGroup.label(label: String, skin: Skin, styleName: String) = addActor(Label(label, skin, styleName))