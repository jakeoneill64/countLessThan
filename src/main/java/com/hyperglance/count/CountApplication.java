package com.hyperglance.count;

import java.awt.*;
import java.util.Collection;

public class CountApplication {

    public static void main(String... args){

    }

    /*
      This is a classical use of binary search
      the linearithmic / O(ln(n)) search algorithm
      for sorted sequences
     */
    public static int countLessThan(Collection<Integer> numbers, int threshold){
        int[] numberArray = numbers //easier to perform binary search on
                .stream()
                .mapToInt(i->i)
                .toArray();
        int index = recursiveBinarySearch(numberArray, threshold);
    }

    private static int recursiveBinarySearch(
        int[] numbers,

    ){

    }

}
