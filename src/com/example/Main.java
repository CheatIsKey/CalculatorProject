package com.example;

import com.example.calculator.Calculator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input = "";

//        TODO: 최초 1회는 실행되고 그 이후에 반복할지 여부를 판단하기 위해, do-while() 반복문 사용하기
        do {
            int result = 0;

//            System.out.print("첫 번째 숫자를 입력하세요: ");
//            int a = scan.nextInt();
            int a = inputOperand(scan, "첫 번째 숫자를 입력하세요: ");

//            System.out.print("사칙연산 기호를 입력하세요: ");
//            char operator = scan.next().charAt(0);
            char operator = inputOperator(scan, "사칙연산 기호를 입력하세요: ");

//            if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
//                System.out.println("잘못된 연산자가 입력되었습니다.");
//                continue;
//            }

//            System.out.print("두 번째 숫자를 입력하세요: ");
//            int b = scan.nextInt();
            int b = inputOperand(scan, "두 번째 숫자를 입력하세요: ");


//            TODO: 스코프 범위로 인해 객체가 계속 생성되면서 덮어쓰기 된다는 점 조심하기
//            calculator = new Calculator(a, b, operator);

            try {
                result = calculator.calculate(a, b, operator);
                calculator.addResult(result);
                System.out.println("결과: " + result);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, delete 입력 시 처음 결과 삭제)");
            input = scan.next();
//            TODO:
//             삭제된 원소를 출력하고 남아있는 리스트 목록 보여주기
            if (input.equalsIgnoreCase("delete")) {
//                 TODO:
//                  컬렉션에 아무것도 없는 경우, 안내 메시지 출력하고
//                  값이 있는 경우, 결과 반환하기
                if (calculator.isEmpty()) {
                    System.out.println("현재 저장된 계산 결과가 없습니다.");
                } else {
                    int removed = calculator.removeResult();
                    System.out.println("삭제된 원소: " + removed);
                    System.out.println("현재 저장된 계산 결과 목록: " + calculator.getList());
                }
            }
        } while (!input.equalsIgnoreCase("exit"));

        System.out.println(calculator.getList());
        System.out.println("계산기를 종료합니다.");
    }

    private static int inputOperand(Scanner scan, String msg) {
        int num = 0;

        while (true) {
            System.out.print(msg);
            try {
                num = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수만 입력 가능합니다.");
                scan.next();
                continue;
            }
            break;
        }

        return num;
    }

    private static char inputOperator(Scanner scan, String msg) {
        while (true) {
            System.out.print(msg);
            char operator = scan.next().charAt(0);

            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                return operator;
            }

            System.out.println("연산자가 잘못 입력되었습니다.");
        }
    }
}
