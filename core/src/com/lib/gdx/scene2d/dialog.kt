package com.lib.gdx.scene2d

import com.badlogic.gdx.scenes.scene2d.ui.Dialog
import com.badlogic.gdx.scenes.scene2d.ui.Window

fun dialog(title: String, init: Window.WindowStyle.() -> Unit) = Dialog(title, Window.WindowStyle().apply(init))