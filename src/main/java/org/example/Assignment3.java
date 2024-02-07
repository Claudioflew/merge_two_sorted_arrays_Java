// Student name: Koichi Nakata (ID: knakata595)

package org.example;

import java.util.Scanner;

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
        int[] merged = new int[list1.length + list2.length];

        // We want to iterate two arrays at the same time
        int index1 = 0, index2 = 0;
        while (index1 < list1.length || index2 < list2.length) {
            // If we finished iterating list1
            if (index1 >= list1.length) {
                merged[index1 + index2] = list2[index2];
                index2++;
                // Else if we finished iterating list2
            } else if (index2 >= list2.length) {
                merged[index1 + index2] = list1[index1];
                index1++;
                // Else both lists can be still iterated
            } else {
                if (list1[index1] < list2[index2]) {
                    merged[index1 + index2] = list1[index1];
                    index1++;
                } else {
                    merged[index1 + index2] = list2[index2];
                    index2++;
                }
            }
        }
        // Return by reference
        return merged;
    }
}