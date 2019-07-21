package com.lib.gdx.ashley

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.PooledEngine

@EngineDsl
class Entity(val engine: PooledEngine) {

    @PublishedApi
    internal val entity = engine.createEntity()

    inline fun <reified T: Component> component(init: T.() -> Unit = { }) {
        entity.add(engine.createComponent(T::class.java).apply(init))
    }
}
