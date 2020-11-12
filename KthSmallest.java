/*
 * O(n) 时间复杂度内求无序数组中的第 K 大元素。比如，4， 2， 5， 12， 3 第 3 大元素就是 4
 */
public class KthSmallest {
    public int find(int[] arr, int start, int end, int k) {
        if (arr == null || k > arr.length) {
            return 0;
        }
        int pivot = partitionTwoIndex(arr, start, end);
        System.out.println("pivot=" + pivot);
        while ((pivot + 1) != k) {
            if ((pivot + 1) > k) {
                pivot = partitionTwoIndex(arr, start, pivot - 1);
            } else {
                pivot = partitionTwoIndex(arr, pivot + 1, end);
            }
        }
        return arr[pivot];
        // if ((pivot + 1) == k) {
        // return arr[pivot];
        // } else if (pivot > k) {
        // pivot = partition(arr, start, pivot - 1);
        // } else if (pivot < k) {
        // pivot = partition(arr, pivot + 1, end);
        // }
        // return arr[pivot];
    }

    private int partitionTwoIndex(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        int i = start;
        int j = end;
        while (i != j) {
            while (i < j && arr[i] <= pivotValue) {
                i++;
            }
            while (i < j && arr[j] >= pivotValue) {
                j--;
            }
            if (j > i) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[start] = arr[i];
        arr[i] = pivotValue;
        return i;
    }

    private int partition(int[] arr, int start, int end) {
        int pivotValue = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < pivotValue) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[end];
        arr[end] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 5, 12, 3 };
        int k = 3;
        int r = new KthSmallest().find(arr, 0, arr.length - 1, k);
        System.out.println("第" + k + "大元素是" + r);
    }

}