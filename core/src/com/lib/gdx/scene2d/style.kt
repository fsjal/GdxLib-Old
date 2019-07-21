package com.lib.gdx.scene2d

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.Window

fun textButtonStyle(init: TextButton.TextButtonStyle.() -> Unit) = TextButton.TextButtonStyle().apply(init)

fun imageButtonStyle(init: ImageButton.ImageButtonStyle.() -> Unit) = ImageButton.ImageButtonStyle().apply(init)

fun labelStyle(init: Label.LabelStyle.() -> Unit) = Label.LabelStyle().apply(init)

fun windowStyle(init: Window.WindowStyle.() -> Unit) = Window.WindowStyle().apply(init)