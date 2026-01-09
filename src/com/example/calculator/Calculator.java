package com.example.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static List<Integer> list = new ArrayList<>();

    public void setList(List<Integer> list) {
        Calculator.list = list;
    }

    public List<Integer> getList() {
        return list;
    }

//    삭제되는 원소를 돌려주기(맨 앞에 있는 원소)
    public int removeResult() {
        return list.remove(0);
    }

    public int calculate(int a, int b, char operator) {
        if (operator == '/' && b == 0) {
            throw new IllegalArgumentException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
        }

        int result = 0;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
        }

        list.add(result);
        return result;
    }
}