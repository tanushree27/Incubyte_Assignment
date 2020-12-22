public class StringCalculator {

    public int add (String str) {
        if (str.length() == 0)
            return 0;

        String[] numbers = str.split(",");
        int sum = 0;

        for(String s : numbers)
        {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}
