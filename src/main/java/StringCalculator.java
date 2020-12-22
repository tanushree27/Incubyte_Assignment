import java.util.regex.*;
public class StringCalculator {

    public int add (String str) {
        if (str.length() == 0)
            return 0;

        String defaultDelimiter = ",";
        String customDelimiter;
        boolean isDelimiterPresent = false;
        String[] numbers = new String[str.length()];

        if(str.startsWith("//"))
        {
            isDelimiterPresent = true;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
            m.matches();
            customDelimiter = m.group(1);
            String numbersLeft = m.group(2);
            numbers = numbersLeft.split(customDelimiter);
        }

        if(!isDelimiterPresent)
        {
            str = str.replaceAll("\n", defaultDelimiter);
            numbers = str.split(defaultDelimiter);
        }

        int sum = 0;

        for(String s : numbers)
        {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
