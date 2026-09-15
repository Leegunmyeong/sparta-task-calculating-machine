package calculator.step2;


import java.util.ArrayList;
import java.util.List;

class Calculator {

    // 속성
    // 캡슐화 private
    // 정수 여러개를 순서대로 담는 목록 자료형
        private List<Integer> results;
    // 생성자
    // 빈 리스트 생성
        public Calculator() {
            this.results = new ArrayList<>();
        }
    // 기능
    // public int: 메서드가 모든 작업 끝내고 최종적으로 담는 값의 타입
    public int calculate(int num1, int num2, char operator) {
        int result = 0;
            switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("결과: " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("결과: " + result);
                break;
            case '*':
                System.out.println("결과: " + (num1 * num2));
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다");
                } else {
                    result = num1 / num2;
                    System.out.println("결과(몫): " + result);
                }
                break;
            default:
                System.out.println("잘못된 값을 입력했습니다.");
                break;
        }
        // 결과를 리스트에 추가
        results.add(result);
        // 최종 결과값 반환
        return  result;
    }

    public List<Integer> getResults() {
        return results;
    }

    public void setResults(List<Integer> results) {
        this.results = results;
    }
}

