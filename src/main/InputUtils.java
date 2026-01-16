package main;

import java.util.Scanner;
import java.util.function.Function;

public class InputUtils {
//    필드를 보호하고 메서드를 열어서 캡슐화를 충족하기
    private static final Scanner scan = new Scanner(System.in);

//        scan.next()로 입력받는 문자열 데이터를 parser로 변환되는지 여부 판단
    public static <T> T inputPrint(String prompt, Function<String, T> parser) {
        while (true) {
            System.out.print(prompt);
            String input = scan.next();

            try {
                return parser.apply(input);
            } catch (Exception e) {
                System.out.println("입력 형식이 잘못되었습니다. 다시 시도해주세요");
            }
        }
    }
}
