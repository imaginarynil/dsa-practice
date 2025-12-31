package org.example.leet_code;

public class add_binary {
    public char[] reverse(char[] arr) {
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public int toInt(char digit) {
        return digit - '0';
    }

    public String addBinary(String a, String b) {
        char[] aArr = reverse(a.toCharArray());
        char[] bArr = reverse(b.toCharArray());
        int i = 0;
        int j = 0;
        int carry = 0;
        int sum = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (i < a.length() || j < b.length()) {
            int currA = i < a.length() ? toInt(aArr[i]) : 0;
            int currB = j < b.length() ? toInt(bArr[j]) : 0;
            sum = (carry + currA + currB) % 2;
            carry = (carry + currA + currB) / 2;
            strBuilder.append(sum);
            i = Math.min(i + 1, a.length());
            j = Math.min(j + 1, b.length());
        }
        if (carry > 0) {
            strBuilder.append(carry);
        }
        String result = strBuilder.reverse().toString();
        return result;
    }

    // using charAt can speed up the program compared to converting the string to an array
    public String addBinary_Optimal(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int sum = 0;
        int carry = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int currA = i >= 0 ? toInt(a.charAt(i)) : 0;
            int currB = j >= 0 ? toInt(b.charAt(j)) : 0;
            sum = carry + currA + currB;
            carry = sum / 2;
            strBuilder.append(sum % 2);
            i--;
            j--;
        }
        if (carry > 0) {
            strBuilder.append(carry);
        }
        String result = strBuilder.reverse().toString();
        return result;
    }

    void main() {
//        String a = "11";
//        String b = "1";
//        var x = addBinary_Optimal(a, b);

        String a = "1010";
        String b = "1011";
        var x = addBinary_Optimal(a, b);
    }
}
