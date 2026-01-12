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

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int quickSortLomutoPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    void quickSortLomuto(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = quickSortLomutoPartition(arr, low, high);
        quickSortLomuto(arr, low, pivotIndex - 1);
        quickSortLomuto(arr, pivotIndex + 1, high);
    }

    void main() {
        int[] input = {5, 1, 4, 2, 3};
        quickSortLomuto(input, 0, input.length - 1);
    }
}
