package com.example;

import com.example.calculator.Calculator;
import com.example.calculator.InputMenu;
import com.example.calculator.Operator;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MenuMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator calculator = new Calculator();

//        TODO: 최초 1회는 실행되고 그 이후에 반복할지 여부를 판단하기 위해, do-while() 반복문 사용하기
        do {
            int inputNum = selectMenu(scan);

            try {
                switch (InputMenu.findMenuByNumber(inputNum)) {
                    case CALCULATE:
                        calculateMode(scan, calculator);
                        break;
                    case PRINT_RESULT:
                        checkResult(calculator);
                        break;
                    case REMOVE_FIRST_RESULT:
                        removeFirstResult(calculator);
                        break;
                    case EXIT:
                        System.out.println("계산기를 종료합니다.");
                        scan.close();
                        return;
                    default:
                        System.out.println("잘못된 입력이 들어왔습니다.");
                        System.out.println("계산기를 다시 시작합니다.");
                        continue;
                }
            } catch (NoSuchElementException e) {
                System.out.println("지원하지 않는 메뉴입니다.");
                continue;
            }


//            int result = 0;

//            System.out.print("첫 번째 숫자를 입력하세요: ");
//            int a = scan.nextInt();
//            int a = inputOperand(scan, "첫 번째 숫자를 입력하세요: ");

//            System.out.print("사칙연산 기호를 입력하세요: ");
//            char operator = scan.next().charAt(0);
//            char operator = inputOperator(scan, "사칙연산 기호를 입력하세요: ");

//            if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/')) {
//                System.out.println("잘못된 연산자가 입력되었습니다.");
//                continue;
//            }

//            System.out.print("두 번째 숫자를 입력하세요: ");
//            int b = scan.nextInt();
//            int b = inputOperand(scan, "두 번째 숫자를 입력하세요: ");


//            TODO: 스코프 범위로 인해 객체가 계속 생성되면서 덮어쓰기 된다는 점 조심하기
//            calculator = new Calculator(a, b, operator);

//            try {
//                result = calculator.calculate(a, b, operator);
//                calculator.addResult(result);
//                System.out.println("결과: " + result);
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }

//            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료, delete 입력 시 처음 결과 삭제)");
//            input = scan.next();
//            TODO:
//             삭제된 원소를 출력하고 남아있는 리스트 목록 보여주기
//            if (input.equalsIgnoreCase("delete")) {
//                 TODO:
//                  컬렉션에 아무것도 없는 경우, 안내 메시지 출력하고
//                  값이 있는 경우, 결과 반환하기
//            if (calculator.isEmpty()) {
//                System.out.println("현재 저장된 계산 결과가 없습니다.");
//            } else {
//                int removed = calculator.removeResult();
//                System.out.println("삭제된 원소: " + removed);
//                System.out.println("현재 저장된 계산 결과 목록: " + calculator.getList());
//            }
        } while (true);
//        System.out.println(calculator.getList());
//        System.out.println("계산기를 종료합니다.");
    }

    private static int selectMenu(Scanner scan) {
        int input;

        while (true) {
            System.out.println("-------------------------");
            System.out.println("메뉴를 선택 해주세요.");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 결과 목록 조회");
            System.out.println("3. 첫 번째 계산 결과 삭제");
            System.out.println("0. 종료하기");
            System.out.println("-------------------------");
            System.out.print("숫자를 입력해주세요: ");

            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자로 다시 입력해주세요.");
                scan.next();
                continue;
            }

//            TODO: ENUM으로 예외적인 상황을 간단하게 대처할 수 있다.
//            if (input == 1 || input == 2 || input == 3 || input == 0) {
//                return input;
//            }
//
//            System.out.println("잘못된 번호가 입력되었습니다.");
            return input;
        }
    }

    private static void calculateMode(Scanner scan, Calculator calculator) {
        while (true) {
            double result = 0;
            double a = inputOperand(scan, "첫 번째 숫자를 입력하세요: ");
            char operator = inputOperator(scan, "사칙연산 기호를 입력하세요: ");
            double b = inputOperand(scan, "두 번째 숫자를 입력하세요: ");

            try {
                result = calculator.calculate(a, b, operator);
                calculator.addResult(result);
                System.out.println("결과: " + result);
                System.out.print("현재 입력된 결과보다 큰 계산 결과 목록: ");
                System.out.println(Arrays.toString(calculator.getGreaterResult(result)));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String input = scan.next();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }

    private static double inputOperand(Scanner scan, String msg) {
        double num = 0;

        while (true) {
            System.out.print(msg);
            try {
                num = scan.nextDouble();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
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

//            TODO: 2번 변환할 필요가 없어보이는데, 수정할 방법을 아직 못찾았다.
            try {
                return switch (Operator.findOperator(operator).orElseThrow(IllegalArgumentException::new)) {
                    case PLUS -> '+';
                    case MINUS -> '-';
                    case MULTIPLY -> '*';
                    case DIVIDE -> '/';
                };
            } catch (IllegalArgumentException e) {
                System.out.println("연산자가 잘못 입력되었습니다.");
                continue;
            }

//            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
//                return operator;
//            }

//            System.out.println("연산자가 잘못 입력되었습니다.");
        }
    }

    private static void checkResult(Calculator calculator) {
        if (calculator.isEmpty()) {
            System.out.println("현재 저장된 계산 결과가 없습니다.");
        } else {
            System.out.println("현재 저장된 계산 결과 목록: " + calculator.getList());
        }
    }

    private static void removeFirstResult(Calculator calculator) {
        if (calculator.isEmpty()) {
            System.out.println("현재 저장된 계산 결과가 없습니다.");
        } else {
            double removed = calculator.removeResult();
            System.out.println("삭제된 원소: " + removed);
            System.out.println("현재 저장된 계산 결과 목록: " + calculator.getList());
        }
    }
}
