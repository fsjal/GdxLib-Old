package com.lib.gdx.util

import com.badlogic.gdx.*
import com.badlogic.gdx.utils.Timer
import com.lib.gdx.core.ExtendedGame

inline fun schedule(delay: Float, crossinline bloc: () -> Unit): Timer.Task =
        Timer.schedule(object : Timer.Task() { override fun run() = bloc() }, delay)

operator fun <T: InputProcessor> T.plus(input: T) = InputMultiplexer(this, input)

operator fun <T: InputProcessor> T.plusAssign(input: T) { Gdx.input.inputProcessor = InputMultiplexer(this, input) }

operator fun Application.invoke() = Gdx.app.applicationListener as ExtendedGame

fun <T> lazy(block: () -> T) = lazy(LazyThreadSafetyMode.NONE) { block() }