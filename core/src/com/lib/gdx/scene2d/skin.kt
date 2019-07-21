package com.lib.gdx.scene2d

import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.*

fun skin(init: Skin.() -> Unit) = Skin().apply(init)

fun skin(atlas: TextureAtlas, init: Skin.() -> Unit) = Skin(atlas).apply(init)

fun Skin.textButtonStyle(name: String = "default", init: TextButton.TextButtonStyle.() -> Unit) = add(name, TextButton.TextButtonStyle().apply(init))

fun Skin.imageButtonStyle(name: String = "default", init: ImageButton.ImageButtonStyle.() -> Unit) = add(name, ImageButton.ImageButtonStyle().apply(init))

fun Skin.labelStyle(name: String = "default", init: Label.LabelStyle.() -> Unit) = add(name, Label.LabelStyle().apply(init))

fun Skin.windowStyle(name: String = "default", init: Window.WindowStyle.() -> Unit) = add(name, Window.WindowStyle().apply(init))

inline operator fun<reified T> Skin.get(name: String): T = get(name, T::class.java)