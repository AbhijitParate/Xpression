# Xpression

## Introduction

Xpression is a powerful language for performing operations on data in applications. It supports basic arithmetic, logical, and comparison operators, as well as custom functions that can manipulate text strings, primitive, abstract, and complex data types.

Xpressions can be used to perform a wide range of tasks, such as:

- Calculating the sum, difference, product, or quotient of two numbers
- Checking if a number is even or odd
- Determining if a string contains a particular substring
- Converting a date from one format to another

## Syntax

Xpression language uses a simple syntax that is easy to learn. An expression typically consists of operands, operators, and functions. Operands are the values that the expression operates on, such as numbers, boolean, text strings, and dates. 

Operators are symbols that indicate the operation to be performed, such as `+`, `-`, `*`, `%` and `/`, etc. 

Functions are predefined formulas that perform specific tasks, such as calculating the sum of a group of numbers or finding the square root of a number, etc.

**Examples**

Here are some examples of simple expressions:

* `1 + 2` = `3`
* `Sum(1, 2, 3, 4, 5)` = `15`
* `Len("HelloWorld!!!")` = `13`
* `Text(42)` = `"42"`

## Usage

Simple expressions
```
val result = Xpression("1 + 2").evaluate()
println(result.value) // 3.0
```
Complex expressions using 
```
// User object json
// { 
//    "User" : { 
//       "Name" : "Bob", 
//       "Age" : 42 
//    } 
// }

val context = UserContext() // extend XpressionContext
val result = Xpression("\"Hello\" + User.Name + \"!\"").evaluate(context)
println(result.value) // "Hello Bob!"
```

## Customization

Xpression can be customized by 
1. overriding existing function implementations
2. adding custom function implementations
3. introducing new complex data types, etc.

## Error handling

Xpression handles errors gracefully.

For example, if an expression is invalid or contains an invalid operand or a function that is not supported, it will return an error with human understandable message.

**Example**
```
val result = Xpression("1 # 2").evaluate()
println(result.error) // Error: Invalid character '#' at [1:3]
```