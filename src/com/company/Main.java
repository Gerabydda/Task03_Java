package com.company;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.math.BigInteger;
public class Main {
    public static int solutions(int a, int b, int c) {
        if(b==0 && c==0 && a!=0) return 1;
        if(a!=0 && b!=0 && c==0) return 2;
        if(a!=0 && b==0 && c!=0){
            if(a*c > 0) return 0;
            else return 2;
        }
        int d = b*b-4*a*c;
        if(d >0 ) return 2;
        if(d == 0) return 1;
        return 0;
    }
    public static int findZip(String s) {
        int firstIndex = s.indexOf("zip");
        return s.indexOf("zip", firstIndex+1);
    }
    public static boolean checkPerfect(int n) {
        int sum = 0;
        for (int j = 1; j<n; j++) {
            if (n%j == 0) sum +=j;
        }
        return (sum == n);
    }
    public static String flipEndChars(String s) {
        if(s.length()<2) return "Incompatible.";
        if(s.charAt(0)==s.charAt(s.length()-1)) return "Two\'s a pair.";
        return s.charAt(s.length()-1)+s.substring(1,s.length()-1)+s.charAt(0);

    }
    public static boolean isValidHexCode(String s) {
        if(s.length()!=7) return false;
        if(s.charAt(0)!='#') return false;
        for(char ch : s.substring(1,s.length()).toCharArray()){
            ch=Character.toUpperCase(ch);
            if(!((ch>='A' && ch<='F')||((ch>='0' && ch<='9')))) return false;
        }
        return true;

    }
    public static boolean same(int[] arr1, int[] arr2 ) {
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for(int n  : arr1){
            s1.add(n);
        }
        for(int n  : arr2){
            s2.add(n);
        }
        return s1.size() == s2.size();
    }
    public static boolean isKaprekar(int n) {
        String s = String.valueOf(n*n);

        String s1 = s.substring(0, s.length()/2);
        String s2 = s.substring(s.length()/2, s.length());
        return (s1.length()!=0)? Integer.parseInt(s1)+Integer.parseInt(s2) == n : Integer.parseInt(s2) == n;

    }
    public static String longestZero(String s) {
        String[] sArr = s.split("1");
        if(sArr.length == 0) return "";

        Arrays.sort(sArr);
        return (sArr[sArr.length-1].length()>0) ? sArr[sArr.length-1] : "";

    }
    public static int nextPrime(int n) {
        BigInteger bigInteger = BigInteger.valueOf(n);
        if(bigInteger.isProbablePrime((int) Math.log(n))) return n;

        while(true){
            n+=1;
            bigInteger = BigInteger.valueOf(n);
            if(bigInteger.isProbablePrime((int) Math.log(n))) return n;
        }
    }
    public static boolean rightTriangle(int a, int b, int c) {
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        return arr[0]*arr[0]+arr[1]*arr[1] == arr[2]*arr[2];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of func (1-10): "); // выбор нужной функции чтобы не запускать сразу все
        int i = in.nextInt();
        if (i==1){
            System.out.println(solutions(1, 0, -1));
            System.out.println(solutions(1, 0, 0));
            System.out.println(solutions(1, 0, 1));
        }
        if (i==2) {
            System.out.println(findZip("all zip files are zipped"));
            System.out.println(findZip("all zip files are compressed"));
        }
        if (i==3) {
            System.out.println(checkPerfect(6));
            System.out.println(checkPerfect(28));
            System.out.println(checkPerfect(496));
            System.out.println(checkPerfect(12));
            System.out.println(checkPerfect(97));
        }
        if (i==4) {
            System.out.println(flipEndChars("Cat, dog, and mouse."));
            System.out.println(flipEndChars("ada"));
            System.out.println(flipEndChars("Ada"));
            System.out.println(flipEndChars("z"));
        }
        if (i==5) {
            System.out.println(isValidHexCode("#CD5C5C"));
            System.out.println(isValidHexCode("#EAECEE"));
            System.out.println(isValidHexCode("#eaecee"));
            System.out.println(isValidHexCode("#CD5C58C"));
            System.out.println(isValidHexCode("#CD5C5Z"));
            System.out.println(isValidHexCode("#CD5C&C"));
            System.out.println(isValidHexCode("CD5C5C"));
        }
        if (i==6) {
            System.out.println(same(new int[]{1, 3, 4, 4, 4},new int[]{2, 5, 7}));
            System.out.println(same(new int[]{9, 8, 7, 6},new int[]{4, 4, 3, 1}));
            System.out.println(same(new int[]{2},new int[]{3, 3, 3, 3, 3}));
        }
        if (i==7) {
            System.out.println(isKaprekar(3));
            System.out.println(isKaprekar(5));
            System.out.println(isKaprekar(297));
        }
        if (i==8) {
            System.out.println(longestZero("01100001011000"));
            System.out.println(longestZero("100100100"));
            System.out.println(longestZero("11111"));
        }
        if (i==9) {
            System.out.println(nextPrime(12));
            System.out.println(nextPrime(24));
            System.out.println(nextPrime(11));
        }
        if (i==10) {
            System.out.println(rightTriangle(3, 4, 5));
            System.out.println(rightTriangle(145, 105, 100));
            System.out.println(rightTriangle(70, 1304, 110));
        }
    }

}
