package org.example;

import java.util.Arrays;

public class Task2_DistanceToZero_Variant2 {

    public static void main(String[] args) {
        int[] input = {2, 0, 3, 4, 0};

        System.out.println("Исходный массив: " + Arrays.toString(input));

        int[] result = solveTask(input);

        System.out.println("Результат:       " + Arrays.toString(result));
    }

    public static int[] solveTask(int[] arr) {
        int[] answer = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                answer[i] = 0;
                continue;
            }

            int minDistance = Integer.MAX_VALUE;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 0) {
                    int distance = Math.abs(i - j);
                    if (distance < minDistance) {
                        minDistance = distance;
                    }
                }
            }

            answer[i] = minDistance;
        }

        return answer;
    }
}