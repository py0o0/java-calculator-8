package calculator;

import java.util.regex.Pattern;

public class Add {

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자(정규식)
        String rawNumbers = input;

        if (input.startsWith("//")) { // 커스텀 구분자 처리
            String[] temp = input.split("\\\\n"); // 이스케이프 \n 처리 -> //커스텀 , rawNumbers로 분리

            delimiter = temp[0].substring(2);
            rawNumbers = temp[1];
        }

        String[] numbers = rawNumbers.split(delimiter);
        int sum = 0;

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

            sum += num;
        }

        return sum;
    }
}