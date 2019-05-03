import java.util.Scanner;
import java.lang.Math;

public class PerfectlyBalanced {
    public static void main(String[] args) {
        int digits = getDigits(1579);
        System.out.println(digits);

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
        }

        return selection;
    }

    public static int getDigits(int number) {
        int digits = Math.log10(number);
        System.out.println(digits);
        //int num_digits = Math.ceil(digits);
        return digits;

    }

}
