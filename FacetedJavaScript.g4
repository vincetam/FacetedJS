grammar FacetedJavaScript;

@header {
    package edu.sjsu.facetedJS.interpreter.parser;
}

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
DO        : 'do' ;
WHILE     : 'while' ;
FOR       : 'for' ;
LABEL     : 'Label' ;
WRTCHL    : 'writeToChannel' ;
SECURE    : 'setSecurity' ;
CREATECHL : 'createChannel' ;
ALERT     : 'alert' ;
WINOPEN   : 'window.open' ;
FUNCTION  : 'function' ;
VAR       : 'var' ;
PRINT     : 'system.log' ;
RETURN    : 'return' ;
NEW       : 'new' ;
DEFACET   : 'defacet' ;
PUSH      : 'push' ;
LENGTH    : 'length' ;
MD5       : 'md5' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL      : 'true' | 'false' ;
STRING    : '"' (~[\\"\r\n])* '"';
NULL      : 'null' ;
UNDEFINED : 'undefined' ;

// Increment Symbols
INC       : '++' ;
DEC       : '--' ;

// Arithm Symbols
MUL       : '*' ;
DIV       : '/' ;
ADD       : '+' ;
SUB       : '-' ;
MOD       : '%' ;

// Comparision Symbols
GT        : '>' ;
GE        : '>=' ;
LT        : '<' ;
LE        : '<=' ;
EQ        : '==' ;
NEQ       : '!=' ;
S_EQ       : '===' ;
S_NEQ      : '!==' ;

// Assignment Symbols
ASSIGN_REG : '=' ;
ASSIGN_ADD : '+=' ;
ASSIGN_SUB : '-=' ;
ASSIGN_MUL : '*=' ;
ASSIGN_DIV : '/=' ;
SEPARATOR : ';' ;

// Logical Symbols
AND  : '&&' ;
OR   : '||' ;


// Identifiers
ID        : [a-zA-Z_] [a-zA-Z0-9_]* ;


// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace


// ***Paring rules ***

/** The start rule */
prog: stat+ ;

stat: expr SEPARATOR                                     # bareExpr
    | FUNCTION ID params '{' stat* '}'                   # namedFunction
    | IF '(' expr ')' block ELSE block                   # ifThenElse
    | IF '(' expr ')' block                              # ifThen
    | WHILE '(' expr ')' block                           # while
    | DO block WHILE '(' expr ')'                        # doWhile
    | FOR '(' expr ';' expr ';' expr ')' block           # for
    | WRTCHL '(' expr ',' expr ')' SEPARATOR             # writeChl
    | PRINT '(' expr ')' SEPARATOR                       # printExpr
    | ALERT '(' expr ')' SEPARATOR                       # alert
    | WINOPEN '(' expr ')' SEPARATOR                     # winOpen
    | RETURN expr SEPARATOR                              # returnExpr
    | SEPARATOR                                          # blank
    ;

expr: expr args                                                                # FunctionApp
    | DEFACET '(' expr ',' expr ')'                                            # DefcExpr
    | SECURE '(' expr ',' expr (',' expr)? ')'                                 # SetSecurity
    | MD5 '(' expr ')'                                                         # MD5Expr
    | FUNCTION params '{' stat* '}'                                            # anonFunction
    | expr '[' expr ']'                                                        # BktExpr
    | expr '.' ID                                                              # DotExpr
    | expr '.' PUSH '(' expr ')'                                               # PushExpr
    | expr '.' LENGTH                                                          # GetLengthExpr
    | op=( '+' | '-') expr                                                     # PlusMinusSign
    | op=( INC | DEC ) expr                                                    # PreIncDec
    | expr op=( INC | DEC )                                                    # PostIncDec
    | NEW expr                                                                 # ObjInstant
    | NEW LABEL '(' ')'                                                        # CreateLabel
    | expr op=( '*' | '/' | '%' ) expr                                         # MulDivMod
    | expr op=( '+' | '-' ) expr                                               # AddSub
    | expr op=( '<' | '<=' | '>' | '>=' | '==' | '!=' | '===' | '!==') expr    # Comparison
    | expr op=( '&&' | '||') expr                                              # LogicComparison
    | VAR ID op=( '=' | '+=' | '-=' | '*=' | '/=' ) expr                       # LocalAssign
    | expr op=( '=' | '+=' | '-=' | '*=' | '/=' ) expr                         # GlobalAssign
    | array                                                                    # ArrayExpr
    | object                                                                   # ObjectExpr
    | INT                                                                      # int
    | BOOL                                                                     # bool
    | STRING                                                                   # string
    | NULL                                                                     # null
    | UNDEFINED                                                                # undefined
    | ID                                                                       # id
    | '(' expr ')'                                                             # parens
    ;

perms : '(' ')'
      | '(' STRING (',' STRING)* ')'
      ;

block : '{' stat* '}'                                     # fullBlock
      | stat                                              # simpBlock
      ;

params : '(' ')'
       | '(' ID (',' ID)* ')'
       ;

args : '(' ')'
     | '(' expr (',' expr)* ')'
     ;
    
array : '[' expr (',' expr)* ']'
      | '[' ']'
      ;
       
object : '{' pair (',' pair)* '}'                         # fullObj 
       | '{' '}'                                          # emptObj
       ;
    
pair : ID ':' expr                                         # keyPair
     ;