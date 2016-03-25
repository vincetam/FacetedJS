package edu.sjsu.facetedJS.interpreter.core;

/**
 * FWJS binary operators.
 */
public enum Operator {
    ADD, SUB, MUL, DIV, MOD,
    GT, GE, LT, LE, EQ, NEQ, S_EQ, S_NEQ,
    INC, DEC,
    ASSIGN_REG, ASSIGN_ADD, ASSIGN_SUB, ASSIGN_MUL, ASSIGN_DIV,
    AND, OR
}
