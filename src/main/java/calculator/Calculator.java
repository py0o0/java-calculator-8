package calculator;

public class Calculator {

    public static int add(String input) {
        if(input == null || input.isEmpty()){
            return 0;
        }
        DelimiterParser delimiterParser = new DelimiterParser(input);
        String delimiter = delimiterParser.getDelimiter();
        String rawNumbers = delimiterParser.getRawNumbers();

        NumberParser numberParser = new NumberParser(rawNumbers, delimiter);

        int answer = calculate(numberParser.getNumber(),'+');

        return answer;
    }

    private static int calculate(int[] numbers,char operator) {
        int value = 0;

        for (int number : numbers) {

            switch (operator) {
                case '+':
                    value += number;
                    break;
                case '-':
                    value -= number;
                    break;
                case '*':
                    value *= number;
                    break;
                case '/':
                    value /= number;
                    break;
            }
        }

        return value;
    }
}