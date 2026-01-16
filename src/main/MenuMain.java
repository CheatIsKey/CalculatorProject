package main;

import java.util.NoSuchElementException;

import static main.InputMenu.findMenuByNumber;

public class MenuMain {
    public static InputMenu initMenu() {
        while (true) {
            selectMenuText();
            int menuNum = InputUtils.inputPrint("숫자를 입력해주세요: ", Integer::parseInt);
            try {
                return findMenuByNumber(menuNum);
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void selectMenuText() {
        System.out.println("-------------------------");
        System.out.println("메뉴를 선택 해주세요.");
        System.out.println("1. 계산하기");
        System.out.println("2. 계산 결과 목록 조회");
        System.out.println("3. 첫 번째 계산 결과 삭제");
        System.out.println("4. 입력 값보다 큰 계산 결과 조회");
        System.out.println("0. 종료하기");
        System.out.println("-------------------------");
    }
}
