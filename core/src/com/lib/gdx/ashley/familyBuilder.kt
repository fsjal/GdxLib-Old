package com.lib.gdx.ashley

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.core.Family.Builder
import kotlin.reflect.KClass

fun Builder.all(vararg classes: KClass<out Component>): Builder = all(*normalizeComponent(classes))

fun Builder.one(vararg classes: KClass<out Component>): Builder = one(*normalizeComponent(classes))

fun Builder.exclude(vararg classes: KClass<out Component>): Builder = exclude(*normalizeComponent(classes))

infix fun Builder.exclude(classes: List<KClass<out Component>>): Family = exclude(*classes.toTypedArray()).get()

infix fun Builder.exclude(classes: KClass<out Component>): Family = exclude(classes.java).get()

internal fun normalizeComponent(classes: Array<out KClass<out Component>>) = classes.map { it.java }.toTypedArray()