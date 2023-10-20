package com.xpression

import java.util.*
import kotlin.reflect.KProperty

class ResettableLazyManager {
    // we synchronize to make sure the timing of a reset() call and new inits do not collide
    private val managedDelegates = LinkedList<Resettable>()

    internal fun register(managed: Resettable) {
        synchronized(managedDelegates) {
            managedDelegates.add(managed)
        }
    }

    fun reset() {
        synchronized(managedDelegates) {
            managedDelegates.forEach { it.reset() }
            managedDelegates.clear()
        }
    }

    companion object {

        fun <PROPERTY_TYPE> resettableLazy(
            manager: ResettableLazyManager,
            init: () -> PROPERTY_TYPE
        ): ResettableLazy<PROPERTY_TYPE> {
            return ResettableLazy(manager, init)
        }
    }
}

internal interface Resettable {
    fun reset()
}

class ResettableLazy<T>(private val manager: ResettableLazyManager, val init: () -> T) : Resettable {

    @Volatile
    var lazyHolder = makeInitBlock()

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return lazyHolder.value
    }

    override fun reset() {
        lazyHolder = makeInitBlock()
    }

    private fun makeInitBlock(): Lazy<T> {
        return lazy {
            manager.register(this)
            init()
        }
    }
}