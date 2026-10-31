package org.example.algorithm;

import java.util.ArrayList;

public class quick_sort {
    ArrayList<Integer> quickSortNaive(ArrayList<Integer> arr) {
        if (arr.size() < 2) {
            return arr;
        }
        int pivot = arr.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            if (x < pivot) {
                left.add(x);
            } else if (x > pivot) {
                right.add(x);
            }
        }
        left = quickSortNaive(left);
        right = quickSortNaive(right);
        left.add(pivot);
        left.addAll(right);
        return left;
    }

//    void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//
//    int quickSortLomutoPartition(int[] arr, int low, int high) {
//        int pivot = arr[high];
//        int i = low - 1;
//        for (int j = low; j < high; j++) {
//            if (arr[j] < pivot) {
//                i++;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, i + 1, high);
//        return i + 1;
//    }
//
//    void quickSortLomuto(int[] arr, int low, int high) {
//        if (low >= high) {
//            return;
//        }
//        int pivotIndex = quickSortLomutoPartition(arr, low, high);
//        quickSortLomuto(arr, low, pivotIndex - 1);
//        quickSortLomuto(arr, pivotIndex + 1, high);
//    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // O(n)
    int quickSortLomutoPartition(int[] arr, int low, int high) {
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < arr[high]) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, high);
        return i;
    }

    // O(n * log(n))
    void quickSortLomuto(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = quickSortLomutoPartition(arr, low, high);
            quickSortLomuto(arr, low, pivotIndex - 1);
            quickSortLomuto(arr, pivotIndex + 1, high);
        }
    }

    int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            }
            while (arr[i] < pivot);
            do {
                j--;
            }
            while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    void quickSortHoare(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = hoarePartition(arr, low, high);
            quickSortHoare(arr, low, pivotIndex);
            quickSortHoare(arr, pivotIndex + 1, high);
        }
    }

    void main() {
//        int[] input = {5, 1, 4, 2, 3};
//        int[] input = {5, 1, 4, 2, 2};
//        quickSortLomuto(input, 0, input.length - 1);
        int[] input = {5, 3, 8, 4, 2, 7, 1, 10};
        quickSortHoare(input, 0, input.length - 1);
    }
}
