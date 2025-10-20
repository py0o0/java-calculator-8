package calculator;

public class DelimiterParser {
    private final String delimiter;
    private final String rawNumbers;

    public DelimiterParser(String input) {
        if (input.startsWith("//")) {
            String[] temp = input.split("\\\\n", 2);
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
