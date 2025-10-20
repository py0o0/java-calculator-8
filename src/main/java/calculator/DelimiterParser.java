package calculator;

public class DelimiterParser {
    private final String delimiter;
    private final String rawNumbers;

    public DelimiterParser(String input) {
        if (input.startsWith("//")) {
            String[] temp = input.split("\\\\n", 2); // \n이 커스텀 구분자일 수도 있으니 limit 2

            if(temp.length < 2) {
                throw new IllegalArgumentException("숫자가 포함되어 있지 않습니다.");
            }

            delimiter = ",|:" + "|" + temp[0].substring(2);
            rawNumbers = temp[1];
        } else {
            delimiter = ",|:";
            rawNumbers = input;
        }
    }

    public String getDelimiter(){
        return delimiter;
    }

    public String getRawNumbers(){
        return rawNumbers;
    }
}
