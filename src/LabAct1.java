import java.util.Scanner;

public class LabAct1 {
    public LabAct1() {
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strg = "";
        String acceptedStringInput = "";
        String reversedString = "";
        System.out.print("Enter word/phrase: ");
        strg = input.nextLine();
        String lowercaseString = strg.toLowerCase();
        char[] var6 = lowercaseString.toCharArray();
        int var7 = var6.length;

        for(int var8 = 0; var8 < var7; ++var8) {
            char word = var6[var8];
            if (word != ' ' & Character.isLetter(word)) {
                acceptedStringInput = acceptedStringInput + word;
            }
        }

        for(int i = acceptedStringInput.length() - 1; i >= 0; --i) {
            reversedString = reversedString + acceptedStringInput.charAt(i);
        }

        if (acceptedStringInput.equals(reversedString)) {
            System.out.println(strg + " is a palindrome");
        } else {
            System.out.println(strg + " is NOT a palindrome");
        }

    }
}
