grammar Xpression;

options {
    tokenVocab=XpressionLexer;
}

// provides entry point for all kind of expressions
root
    : expression EOF                   #evaluateExpression
    ;

expression
    : infixExpression                   #infixExpression_Ignored
    | scope                             #scopedExpression_Ignored
    ;

scope
    : LRB infixExpression RRB           #roundBracketExpression
    | LSB infixExpression RSB           #squareBracketExpression
    | LCB infixExpression RCB           #curlyBracketExpression
//    | '<' infixExpression '>'           #angleBracketExpression
    ;

infixExpression
    : logical                           #logicalExpression_Ignored
    | ternary                           #ternaryExpression_Ignored
    ;

ternary
    : logical QUE logical COLON logical   #ternaryExpression
    ;

logical
    : equality                          #equalityExpression_Ignored
    | operator=NOT left=logical
                                        #logicalExpressionNot
    | left=logical operator=AND right=equality
                                        #logicalExpressionAnd
    | left=logical operator=OR right=equality
                                        #logicalExpressionOr
    ;

equality
    : comparison                        #comparisonExpression_Ignored
    | left=equality operator=EQ right=comparison
                                        #equalityExpressionEqualTo
    | left=equality operator=NEQ right=comparison
                                        #equalityExpressionNotEqualTo
    ;

comparison
    : addition                          #additionExpression_Ignored
    | left=addition operator=LT right=addition
                                        #comparisonExpressionLessThan
    | left=addition operator=LE right=addition
                                        #comparisonExpressionLessThanOrEqual
    | left=addition operator=GT right=addition
                                        #comparisonExpressionGreaterThan
    | left=addition operator=GE right=addition
                                        #comparisonExpressionGreaterThanOrEqual
    ;

addition
    : multiplication                     #multiplicationExpression_Ignored
    | left=addition operator=ADD right=multiplication
                                        #additionExpression
    | left=addition operator=SUB right=multiplication
                                        #subtractionExpression
    ;

multiplication
    : exponentiation                    #exponentiationExpression_Ignored
    | left=multiplication operator=MUL right=exponentiation
                                        #multiplicationExpression
    | left=multiplication operator=DIV right=exponentiation
                                        #divisionExpression
    | left=multiplication operator=MOD right=exponentiation
                                        #modulousExpression
    ;

exponentiation
    : operation                         #operationExpression_Ignored
    | left=exponentiation operator=POW right=operation
                                        #exponentiationExpression
    ;

operation
    : literal                           #literalExpression
    | accessor                          #accessorExpression
    | function                          #functionExpression
    | scope                             #scopedExpression
    ;

accessor
    : special=(DOLLOR|HASH|AT)? property ( ACCESSOR property )*
                                        #objectAccessor
    // TODO: Do we need this? What's the usecase?
//    | function ( PROPERTY_ACCESSOR property )*
//                                       #functionAccessor
    ;

property
    : identifier                        #propertyAccessor
    | identifier LSB index=expression LSB
                                        #subscriptAccessor
    ;

function
    : functionName=identifier LRB (expression (COMMA expression)*)? RRB
    ;

identifier
    : IDENTIFIER
    ;

literal
    : BOOLEAN                           #booleanExpression
    | NULL                              #nullExpression
    | number                            #numberExpression
    | TEXT                              #textExpression
    ;

number
    : NUMBER                            #positiveNumber
    | SUB NUMBER                        #negativeNumber
    ;