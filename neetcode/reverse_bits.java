package org.example.neetcode;

public class reverse_bits {
    public int reverseBits(int n) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                binary.append("1");
            } else {
                binary.append("0");
            }
        }

        String s = binary.toString();

        int res = 0;
        String reversedBinary = binary.reverse().toString();
        for (int i = 0; i < 32; i++) {
            if (reversedBinary.charAt(i) == '1') {
                res += (1 << i);
            }
        }

        return res;
    }

    void main() {
        int ans = reverseBits(21);
    }
}
