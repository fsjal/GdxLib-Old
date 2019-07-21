package com.lib.gdx.ashley

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.Family
import kotlin.reflect.KClass

object Family {

    /**
     * Entities will have to contain all of the specified components
     */
    operator fun get(vararg classes: KClass<out Component>): Family = Family.all(*normalizeComponent(classes)).get()

    /**
     * Entities will have to contain at least one of the specified components
     */
    operator fun get(classes: List<KClass<out Component>>): Family = Family.one(*classes.map { it.java }.toTypedArray()).get()

    /**
     * Entities will have to contain all of the specified components
     */
    fun all(vararg classes: KClass<out Component>): Family.Builder = Family.all(*normalizeComponent(classes))

    /**
     * Entities will have to contain at least one of the specified components
     */
    fun one(vararg classes: KClass<out Component>): Family.Builder = Family.one(*normalizeComponent(classes))

    /**
     * Entities cannot contain any of the specified components.
     */
    fun exclude(vararg classes: KClass<out Component>): Family.Builder = Family.exclude(*normalizeComponent(classes))
}