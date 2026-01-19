package main;

import main.exception.CalculateException;
import main.exception.DivideException;

import java.util.Arrays;

import static main.InputMenu.EXIT;

public class Main {
    public static void main(String[] args) {
        InputMenu inputMenu;

        // 계산기 객체 생성하기
        Calculator calculator = new Calculator();

        do {
            inputMenu = MenuMain.initMenu();

            switch (inputMenu) {
                case CALCULATE -> {
                    int num1 = InputUtils.inputPrint("첫 번째 숫자를 입력해주세요: ", Integer::parseInt);
                    char operator = InputUtils.inputPrint("연산자를 입력해주세요: ", c -> c.charAt(0));
                    int num2 = InputUtils.inputPrint("두 번째 숫자를 입력해주세요: ", Integer::parseInt);

                    try {
                        System.out.println(calculator.calculate(num1, num2, operator));
                    } catch (CalculateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case PRINT_RESULT -> {
                    if (calculator.getResults().isEmpty()) {
                        System.out.println("현재 저장된 계산 결과가 없습니다.");
                    } else {
                        System.out.println("현재 저장된 계산 결과 목록: " + calculator.getResults());
                    }
                }
                case REMOVE_FIRST_RESULT -> {
                    if (calculator.isEmpty()) {
                        System.out.println("현재 저장된 계산 결과가 없습니다.");
                    } else {
                        System.out.println("삭제된 원소: " + calculator.removeResult());
                        System.out.println("현재 저장된 계산 결과 목록: "+ calculator.getResults());
                    }
                }
                case PRINT_GREATER_RESULT -> {
                    int input = InputUtils.inputPrint("비교할 값을 입력해주세요: ", Integer::parseInt);
                    System.out.println(Arrays.toString(calculator.getGreaterResult(input)));
                }
                case EXIT -> {
                    System.out.println("계산기를 종료합니다.");
                }
                default -> {
                    System.out.println("문제가 발생했습니다.");
                    System.out.println("계산기를 종료합니다.");
                    return;
                }
            }
        } while (inputMenu != EXIT);
    }
}
