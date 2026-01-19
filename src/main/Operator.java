package main;

import main.exception.DivideException;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.DoubleBinaryOperator;

public enum Operator {
    PLUS('+', (a, b) -> a + b),
    MINUS('-', (a, b) -> a - b),
    MULTIPLY('*', (a, b) -> a * b),
    DIVIDE('/', (a, b) -> {
        if (b == 0) throw new DivideException("나누기에서 분모가 0일 수 없습니다.");
        return a / b;
    });

    Operator(char operator, DoubleBinaryOperator op) {
        this.operator = operator;
        this.op = op;
    }

    private final char operator;
    private final DoubleBinaryOperator op;

    public char getOperator() {
        return operator;
    }

    public double apply(double a, double b) {
        return op.applyAsDouble(a, b);
    }

    public static Optional<Operator> findOperator(char operator) {
        return Arrays.stream(Operator.values())
                .filter(op -> op.operator == operator)
                .findFirst();
    }
}
