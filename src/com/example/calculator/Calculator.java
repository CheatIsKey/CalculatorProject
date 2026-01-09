package com.example.calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int result = 0;

        System.out.println("첫 번째 숫자를 입력하세요: ");
        int a = scan.nextInt();

        System.out.println("사칙연산 기호를 입력하세요: ");
        String operator = scan.next();


        System.out.println("두 번째 숫자를 입력하세요: ");
        int b = scan.nextInt();

        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                System.out.println("잘못된 연산자가 입력되었습니다.");
        }

        System.out.println("결과: " + result);
    }
}