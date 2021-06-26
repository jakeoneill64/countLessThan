package com.hyperglance.count;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class CountApplication {

    public static void main(String... args){
        System.out.print(countLessThan(Arrays.stream(args, 1, args.length)
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()), Integer.valueOf(args[0])));
    }

    /*
      This is a classical use case for binary search -
      the logarithmic / O(ln(n)) search algorithm
      for sorted sequences.
     */
    public static int countLessThan(Collection<Integer> numbers, int threshold){
        int[] numberArray = numbers
                .stream()
                .mapToInt(i->i)
                .toArray();
        if(threshold > numberArray[numberArray.length -1])
            return numberArray.length;
        int lessIndex = iterativeBinarySearch( numberArray,
                threshold);
        for(int x = lessIndex; x >= 0 && numberArray[x] >= threshold ; x--) //check for non distinct values
            lessIndex = x;
        return lessIndex;
    }

    public static int iterativeBinarySearch(int[] ints, int threshold) {
        int low, high, mid;
        low = 0;
        high = ints.length;
        while(low< high)  {
            mid = (low + high)/2;
            if(threshold < ints[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
