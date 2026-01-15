package com.example.calculator;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    Operator(char operator) {
        this.operator = operator;
    }

    private char operator;

    public static Optional<Operator> findOperator(char operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.operator == operator)
                .findFirst();
    }
}
