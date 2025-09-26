package org.example;

public class Main2 {

    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;

        return i + 1;
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pi = partition(array, left, right);

            quickSort(array, left, pi - 1);
            quickSort(array, pi + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 4, 3, 1, 2, 5, 8, 6};
        quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
