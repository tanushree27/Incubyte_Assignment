public class StringCalculator {

    public int add (String str) {
        if (str.length() == 0)
            return 0;

        String[] numbers = str.split(",");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = numbers.length == 2 ? Integer.parseInt(numbers[1]): 0;

        return num1 + num2;
    }
}
