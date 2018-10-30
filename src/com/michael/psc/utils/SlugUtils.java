package com.michael.psc.utils;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class SlugUtils {

    public static final Font PLAIN_32 = new Font("plain_32", Font.PLAIN, 32);
    public static final Font PLAIN_48 = new Font("plain_48", Font.PLAIN, 48);
    public static final Font PLAIN_64 = new Font("plain_64", Font.PLAIN, 64);
    public static final Font PLAIN_72 = new Font("plain_72", Font.PLAIN, 72);

    public static final Font BOLD_32 = new Font("bold_32", Font.BOLD, 32);
    public static final Font BOLD_48 = new Font("bold_48", Font.BOLD, 48);
    public static final Font BOLD_64 = new Font("bold_64", Font.BOLD, 64);
    public static final Font BOLD_72 = new Font("bold_72", Font.BOLD, 72);

    public static final Font ITALIC_32 = new Font("italic_32", Font.ITALIC, 32);
    public static final Font ITALIC_48 = new Font("italic_48", Font.ITALIC, 48);
    public static final Font ITALIC_64 = new Font("italic_64", Font.ITALIC, 64);
    public static final Font ITALIC_72 = new Font("italic_72", Font.ITALIC, 72);

    public static int calcScore(String s1, String s2) {

        int score = s1.length();
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) {

            for(int i=0; i<len2; ++i) {

                if(s1.charAt(i) != s2.charAt(i))
                    score--;

            }
            score -= len1 - len2;

        }
        else {

            for(int i=0; i<len1; ++i) {

                if(s1.charAt(i) != s2.charAt(i))
                    score--;

            }
            score -= len2 - len1;

        }

        return score;

    }

    public static int calcSortedScore(String s1, String s2) {

        return calcScore(sortString(s1), s2);

    }

    public static String compareNum(String s1, String s2) {

        int len1 = s1.length(), len2 = s2.length();
        String res = "";
        if(len1 > len2) {

            for(int i=0; i<len2; ++i) {

                if(s1.charAt(i) == s2.charAt(i))
                    res = res + "C";
                else
                    res = res + "i";

            }
            for(int j=0; j<len1-len2; ++j) {

                res = res + "a";

            }

        }
        else {

            for(int i=0; i<len1; ++i) {

                if(s1.charAt(i) == s2.charAt(i))
                    res = res + "C";
                else
                    res = res + "i";

            }

            for(int j=0; j<len2-len1; ++j) {

                res = res + "e";

            }
        }

        return res;

    }

    public static int getMaxPrefixLength(String s1, String s2) {

        int tot = 0, len1 = s1.length(), len2 = s2.length();
        for(int i=0; i < len1 && i < len2; ++i) {

            if(s1.charAt(i) == s2.charAt(i)) {
                tot += 1;
            }
            else {
                break;
            }
        }
        return tot;
    }

    public static int getMaxSortedPrefixLength(String s1, String s2) {

        return getMaxPrefixLength(sortString(s1), s2);

    }

    public static int getEditDistance(String s1, String s2) {

        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1+1][len2+1];

        for(int i=0; i<=len1; ++i)
                dp[i][0] = i;
        for(int j=0; j<=len2; ++j)
                dp[0][j] = j;

        for(int i=1; i<=len1; ++i)
            for(int j=1; j<=len2; ++j) {

                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];

                else
                    dp[i][j] = java.lang.Math.min(dp[i-1][j-1], java.lang.Math.min(dp[i-1][j], dp[i][j-1])) + 1;

            }

        return dp[len1][len2];

    }

    public static int getReversedEditDistance(String s1, String s2) {

        StringBuilder builder = new StringBuilder(s1);
        return getEditDistance(builder.reverse().toString(), s2);

    }

    public static String sortString(String s) {

        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);

    }

    public static void writeDataFromMap(String file, Map<String, Object> map) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

        } catch(IOException exception) {
            System.out.println("Error occurred while opening file.");
        }

        pw.print("{");
        int index = 0;
        for(Map.Entry<String, Object> entry : map.entrySet()) {

            pw.print("\"" + entry.getKey() + "\": ");
            //pw.print("\"" + entry.getValue().toString() + "\"");
            Object obj = entry.getValue();
            if(obj instanceof ArrayList) {
                ArrayList array = (ArrayList) obj;
                pw.print("[");

                for(int j = 0; j < array.size(); ++j) {

                    pw.print("\"" + array.get(j).toString() + "\"");
                    if(j != array.size() - 1)
                        pw.print(",");
                }
                pw.print("]");

            }
            else {
                pw.print("\"" + obj.toString() + "\"");
            }
            index++;

            if(index != map.size()) {
                pw.print(",");
            }
        }
        pw.print("},\n");

        try {
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException exception) {
            System.out.println("Error ocurred while closing file.");
        }
    }

    public static ArrayList<String> generateNumbers(long seed, int lbound, int ubound, int mul) {

        ArrayList<String> array = new ArrayList<String>();

        if(ubound < lbound)
            return array;

        Random random = new Random(seed);

        for(int digits = lbound; digits <= ubound; ++digits) {
            for(int c = 0; c < mul; ++c) {

                StringBuilder builder = new StringBuilder();

                for(int index = 0; index < digits; ++index) {
                    builder.append(random.nextInt(10));
                }

                array.add(builder.toString());
            }
        }

        return array;
    }
}
