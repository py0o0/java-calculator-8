package calculator;

public class Calculator {

    public static int add(String input) {
        if(!verifyInput(input)){ // 인풋 검증
            return 0;
        }

        String[] delAndInput = checkDelimiter(input); // 구분자
        String delimiter = delAndInput[0];
        String rawNumbers = delAndInput[1];

        int answer = 0;
        try {
            answer = calculate(rawNumbers, delimiter,'+'); // 연산자에 따라 사칙 연산 가능
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

        return answer;
    }

    private static boolean verifyInput(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] checkDelimiter(String input) {
        String delimiter = ",|:"; // 기본 구분자(정규식)
        String rawNumbers = input;

        if (input.startsWith("//")) { // 커스텀 구분자 처리
            String[] temp = input.split("\\\\n"); // 이스케이프 \n 처리 -> //커스텀 , rawNumbers로 분리

            delimiter = temp[0].substring(2);
            rawNumbers = temp[1];
        }
        return new String[]{delimiter, rawNumbers};
    }

    private static int calculate(String rawNumbers, String delimiter,char operator) {
        String[] numbers = rawNumbers.split(delimiter);
        int value = 0;

        for (String number : numbers) {
            int num;
            try {
                num = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 사용 가능합니다");
            }

            if (num < 0) {
                throw new IllegalArgumentException("음수는 사용하지 못 합니다");
            }

            switch (operator) {
                case '+':
                    value += num;
                    break;
                case '-':
                    value -= num;
                    break;
                case '*':
                    value *= num;
                    break;
                case '/':
                    value /= num;
                    break;
            }
        }

        return value;
    }
}