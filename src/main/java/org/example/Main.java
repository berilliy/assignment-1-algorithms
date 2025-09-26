package org.example;

public class Main {

    public static void merge(int[] array, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < len2; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            }
            else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < len1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < len2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 6, 1, 4, 2, 5, 7, 8};
        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}