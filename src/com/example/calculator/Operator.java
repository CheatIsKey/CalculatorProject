package com.example.calculator;

import java.util.Arrays;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    Operator(char operator) {
        this.operator = operator;
    }

    private char operator;

    public static Operator findOperator(char operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.operator == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }
}
