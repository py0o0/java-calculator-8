package calculator;

public class NumberParser {
    private final int[] numbers;

    public NumberParser(String rawNumbers, String delimiter) {
        String[] token = rawNumbers.split(delimiter);
        numbers = new int[token.length];

        for(int i = 0; i < token.length; i++) {
            try {
                numbers[i] = Integer.parseInt(token[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 사용 가능합니다");
            }

            if (numbers[i] < 0) {
                throw new IllegalArgumentException("음수는 사용하지 못 합니다");
            }
        }
    }

    public int[] getNumber() {
        return numbers;
    }
}
