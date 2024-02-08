// Student name: Koichi Nakata (ID: knakata595)

package org.example;

import java.util.Scanner;

import static java.util.Collections.min;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] list1 = createArray(input, 1);
        int[] list2 = createArray(input, 2);

        int[] merged = merge(list1, list2);
        System.out.printf("The list of the merged array with %2d elements:\n", merged.length);
        for (int num : merged) System.out.printf("%d ", num);
    }

    public static int[] createArray(Scanner input, int num) {
        System.out.printf("Enter a sorted list%d (start with the size of the array, separated by white space):\n", num);
        String inputStr = input.nextLine();
        String[] strArray = inputStr.split(" ");

        int[] newArray = new int[Integer.parseInt(strArray[0])];
        for (int i = 1; i < strArray.length; i++) {
            newArray[i - 1] = Integer.parseInt(strArray[i]);
        }
        // Return by reference
        return newArray;
    }

    public static int[] merge(int[] list1, int[] list2) {
        int size1 = list1.length, size2 = list2.length;
        int[] merged = new int[size1 + size2];

        for (int i = 0; i < size1+size2; i++) {
            if (i >= size1) merged[i] = list2[i-size1];
            else merged[i] = list1[i];
        }

        insertionSort(merged, size1);

//        // We want to iterate two arrays at the same time
//        int index1 = 0, index2 = 0;
//        while (index1 < list1.length || index2 < list2.length) {
//            // If we finished iterating list1
//            if (index1 >= list1.length) {
//                merged[index1 + index2] = list2[index2];
//                index2++;
//                // Else if we finished iterating list2
//            } else if (index2 >= list2.length) {
//                merged[index1 + index2] = list1[index1];
//                index1++;
//                // Else both lists can be still iterated
//            } else {
//                if (list1[index1] < list2[index2]) {
//                    merged[index1 + index2] = list1[index1];
//                    index1++;
//                } else {
//                    merged[index1 + index2] = list2[index2];
//                    index2++;
//                }
//            }
//        }
        // Return by reference
        return merged;
    }

    private static void insertionSort(int[] array, int start) {
        for (int i = start; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j-1]) {
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
    }
}