package com.xpression.internal

import com.xpression.Result
import com.xpression.Result.Companion.anyErrors

interface Component {
    /**
     * Name of the component
     */
    val name: String

    /**
     * Number of arguments
     */
    val argumentCount: Int

    /**
     * Validate argument count
     */
    fun validateArgumentCount(argumentCount: Int): Boolean = this.argumentCount == argumentCount

    /**
     * Return result with error if any or null
     */
    fun validateArguments(vararg arguments: Result): Result? = anyErrors(*arguments)
}