package com.example.effectivemobiletesttask.util

class MapKeysCreator {

    private var counter = -1

    fun createMapKey(): Int {
        counter += 1
        return counter
    }
}