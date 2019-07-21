package com.lib.gdx.scene2d

import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.InputEvent
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener

inline fun Actor.onClick(crossinline bloc: () -> Unit) {

    addListener(object : ClickListener() {

        override fun clicked(event: InputEvent, x: Float, y: Float) = bloc()
    })
}