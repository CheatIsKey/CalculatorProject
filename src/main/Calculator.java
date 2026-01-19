package main;

import main.exception.CalculateException;
import main.exception.DivideException;

import java.util.ArrayList;
import java.util.List;

import static main.Operator.*;

public class Calculator {
    private static final List<Double> results = new ArrayList<>();

    public void addResult(double result) {
        results.add(result);
    }

    public String getResults() {
        return results.toString();
    }

//    TODO: 입력된 결과보다 값이 더 큰 결과 가져오기
    public double[] getGreaterResult(double result) {
        return results.stream()
                .map(x -> {
                    if (x == null) throw new IllegalArgumentException("현재 저장된 계산 결과가 없습니다.");
                    return x;
                })
                .filter(x -> x > result)
                .mapToDouble(Double::doubleValue)
                .toArray();
    }

    //    삭제되는 원소를 돌려주기(맨 앞에 있는 원소)
    public double removeResult() {
        return results.remove(0);
    }

    //    계산 결과 기록이 비었는지 체크하는 메서드
    public boolean isEmpty() {
        return results.isEmpty();
    }

    public <T extends Number> double calculate(T a, T b, char operator) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        Operator op = findOperator(operator).orElseThrow(() -> new CalculateException("커스텀 예외 발생"));
        double result = op.apply(num1, num2);

        addResult(result);
        return result;
    }
}