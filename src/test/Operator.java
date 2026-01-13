package test;

import java.util.Arrays;

public enum Operator {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    Operator(char operator) {
        this.operator = operator;
    }

    private final char operator;

    public static Operator findOperator(char operator) {
        return Arrays.stream(Operator.values())
                .filter(x -> x.operator == operator)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자가 입력되었습니다."));
    }
}
