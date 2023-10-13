grammar Expression;

// provides entry point for all kind of expressions
root
    : expression                        #evaluateExpression
    ;

expression
    : infixExpression                   #infixExpression_Ignored
    | scope                             #scopedExpression_Ignored
    ;

scope
    : '(' infixExpression ')'           #roundBracketExpression
    | '[' infixExpression ']'           #squareBracketExpression
    | '{' infixExpression '}'           #curlyBracketExpression
//    | '<' infixExpression '>'           #angleBracketExpression
    ;

infixExpression
    : logical                           #logicalExpression_Ignored
    | ternary                           #ternaryExpression_Ignored
    ;

ternary
    : logical '?' logical ':' logical   #ternaryExpression
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
    | left=equality operator=EQEQ right=comparison
                                        #equalityExpressionEqualTo
    | left=equality operator=NTEQ right=comparison
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
    | left=operation operator=POW right=operation
                                        #exponentiationExpression
    ;

operation
    : literal                           #literalExpression
    | accessor                          #accessorExpression
    | function                          #functionExpression
    | scope                             #scopedExpression
    ;

accessor
    : OBJECT_ACCESSOR property ( PROPERTY_ACCESSOR property )*
                                        #objectAccessor
    | property ( PROPERTY_ACCESSOR property )*
                                        #variableAccessor
// TODO: Do we need this? What's the usecase?
//    | function ( PROPERTY_ACCESSOR property )*
//                                        #resultAccessor
    ;

property
    : identifier
    ;

function
    : functionName=identifier '(' (expression (',' expression)*)? ')'
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

TEXT
    : DQUOTE (~["] | '\\"')* DQUOTE
    | SQUOTE (~[']        )* SQUOTE
    ;

NUMBER
    : [0-9]+('.'?[0-9]+)? ;

NULL
    : [Nn][Uu][Ll][Ll]
    ;

BOOLEAN
    : [Tt][Rr][Uu][Ee]|[Ff][Aa][Ll][Ss][Ee]
    ;

/* Identifier must starts with a-z or A-Z or _ followed by a-z A-Z or _ or 0-9 */
IDENTIFIER
    : VALID_ID_START VALID_ID_CHAR*
    ;

fragment VALID_ID_START
    : ('a' .. 'z')
    | ('A' .. 'Z')
    | '_'
    ;

fragment VALID_ID_CHAR
    :  ('a' .. 'z')
    | ('A' .. 'Z')
    | ('0' .. '9')
    | '_'
    ;

SQUOTE      : '\''      ;
DQUOTE      : '"'       ;

/* Accessor */
OBJECT_ACCESSOR
            : '$'       ;
PROPERTY_ACCESSOR
            : '.'       ;

/* Concatinate operator */
CONCATINATOR : '&'       ;

/* Arithmatic operators */
ADD         : '+'       ;
SUB         : '-' ;
MUL         : '*'       ;
DIV         : '/'       ;
MOD         : '%'       ;
POW         : '^'       ;

/* Logical operators */
AND         : '&&'      ;
OR          : '||'      ;
NOT         : '!'       ;

/*  Comparison operators */
GT          : '>'       ;
GE          : '>='      ;
LT          : '<'       ;
LE          : '<='      ;

/* Equality operators */
EQEQ        : '=='      ;
NTEQ        : '!='      ;

/* ignore all white space characters */
WS  :   (SPACE | '\t' | '\r'| '\n' | '\u000C' ) -> skip ;

// todo : Add comments to hiddent channel

fragment SPACE : ' ' ;