package com.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
//    TODO: 멤버 변수/필드가 꼭 필요한 게 아닌지 먼저 생각해보기
//    int a;
//    int b;
//    char operator;
//
//    public Calculator(int a, int b, char operator) {
//        this.a = a;
//        this.b = b;
//        this.operator = operator;
//    }

    //    TODO:
//      List<Integer> list = new ArrayList<>();
//      컬렉션 또한 앞에 접근 제어자를 붙일 수 있다!
    private List<Double> list = new ArrayList<>();

    public void addResult(double result) {
        list.add(result);
    }

    public String getList() {
//        TODO:
//          컬렉션에 toString() 메서드를 쓰면 내부 요소들이 출력된다.
//        int[] arr = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return Arrays.toString(arr);
        return list.toString();
    }

//    TODO: 입력된 결과보다 값이 더 큰 결과 가져오기
    public double[] getGreaterResult(double result) {
        return list.stream()
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
        return list.remove(0);
    }

    //    계산 결과 기록이 비었는지 체크하는 메서드
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public <T extends Number> double calculate(T a, T b, char operator) {
        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        if (operator == '/' && num2 == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        }

        double result = 0;

        try {
            result = switch (Operator.findOperator(operator).orElseThrow(IllegalArgumentException::new)) {
                case PLUS -> num1 + num2;
                case MINUS -> num1 - num2;
                case MULTIPLY -> num1 * num2;
                case DIVIDE -> num1 / num2;
            };
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 연산자가 입력되었습니다.");
        }

//        list.add(result);
        return result;
    }
}