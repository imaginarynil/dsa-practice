package org.example.ctci.arrays_and_strings;

public class urlify {
    String solve(String input) {
        char[] arr = input.toCharArray();
        char charToReplace = ' ';
        String replacement = "%20";
        int i = 0;
        while (i < input.length()) {
            if (arr[i] == charToReplace) {
                // shift string after ' ' to the right
                for (int j = input.length() - 1; j > i; j--) {
                    arr[j] = arr[j - replacement.length() + 1];
                }
                for (int j = 0; j < replacement.length(); j++) {
                    arr[i + j] = replacement.charAt(j);
                }
            }
            i++;
        }
        return new String(arr);
    }

    // "Mr John Smith    "
    //                   ^ index (initial)

    String urlify_Solution(String input, int trueLength) {
        char[] charArray = input.toCharArray();
        int countSpace = 0;
        for (int i = 0; i < trueLength; i++) {
            if (charArray[i] == ' ') {
                countSpace += 1;
            }
        }
        // for every space char, need 2 additional spaces to fit the string "%20"
        // actual length - spaces occupied after moving chars
        int index = countSpace * 2 + trueLength;
        charArray[trueLength] = '\0';
        // "a b  "
        // "a   b"
        char[] replacement = new char[]{'%', '2', '0'};
        for (int i = trueLength - 1; i >= 0; i++) {
            if (charArray[i] == ' ') {
                charArray[index - 1] = replacement[2];
                charArray[index - 2] = replacement[1];
                charArray[index - 3] = replacement[0];
                index -= 3;
            } else {
                charArray[index - 1] = charArray[i];
                index -= 1;
            }
        }
        return new String(charArray);
    }

    void main() {
        String input = "Mr John Smith    ";
        System.out.println(solve(input));
    }
}
