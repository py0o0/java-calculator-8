package calculator;

public class DelimiterParser {
    private final String delimiter;
    private final String rawNumbers;

    public DelimiterParser(String input) {
        if (input.startsWith("//")) { // 커스텀 구분자 사용 시
            String[] temp = input.split("\\\\n", 2);

            if(temp.length < 2) {
                throw new IllegalArgumentException("숫자가 포함되어 있지 않습니다.");
            }

            String custom = temp[0].substring(2);
            if(custom.isEmpty()) { // 커스텀 문자열이 개행 문자
                custom = "\\\\n";
                temp[1] = temp[1].substring(2);
            }

            delimiter = ",|:" + "|" + custom;
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
