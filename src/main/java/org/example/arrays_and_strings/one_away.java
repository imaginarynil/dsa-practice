package org.example.arrays_and_strings;
import java.lang.Math;
import java.util.Arrays;
// ok
public class one_away {
    static boolean solve(String str_1, String str_2) {
        if(Math.abs(str_1.length() - str_2.length()) > 1) {
            return false;
        }
        if(str_1.length() == str_2.length()){
            int diffCount = 0;
            for(int i = 0; i < str_1.length(); i++){
                if(str_1.charAt(i) != str_2.charAt(i)){
                    diffCount += 1;
                    if(diffCount > 1){
                        return false;
                    }
                }
            }
            return true;
        }
        String s1 = str_1;
        String s2 = str_2;
        if(str_1.length() < str_2.length()){
            s1 = str_2;
            s2 = str_1;
        }
        int i = 0;
        int j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)){
                if(i != j){ // already skip 1 but found a second diff
                    return false;
                }
                i += 1; // skip 1 char at s1
            } else {
                i += 1;
                j += 1;
            }

        }
        return true;
    }

    static void main() {
        String[][] inputs = {
                {"pale", "ple"},
                {"pales", "pale"},
                {"pale", "bale"},
                {"pale", "bake"}
        };
        for(int i = 0; i < 4; i++) {
            System.out.println(solve(inputs[i][0], inputs[i][1]));
        }
    }
}
