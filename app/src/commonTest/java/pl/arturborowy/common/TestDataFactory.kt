package pl.arturborowy.common

import java.util.*

/**
 * Factory class that makes instances of data models with random field values.
 * The aim of this class is to help setting up test fixtures.
 */
object TestDataFactory {

    private val random = Random()

    fun randomUuid() = UUID.randomUUID().toString()
}