package com.lib.gdx.ashley

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.EntitySystem
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.core.PooledEngine
import com.badlogic.ashley.utils.ImmutableArray
import com.badlogic.ashley.core.Entity
import com.lib.gdx.graphics.Disposable
import kotlin.reflect.KClass
import com.badlogic.gdx.utils.Disposable as GdxDisposable
import com.lib.gdx.graphics.invoke
import com.lib.gdx.ashley.Entity as MyEntity

/**
 * Utility class for Ashley engine framework */
@EngineDsl
open class EntityEngine(val engine: PooledEngine) {

    /**
     * Adding entities and systems to the engine */
    inline fun build(init: EntityEngine.() -> Unit = { }) = init()

    /**
     * Creating an entity and adding components to it */
    inline fun entity(init: MyEntity.() -> Unit = { }) = MyEntity(engine).apply(init).entity.apply { engine.addEntity(this) }

    /**
     * Cascade adding systems to the engine  */
    fun systems(vararg systems: EntitySystem) = systems.forEach { engine.addSystem(it) }

    /**
     * Update the engine each frame */
    fun update(delta: Float) = engine.update(delta)

    /**
     * Remove a system from the engine  */
    fun removeSystem(system: EntitySystem) {
        system::class.java.declaredFields
                .filter { it.isAnnotationPresent(Disposable::class.java) && it(system) is GdxDisposable }
                .forEach {
                    val obj = it(system) as GdxDisposable
                    val name = it.name
                    println("$name removed from system")
                    obj.dispose()
                }
//                .map { it(system) as GdxDisposable }
//                .forEach { it.dispose() }
        engine.removeSystem(system)
    }

    /**
     * Removes all systems and entities and clears all pools from the engine */
    fun clear() {
        engine.systems.toList().forEach { removeSystem(it) }
        engine.removeAllEntities()
        engine.clearPools()
    }

    operator fun invoke() = engine

    operator fun get(family: Family): ImmutableArray<Entity> = engine.getEntitiesFor(family)

    operator fun get(vararg classes: KClass<out Component>): ImmutableArray<Entity> = get(Family.all(*classes.map { it.java }.toTypedArray()).get())

    operator fun get(classes: List<KClass<out Component>>): ImmutableArray<Entity> = get(Family.one(*classes.map { it.java }.toTypedArray()).get())

    operator fun <T: EntitySystem> get(classes: KClass<T>): T = engine.getSystem(classes.java)
}