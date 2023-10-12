package com.xpression.test

import org.junit.jupiter.api.Test

class FunctionTests : BaseXpressionTest() {

    @Test
    fun mathTests() {
        evaluate("Absolute(5.4)", 5.4)
        evaluate("Absolute(-5.4)", 5.4)
        evaluate("Floor(5.4)", 5.0)
        evaluate("Floor(-5.4)", -6.0)
        evaluate("Ceiling(5.4)", 6.0)
        evaluate("Ceiling(-5.4)", -5.0)
        evaluateError("Ceiling()")
        evaluateError("Ceiling(true)")
        evaluateError("Ceiling(\"xyz\")")
    }

    @Test
    fun dataTests() {
        // IsNull
        evaluate("IsNull(Null)", true)
        evaluate("IsNull(True)", false)
        evaluate("IsNull(false)", false)
        evaluate("IsNull(1.0)", false)
        evaluate("IsNull(\"xyz\")", false)
        evaluateError("IsNull()")

        // IsBlank
        evaluate("IsBlank(\"\")", true)
        evaluate("IsBlank(\"abc\")", false)
        evaluateError("IsBlank(123)")
        evaluateError("IsBlank(true)")
        evaluateError("IsBlank()")

        // IsText
        evaluate("IsText(\"\")", true)
        evaluate("IsText(\"abc\")", true)
        evaluate("IsText(123)", false)
        evaluate("IsText(true)", false)
        evaluateError("IsText()")

        // IsNumber
        evaluate("IsNumber(\"\")", false)
        evaluate("IsNumber(\"abc\")", false)
        evaluate("IsNumber(123)", true)
        evaluate("IsNumber(true)", false)
        evaluateError("IsNumber()")

        // IsBoolean
        evaluate("IsBoolean(\"\")", false)
        evaluate("IsBoolean(\"abc\")", false)
        evaluate("IsBoolean(123)", false)
        evaluate("IsBoolean(true)", true)
        evaluateError("IsBoolean()")
    }

    @Test
    fun logicTests() {
        // Not
        evaluate("Not(true)", false)
        evaluate("Not(false)", true)
        evaluateError("Not()")
        evaluateError("Not(123)")
        evaluateError("Not(ABC)")
        evaluateError("Not(\"text\")")

        // And
        evaluateError("And()")
        evaluateError("And(true)")
        evaluateError("And(A, B, C)")
        evaluateError("And(1, 2, 3)")
        evaluateError("And(123)")
        evaluateError("And(XYZ)")
        evaluate("And(true, false)", false)
        evaluate("And(true, true)", true)
        evaluate("And(false, false)", false)
        evaluate("And(true, true, false)", false)
        evaluate("And(true, true, true)", true)
        evaluate("And(false, false, false)", false)

        // Or
        evaluateError("Or()")
        evaluateError("Or(true)")
        evaluateError("Or(A, B, C)")
        evaluateError("Or(1, 2, 3)")
        evaluateError("Or(123)")
        evaluateError("Or(XYZ)")
        evaluate("Or(true, false)", true)
        evaluate("Or(true, true)", true)
        evaluate("Or(false, false)", false)
        evaluate("Or(true, true, false)", true)
        evaluate("Or(true, true, true)", true)
        evaluate("Or(false, false, false)", false)
    }

    @Test
    fun textTests() {
        // Text
        evaluate("Text(5.4)", "5.4")
        evaluate("Text(5.43)", "5.43")
        evaluate("Text(5)", "5.0")
        evaluate("Text(true)", "true")
        evaluate("Text(false)", "false")
        evaluate("Text(null)", "")
        evaluate("Text(ABC)", "")
        context.setValue("ABC", 1234.0)
        evaluate("Text(ABC)", "1234.0")
        evaluateError("Text(\"XYZ\")")

        // Contains
        evaluate("Contains(\"ABC\", \"A\")", true)
        evaluate("Contains(\"ABC\", \"Z\")", false)
        evaluate("Contains(\"ABC\", \"\")", true)
        evaluate("Contains(\"\", \"\")", true)
        evaluate("Contains(\"\", \"XYZ\")", false)
        evaluateError("Contains()")
        evaluateError("Contains(true, false)")
        evaluateError("Contains(ABC, XYZ)")
        context.setValue("ABC", "Hello World !!!")
        context.setValue("XYZ", "!!!")
        evaluate("Contains(ABC, XYZ)", true)

        // Len
        evaluate("Len(\"ABC\")", 3.0)
        evaluate("Len(\"\")", 0.0)
        evaluateError("Len()")
        evaluateError("Len(Null)")
        evaluateError("Len(true)")
        evaluateError("Len(false)")
        context.setValue("ABC", null)
        evaluateError("Len(ABC)")
        context.setValue("ABC", "XYZ")
        evaluate("Len(ABC)", 3.0)
    }

}