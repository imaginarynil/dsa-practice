package org.example.algorithm;

public class binary_search {
    int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

//    int binarySearch(int[] arr, int key) {
//        int low = 0;
//        int high = arr.length - 1;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//            if (arr[mid] == key) {
//                return mid;
//            }
//            if (arr[mid] > key) {
//                high = mid - 1;
//            } else {
//                low = mid + 1;
//            }
//        }
//        return -1;
//    }

    void main() {
        int[] arr;
        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        var x = binarySearch(arr, 8);
    }
}
