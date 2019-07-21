package com.lib.gdx.util

import com.badlogic.gdx.Gdx

object Preferences {

    var name = "appName"

    inline operator fun <reified T> get(key: String): T = with(Gdx.app.getPreferences(name)) {
        when(T::class) {
            Int::class -> getInteger(key) as T
            Float::class -> getFloat(key) as T
            Long::class -> getLong(key) as T
            Boolean::class -> getBoolean(key) as T
            else -> getString(key) as T
        }
    }

    inline operator fun <reified T> set(key: String, value: T): Unit = with(Gdx.app.getPreferences(name)) {
        when(T::class) {
            Int::class -> putInteger(key, value as Int)
            Float::class -> putFloat(key, value as Float)
            Long::class -> putLong(key, value as Long)
            Boolean::class -> putBoolean(key, value as Boolean)
            else -> putString(key, value as String)
        }.flush()
    }

    fun remove(key: String) = Gdx.app.getPreferences(name).remove(key)

    fun clear() = Gdx.app.getPreferences(name).clear()
}