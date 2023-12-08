/*
 This program takes two decimal numbers of any amount of digits
 from the user, adds them and displays the result.
*/

public class AddDecimals
{
    /* This is a subroutine that reads any decimal number
     * from the keyboard, we can easily reuse it in any
     * other program we create in the future.
     */
    public static double readDecimal() throws Exception
    {
        double number = 0.0;
        int digitAsciiCode = 0;
        int digit = 0;
        int decimalCounter = 0;
        boolean foundDot = false;

        /* We follow the same exact process that we
         * did in readNumber() to generate an integer
         * number that includes all digits the user typed.
         * But we also keep track of how many digits we
         * read after the decimal dot.
         */

        digitAsciiCode = System.in.read();
        while (digitAsciiCode != '\n')
        {
            //Once we find a dot, we set a boolean flag
            if (digitAsciiCode == '.')
                foundDot = true;
            else
            {
                digit = digitAsciiCode - '0';
                number = number * 10 + digit;
                //If this digit showed up after we found the
                //decimal dot, then increment decimal counter.
                if (foundDot)
                    decimalCounter++;
            }
            digitAsciiCode = System.in.read();
        }

        /* This code generates a power of ten as large as
         * the number of decimal digits we counted */
        int divisor = 1;
        while (decimalCounter > 0)
        {
            divisor *= 10;
            decimalCounter--;
        }

        /* In order to get the actual decimal number the user
         * typed we simply divide by the divisor created above */
        number = number / divisor;
        return number;
    }

    public static void main(String[] args)
    {
        double number1 = 0.0, number2 = 0.0;
        System.out.println("Please enter a decimal number:");
        try
        {
            number1 = readDecimal();
            System.out.println("Please enter another decimal number:");
            number2 = readDecimal();

            double result = number1 + number2;

            System.out.println("The result of adding " + number1 +
                    " plus " + number2 + " is: " + result);
        }
        catch (Exception e)
        {
            System.out.println("Keyboard has failed!!!");
        }

    }

}