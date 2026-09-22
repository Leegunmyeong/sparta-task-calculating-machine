package calculator.step1;

import java.util.Scanner;
//커밋 수정
public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int num1;
            int num2;
            System.out.println("====== 계산기 ======");
            System.out.println("""
                    계산을 위한 정수 2개를 입력해주세요😊
                    (예: 1, 2, 100..)
                    """);
            while (true) {
                System.out.print("첫 번째 숫자 입력👉 ");
                num1 = scanner.nextInt();
                if (num1 >= 0) {
                    break;
                } else {
                    System.out.println("잘못된 값을 입력하셨습니다");
                }
            }
            while (true) {
                System.out.print("두 번째 숫자 입력👉 ");
                num2 = scanner.nextInt();
                if (num2 >= 0) {
                    break;
                } else {
                    System.out.println("잘못된 값을 입력하셨습니다");
                }
            }
            System.out.println("======================================");
            System.out.println("""
                    원하시는 기능을 선택해주세요👀
                    ➕덧셈 입력기호(+)
                    ➖뺄셈 입력기호(-)
                    ✖️곱셈 입력기호(*)
                    ➗나눗셈(몫, 나머지) -> 입력기호(/)
                    """);
            System.out.print("기호 입력(하나의 기호만 입력해주세요): ");
            char selectCalculateFctSign = scanner.next().charAt(0);
            switch (selectCalculateFctSign) {
                case '+':
                    System.out.println("결과: " + (num1 + num2));
                    break;
                case '-':
                    System.out.println("결과: " + (num1 - num2));
                    break;
                case '*':
                    System.out.println("결과: " + (num1 * num2));
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                    } else {
                        System.out.println("결과: " + (num1 / num2));
                        System.out.println("나머지: " + (num1 % num2));
                    }
                    break;
                default:
                    System.out.println("잘못된 값을 입력했습니다.");
                    break;
            }
            System.out.println("======================================");
            System.out.println("""
                    계산기 종료 -> exit 입력
                    계속 이용 -> 아무 문자나 입력
                    """);
            System.out.print("입력:");
            String inputUserText = scanner.next();
            if (inputUserText.equals("exit")) {
                System.out.println("프로그램을 종료합니다.🙂‍↕️");
                break;
            }
            System.out.println();
        }
    }
}


