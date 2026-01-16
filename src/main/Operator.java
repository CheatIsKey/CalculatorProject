package main;

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

    private final char operator;

    public char getOperator() {
        return operator;
    }

    public static Optional<Operator> findOperator(char operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.operator == operator)
                .findFirst();
    }
}
