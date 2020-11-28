/*
 * O(n) 时间复杂度内求无序数组中的第 K 大元素。比如，4， 2， 5， 12， 3 第 3 大元素就是 4
 */
public class SortKthSmallest {
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
    }

    /**
     * 挖坑法
     * 用第一个作为分区点(start)，从后->前找第一个比分区点小的值(移动end)，end放到start
     * 从前->后找第一个比分区点大的值(移动start)，start放到end
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partitionTwoIndex(int[] arr, int start, int end) {
        int pivotValue = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivotValue) {
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivotValue) {
                start++;
            }
            arr[end] = arr[start];

        }
        arr[end] = pivotValue;
        return start;
    }

    /**
     * 循环法
     * 最后一个数作为分区点；
     * 从前->后，把小于分区值的数，都交互到前面，用i控制前面的移动位
     * 交互分区点与i位置
     * @param arr
     * @param start
     * @param end
     * @return
     */
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
        int k = 2;
        int r = new SortKthSmallest().find(arr, 0, arr.length - 1, k);
        System.out.println("第" + k + "大元素是" + r);
    }

}