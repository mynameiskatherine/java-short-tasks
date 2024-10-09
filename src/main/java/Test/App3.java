package Test;

import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App3 {
    public static void main(String[] args) throws IOException {
//        List<Integer> list = List.of(-2,4,6,-8,2,8,3,1);
//        System.out.println(String.valueOf(getClosetToZero(list)));
//
//        System.out.println(collinearity(-434, -503, 980, -849));
//        System.out.println(isValid("(){}[]"));
//        System.out.println(factorial(150));
//        int[] nums = new int[]{};
//        int val = 2;
//        System.out.println(removeElement(nums, val));
//        System.out.println(Arrays.toString(nums));
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    static int getClosetToZero(List<Integer> list) {
        Integer result = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) {
                result = 0;
                break;
            }
            if (Math.abs(list.get(i)) <= Math.abs(result)) {
                if (Math.abs(list.get(i)) == Math.abs(result)) {
                    result = list.get(i) > result ? list.get(i) : result;
                } else {
                    result = list.get(i);
                }
            }
        }
        return result;
    }

    static String capitalize(String s) {
        return Arrays.stream(s.split(" "))
                .map(StringUtils::capitalize)
                .collect(Collectors.joining());
    }

    static void fizzBuzz() {
        for (int i = 0; i <= 1000; i++) {
            if (i % 3 == 0) {
                if (!(i % 5 == 0)) {
                    int res = 0;
                    int num = i;
                    while (num > 0) {
                        res = res + (num % 10);
                        num = num / 10;
                    }
                    if (num < 10) {
                        System.out.println(i);
                    }
//                    int sum = Arrays.stream(String.valueOf(i).split(""))
//                            .map(Integer::parseInt)
//                            .reduce((a, b) -> (a + b))
//                            .get();
//                    if (sum < 10) {
//                        System.out.println(i);
//                    }
                }
            }
        }
    }

    public static boolean collinearity(int x1, int y1, int x2, int y2) {
        if (((x1 == 0) && (y1 == 0)) || ((x2 == 0) && (y2 == 0))) {
            return true;
        }
        if (x1 == 0) {
            return x2 == 0 ? true : false;
        }
        if (y1 == 0) {
            return y2 == 0 ? true : false;
        }
        if (y2 == 0 || x2 == 0) {
            return false;
        }
        double xx = (double) x1 / x2;
        double yy = y1 / y2;
        System.out.println(xx + " " + yy);
        if (xx == yy) {
            return true;
        } else {
            return false;
        }
    }

    static void findStrangeStr() {
        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            String str = String.valueOf((char) i);
            String upDown = str.toUpperCase().toLowerCase();
            if (upDown.length() > str.length()) {
                System.out.println(str + " " + upDown);
                break;
            }
        }
    }

    public static int[] flip(char dir, int[] arr) {
        if (dir == 'R') {
            Arrays.sort(arr);
            return arr;
        } else {
            return Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
        }
    }

    static int quarterOf(int month) {
        return (int) Math.ceil(month / 3.);
    }



    static int intFromCh(char ch) {
        return switch (ch) {
            case 'I' | 'i' -> 1;
            case 'V' | 'v' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalStateException("Unexpected value: " + ch);
        };
    }

    public static boolean isValid(String s) {
        String test = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '}' || ch == ']' || ch == ')') {
                if (!test.isEmpty()) {
                    char prev = (char) (ch - 1);
                    char prevPrev = (char) (ch - 2);
                    if (test.charAt(test.length() - 1) == prev || test.charAt(test.length() - 1) == prevPrev) {
                        test = test.substring(0, test.length() - 1);
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                test = test + ch;
            }
        }
        return test.equals("");
    }

    public static String factorial(int n) {
        //add your code here
        if (n < 0) {
            return "0";
        } else if (n == 0) {
            return "1";
        } else {
            BigDecimal fact = BigDecimal.valueOf(1);
            for (int i = 1; i <= n; i++) {
                fact = BigDecimal.valueOf(i).multiply(fact);
            }
            return fact.toString();
        }
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        int e = nums.length;
        for (int i = 0; i < e; i++) {
            if (nums[i] == val) {
                while ((e - 1 > i) && (nums[e - 1] == val)) {
                    e = e - 1;
                }
                nums[i] = nums[e - 1];
                nums[e - 1] = val;
            }
            k = i;
        }
        return k;
    }

    public static int majorityElement(int[] nums) {
        int res = 0, count = 0;

        for(int n: nums) {
            if (count == 0) {
                res = n;
            }
            count = count + ((n == res) ? 1 : -1);
        }
        return res;
    }

    public static int jump(int[] nums) {
        int index = 0;
        int round = 0;
        while (index < nums.length - 1) {
            if (index + nums[index] >= nums.length - 1) {
                index = index + nums[index];
                round++;
            } else {
                int max = 0;
                int intIndex = 0;
                for (int i = index + 1; i <= index + nums[index]; i++) {
                    if (i + nums[i] < nums.length - 1) {
                        max = Math.max(max, i + nums[i]);
                        intIndex = i;
                    } else {
                        intIndex = i;
                        break;
                    }
                }
                index = intIndex;
                round++;
            }
        }
        return round;
    }

    public static int[] productExceptSelf(int[] nums) {
        final int n = nums.length;
        int[] strArr = new int[n];
        int[] oppArr = new int[n];
        int[] answer = new int[n];

        strArr[0] = 1;
        for (int j = 1; j < n; j++)
            strArr[j] = strArr[j - 1] * nums[j - 1];

        oppArr[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            oppArr[i] = oppArr[i + 1] * nums[i + 1];

        for (int k = 0; k < n; k++)
            answer[k] = strArr[k] * oppArr[k];

        return answer;
    }

    public static String reverseWords(String s) {
        String str = s.trim();
        int l = str.length();
        int start = l - 1;
        int finish = l;
        String m = "";
        StringBuilder strBldr = new StringBuilder();
        for (int i = l - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' || i == 0) {
                start = (i == 0) ? i : (i + 1);
                m = str.substring(start, finish);
                if (!m.isEmpty()) {
                    strBldr.append(m + " ");
                    finish = i;
                }
            }
        }
        return strBldr.toString().trim();
    }

}
