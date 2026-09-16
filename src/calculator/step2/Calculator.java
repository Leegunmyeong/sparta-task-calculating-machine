package calculator.step2;


import java.util.ArrayList;
import java.util.List;

class Calculator {

    /* 속성
    * private 접근 제어자: 외부 클래스(App)에서 results 변수에 직접 접근(수정/삭제)못하도록 캡슐화 진행
    * List<Integer>: 인터페이스(List)를 타입으로 선언 -> 추후 다른 리스트로 변경할 때 유연성 확보
    * 주의: 지금 단계는 메모리 공간이 할당되지 않는 null 상태 -> 이 상태에서 바로 값을 넣으면 NullPointerException 에러가 발생
    * */

    private List<Integer> results;

    /* 생성자
    *  역할: App.java에서 new Calculator()로 객체가 생성될 때 JVM에 의해
    *       가장 먼저 자동으로 호출되는 초기화 메서드
    *  () -> 외부에서 전달받을 데이터가 없는 기본 생성자 형태
    *  this.results: 현재 생성된 객체 자신 -> 내부에서 선언된 results 명확하게 지정
    *  new ArrayList<>(): 텅 빈 results 변수에 연산 결과를 저장할 수 있는 배열 생성 및 할당
    * */
    public Calculator() {
        this.results = new ArrayList<>();
    }


    /* 기능
    *  두 정수와 기호(연산자)를 전달 받아서 사칙연산 수행하고 결과를 내부 리스트에 기록한 뒤 반환
    *  num1(첫 번째 정수), num2(두 번째 정수), operator(사칙연산 기호) 외부 값 받아들이기 위해 선안한 매개변수
    *  연산식안으로 들어가면 num1, num2는 피연자 라고 불림 (연산자 관점)
    *  계산되어 나온 최종 연산 결과 값 (int)
    * */
    // public int: 메서드가 모든 작업 끝내고 최종적으로 담는 값의 타입
    public int calculate(int num1, int num2, char operator) {
        // 연산 결과를 임시로 저장할 지역 변수
        int result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("결과: " + result);
                break; // break를 만나야 아래 case로 넘어가지 않고 switch문 탈출
            case '-':
                result = num1 - num2;
                System.out.println("결과: " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("결과: " + result);
                break;
            case '/':
               /*
                * 예외 처리
                * 자바에서 정수를 0으로 나누면 ArithmeticException 에러가 발생하여 프로그램이 강제 종료
                * 조건문으로 미리 방어 코드 작성
                */
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                } else {
                    result = num1 / num2;
                    System.out.println("결과(몫): " + result);
                }
                break;
            default:
                // 지정된 사칙연산 기호 이외의 문자가 입력되었을 때 실행되는 예외
                System.out.println("잘못된 값을 입력했습니다.");
                break;
        }
        // 결과를 리스트에 추가
        // 생성자에게 메모리 할당 받은 results 리스트에 계산결과 result를 저장
        results.add(result);

        // 호출한 App.java 클래스로 계산된 최종 결과를 전달
        return result;
    }


    // getter[메서드]
    // private로 캡슐화된 results 변수 값을 외부에서 읽기 및 조회를 할 수 있도록 도와주는 기능
    public List<Integer> getResults() {
        return results;
    }

    // setter[메서드]
    // 외부에서 전달받은 리스트(results)로 현재 객체의 results 속성을 전체 교체/설정하는 메서드
    public void setResults(List<Integer> results) {
        this.results = results;
    }
}

