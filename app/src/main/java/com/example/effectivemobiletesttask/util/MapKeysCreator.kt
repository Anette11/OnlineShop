package com.example.effectivemobiletesttask.util

class MapKeysCreator {

    private val defaultValue = -1
    private var counter = defaultValue

    fun createMapKey(): Int {
        counter += 1
        return counter
    }

    fun refresh() {
        counter = defaultValue
    }
}