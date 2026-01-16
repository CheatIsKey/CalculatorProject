package main;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum InputMenu {
    CALCULATE(1),
    PRINT_RESULT(2),
    REMOVE_FIRST_RESULT(3),
    PRINT_GREATER_RESULT(4),
    EXIT(0);

//    ENUM 생성자는 자동으로 private 타입이다.
    InputMenu(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    private final int menuNumber;

    public static InputMenu findMenuByNumber(int menuNumber) {
        return Arrays.stream(InputMenu.values())
                .filter(x -> x.menuNumber == menuNumber)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("없는 메뉴 번호입니다. 다시 입력해주세요."));
    }
}