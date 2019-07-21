package com.lib.gdx.core

import com.badlogic.ashley.core.PooledEngine
import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.lib.gdx.ashley.EntityEngine
import com.lib.gdx.graphics.AssetsManager
import java.util.Stack
import com.lib.gdx.util.lazy

abstract class ExtendedGame(engine: PooledEngine = PooledEngine()) : Game() {

    val assetsManager by lazy { AssetsManager() }
    val engine by lazy { EntityEngine(engine) }
    val screens by lazy { Stack<Screen>() }
    val batch by lazy { SpriteBatch() }
    val currentScreen: Screen get() = screens.peek()
    val size get() = screens.size

    /**
     * Push a screen to the manager and show it
     * @param screen
     */
    fun push(screen: Screen) {
        screen.game = this
        screen.batch = batch
        screen.assetsManager = assetsManager
        screen.engine = engine
        screens.push(screen)
        setScreen(screen)
    }

    /**
     * Hide of the current screen, return to the previous one
     */
    fun pop() {
        screens.pop()
        setScreen(currentScreen)
    }

    /**
     * Hide of the current screen and push a new one, then show it
     * @param screen
     */
    fun popPush(screen: Screen) {
        screens.pop()
        push(screen)
    }

    /**
     * Dispose all screens and clear them from the manager
     */
    override fun dispose() {
        screens.forEach { it.dispose() }
        screens.clear()
        batch.dispose()
        engine.clear()
        assetsManager.dispose()
    }

    /**
     * Get the screen at specific index
     * @param index
     */
    operator fun get(index: Int): Screen = screens[index]
}