package com.xpression.internal.component

import com.xpression.XpressionElement
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
    fun validateArgumentCount(argumentCount: Int): Boolean = this.argumentCount == argumentCount

    /**
     * Return result with error if any or null
     */
    fun validateArguments(vararg arguments: XpressionElement.Result): XpressionElement.Result? = anyErrors(*arguments)
}