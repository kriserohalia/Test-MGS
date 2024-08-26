import java.util.Arrays;
import java.util.Scanner;

public class CountNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("jumlah elemen dalam array: ");
        int n = scanner.nextInt();

        String[] array = new String[n];

        System.out.println("Masukkan elemen-elemen:");
        for (int i = 0; i < n; i++) {
            System.out.print("Elemen ke-" + (i + 1) + ": ");
            array[i] = scanner.next();
        }

        System.out.println(Arrays.toString(array));

        int count = countNumbers(array);
        System.out.println("Jumlah angka dalam array: " + count);

        scanner.close();
    }

    public static int countNumbers(String[] array) {
        int count = 0;
        for (String element : array) {
            if (isNumber(element)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isNumber(String str) {
        try {
            Integer.parseInt(str); 
            return true; 
        } catch (NumberFormatException e) {
            return false; 
        }
    }
}
