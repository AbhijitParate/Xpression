package com.xpression.internal

import com.xpression.XpressionElement.Result
import com.xpression.XpressionElement.Result.Companion.anyErrors

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
    fun validateArgumentCount(count: Int) = argumentCount == count

    /**
     * Return result with error if any or null
     */
    fun validateArguments(vararg arguments: Result): Result? = anyErrors(*arguments)
}