package calculator.step2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // System.in(키보드 입력 스트림)을 읽어들이는 Scanner 객체를 생성
        Scanner scanner = new Scanner(System.in);

        // 연산 및 결과 저장을 담당할 Calculator 객체 생성
        // Calculator의 생성자가 실행되어 내부 results 리스트 메모리 초기화 실행
        Calculator calculator = new Calculator();

        // 입력받은 정수를 저장하기 위해 사용할 변수 미리 선언
        int num1;
        int num2;

        // 메인 입력 반복문: 사용자가 exit를 입력해서 프로그램을 종료시키기 전까지 계산기 프로그램 작동 반복
        while (true) {
            System.out.println("====== 계산기 ======");
            System.out.println("""
                    계산을 위한 정수 2개를 입력해주세요😊
                    (예: 1, 2, 100..)
                    """);
            // 첫 번째 정수 입력 및 유효성 검사 반복문
            // 정상적인 값(0 이상의 양수)이 입력될 때까지 무한 반복 및 재입력 요구
            while (true) {
                System.out.print("첫 번째 숫자 입력👉 ");
                num1 = scanner.nextInt();
                if (num1 >= 0) {
                    break; // 유효성 검사 통과 시 탈출 -> 다음 반복문으로 넘어감
                } else {
                    System.out.println("잘못된 값을 입력하셨습니다");
                }
            }
            // 두 번째 정수 입력 및 유효성 검사 반복문
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
                    ➗나눗셈(몫) -> 입력기호(/)
                    """);


            System.out.print("기호 입력(하나의 기호만 입력해주세요): ");
            /*
             * 연산 기호 문자 추출
             * scanner.next()로 공백 전까지의 '문자열'을 가져온 뒤
             * .charAt(0)을 호출하여 맨 앞의 첫 번째 '문자(char)' 하나만 잘라낸다
             * */
            char selectCalculateFctSign = scanner.next().charAt(0);

            /* App클래스 직접 계산 X -> 인자값 -> num1(정수), num2(정수), selectCalculateFctSign(기호)
             * calculator 객체의 calculate 메서드로 전달하여 연산
             */
            calculator.calculate(num1, num2, selectCalculateFctSign);

            System.out.println("======================================");
            System.out.println("""
                    계산기 종료 -> exit 입력
                    계속 이용 -> 아무 문자나 입력
                    """);
            System.out.print("입력:");
            // 종료 여부 판단할 문자열 입력 받기
            String inputUserText = scanner.next();
            // 문자열 값 비교(.equals())
            // 자바에서 참조 자료형 String의 내용물 같은지 비교할 때 반드시 'equals()' 메서드를 사용
            // 이유 -> 메모리 주소값이 아닌 실제 문자열의 내용(값)을 비교하기 위해
            if (inputUserText.equals("exit")) {
                System.out.println("프로그램을 종료합니다.🙂‍↕️");
                break; // 메인 while 반복문 빠져나가 main 메서드가 끝난다
            }
            System.out.println(); // 줄바꿈을 주어 다음 계산기 실행 화면을 구분
        }
    }
}





