import java.util.Scanner;
import java.lang.Math;

public class PerfectlyBalanced {
    public static void main(String[] args) {
        int number = getNumber();
        int[] digits = getDigits(number);
        boolean increasing = isIncreasing(digits);
        if (increasing == true) {
            System.out.printf("The digits of %d are in increasing order.", number);
        }
        else if (increasing == false) {
            System.out.printf("The digits of %d are not in increasing order.", number);
        }

    }

    public static boolean isIncreasing(int[] values) {
        for (int i=0; i < values.length - 1; i++) {

            if (values[i] > values[i+1] || values[i] == values[i+1]) {
                return false;
            }
            // for loop checks every index and determines if current index is greater than the next index
            // if it is or current index and next index equal one another then it's not in increasing order and return false
        }
        return true;
        // if loop iterates and doesn't return false, then it returns true
    }

    public static int getNumber() {
        Scanner input = new Scanner(System.in);
        int selection  = 0;

        while (selection <= 0) {
            System.out.println("Please enter a positive number: ");
            selection = input.nextInt();
            // while loop is to validate that the user enters a positive number so anything greater than 0, not less or equal to zero
        }

        return selection;
    }

    public static int[] getDigits(int number) {
        double digits = Math.log10(number);
        double num_digits = Math.ceil(digits);
        // by using log function and "ceiling" that number, we can get the number of digits in a number to determine length of array
        int last_array_element = (int)num_digits-1;
        int[] numbers = new int[(int)num_digits];
        // last array element is given by last_array_element because the index of the last element is always one less than the amount of digits
        numbers[last_array_element] = number % 10;
        // gives the last number in user inputted string and saves it into last place in array
        double floor_number = number / 10;
        double floored = Math.floor(floor_number);
        // gives us the remaining digits excluding the last digit in user inputted number to be ran in the for loop
        for (int i = 1; i < (int)num_digits; i++) {
            double next_digit = floored % 10;
            numbers[last_array_element - i] = (int)next_digit;
            // next digit is given by using modulo but this digit has to be divided by 10 then floored in order to get the next digits, which is why a for loop is needed
            double to_be_floored = floored / 10;
            double floored_nextdigit = Math.floor(to_be_floored);
            floored = floored_nextdigit;

        }

        return numbers;
    }

}

