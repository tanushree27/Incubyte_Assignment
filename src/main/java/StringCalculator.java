import java.util.regex.*;
import java.util.*;

public class StringCalculator {

    public int add (String str) {
        if (str.length() == 0)
            return 0;

        String defaultDelimiter = ",";
        String customDelimiter;
        boolean isDelimiterPresent = false;
        String[] numbers = new String[str.length()];
        ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
        boolean negativeNumPresent = false;
        if(str.startsWith("//"))
        {
            isDelimiterPresent = true;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
            m.matches();
            customDelimiter = m.group(1);
            String numbersLeft = m.group(2);
            numbers = numbersLeft.split(Pattern.quote(customDelimiter));
        }

        if(!isDelimiterPresent)
        {
            str = str.replaceAll("\n", defaultDelimiter);
            numbers = str.split(defaultDelimiter);
        }

        int sum = 0;

        for(String s : numbers)
        {
            int num = Integer.parseInt(s);

            if(num > 1000) num = 0;

            if(num < 0)
            {
                negativeNumPresent = true;
                negativeNumbers.add(num);
            }
            sum += num;
        }

        if(negativeNumPresent)
        {
            StringBuilder negativeNumStr = new StringBuilder();
            for(int i = 0; i < negativeNumbers.size(); i++)
            {
                negativeNumStr.append(" "+negativeNumbers.get(i));
            }
            throw new RuntimeException("Negatives not allowed :"+negativeNumStr);
        }

        return sum;
    }
}
