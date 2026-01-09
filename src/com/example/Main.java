package com.example;

import com.example.calculator.Calculator;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input = "";

        //TODO: 최초 1회는 실행되고 그 이후에 반복할지 여부를 판단하기 위해, do-while() 반복문 사용하기
        do {
            int result = 0;

            System.out.print("첫 번째 숫자를 입력하세요: ");
            int a = scan.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = scan.next().charAt(0);

            if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
                System.out.println("잘못된 연산자가 입력되었습니다.");
                return;
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int b = scan.nextInt();

//            TODO: 스코프 범위로 인해 객체가 계속 생성되면서 덮어쓰기 된다는 점 조심하기
//            calculator = new Calculator(a, b, operator);

            try {
                result = calculator.calculate(a, b,  operator);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, delete 입력 시 처음 결과 삭제)");
            input = scan.next();
            if (input.equalsIgnoreCase("delete")) {
                calculator.removeResult();
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println(calculator.getList());
        System.out.println("계산기를 종료합니다.");
    }
}
