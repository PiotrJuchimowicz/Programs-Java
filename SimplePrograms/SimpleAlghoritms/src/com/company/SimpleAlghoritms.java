package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleAlghoritms {

    //palindrom check
    public static boolean isPalindrom(String param) {
        if (param == null)
            return false;
        char charArray[] = param.toLowerCase().toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            int j = charArray.length - i;
            if (charArray[i] != charArray[j - 1])
                return false;

        }
        return true;
    }

    //sum of numbers in integer
    public static int sumOfNumbersInInteger(int param) {
        int sum = 0;
        int division = 10;
        while (param != 0) {
            sum = sum + param % 10;
            param = param / 10;
        }
        return sum;
    }

    private static int sumNumbersInInteger2(int number) {
        int sum = 0;

        while (number > 0) {
            int rest = number % 10;
            sum += rest;
            number = (number - rest) / 10;
        }

        return sum;
    }

    //array reversion
    public static void arrayReversion(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int j = array.length - 1 - i;
            int a = array[i];
            int b = array[j];
            array[i] = b;
            array[j] = a;
        }
    }

    public static int binarySearch(int x, int[] array) {
        Arrays.sort(array);
        //1234567
        int min = 0;
        int max = array.length - 1;
//123456789
        while (max >= min) {
            int avg = min + (max - min) / 2;
            if (array[avg] == x) {
                return avg;
            } else if (x > array[avg]) {
                min = avg + 1;//4 a max = 6 wiec avg = 5
            } else {
                max = avg - 1;
            }
        }
        throw new IllegalStateException();
    }

    //12341 2351234543 987654321 34124
    public static int[] longestSortedSubArray(int[] array) {
        long start = System.currentTimeMillis() / 100;
        int result[] = null;
        for (int i = 0; i < array.length; i++) {

            int[] longestAscending = getLongestAscending(Arrays.stream(array).skip(i).toArray());

            int[] longestDescending = getLongestDescending(Arrays.stream(array).skip(i).toArray());

            if ((result == null || longestDescending.length > result.length) && longestDescending.length > longestAscending.length) {
                result = longestDescending;
            } else if ((result == null || longestAscending.length > result.length) && longestAscending.length > longestDescending.length) {
                result = longestAscending;
            }

        }

        long end = System.currentTimeMillis() / 100;
        System.out.println(end - start);
        return result;
    }

    public static int[] longestSortedSubArrayWithPerformanceBooster(int[] array) {
        long start = System.currentTimeMillis() / 100;
        int result[] = null;
        int performanceBooster = 0;
        for (int i = 0; i < array.length; i = performanceBooster) {

            int[] longestAscending = getLongestAscending(Arrays.stream(array).skip(i).toArray());

            int[] longestDescending = getLongestDescending(Arrays.stream(array).skip(i).toArray());

            if ((result == null || longestDescending.length > result.length) && longestDescending.length > longestAscending.length) {
                result = longestDescending;
                performanceBooster = i + result.length - 1;
            } else if ((result == null || longestAscending.length > result.length) && longestAscending.length > longestDescending.length) {
                result = longestAscending;
                performanceBooster = i + result.length - 1;
            } else {
                performanceBooster++;
            }

        }
        long end = System.currentTimeMillis() / 100;
        System.out.println(end - start);
        return result;
    }

    private static int[] getLongestAscending(int array[]) {
        List<Integer> result = new ArrayList<>();
        if (array.length > 0) {
            result.add(array[0]);
        }

        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                if (array[i + 1] >= array[i]) {
                    result.add(array[i + 1]);
                } else {
                    break;
                }
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    private static int[] getLongestDescending(int array[]) {
        List<Integer> result = new ArrayList<>();
        if (array.length > 0) {
            result.add(array[0]);
        }

        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                if (array[i + 1] <= array[i]) {
                    result.add(array[i + 1]);
                } else {
                    break;
                }
            }
        }

        return result.stream().mapToInt(value -> value).toArray();
    }

    public static boolean compareStrings(List<Character> first, List<Character> second) {
        String firstString = first.stream().map(String::valueOf).collect(Collectors.joining());
        String secondString = second.stream().map(String::valueOf).collect(Collectors.joining());

        return firstString.equals(secondString);
    }

    public List<Integer> mergeSecondIntoFirst(List<Integer> first, List<Integer> second, int index) {
        first.addAll(index, second);
        return first;
    }

    // 1 2 3 4 6 1 10 12 14 15
    public static boolean detectAndRemoveLoop(List<Integer> integers) {
        Set<Integer> alreadyPresent = new HashSet<>();
        int stopIndex = 0;

        for (int i = 0; i < integers.size(); i++) {
            if (!alreadyPresent.contains(integers.get(i))) {
                alreadyPresent.add(integers.get(i));
            } else {
                stopIndex = i;
                break;
            }
        }

        List<Integer> newList = new ArrayList<>();
        for(int i = stopIndex; i < integers.size(); i++) {
            newList.add(integers.get(i));
        }

        integers.remove(stopIndex);
        integers.retainAll(newList);

        return newList.size() == integers.size();
    }
}
