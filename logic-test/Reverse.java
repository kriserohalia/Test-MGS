import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String input = scanner.nextLine();

        String[] words = input.split(" ");

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(reverseString(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println("Output: " + result.toString());

        scanner.close();
    }

    private static String reverseString(String word) {
        char[] chars = word.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
        
        return new String(chars);
    }
}
