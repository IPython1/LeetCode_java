package baseSortAlgotithm;

public class bubblesort {
    /**
     * 冒泡排序实现
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // 外层循环：控制排序轮次 n个数的话就是需要n-1次排序
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  // 标记本轮是否有交换

            // 内层循环：进行实际比较和交换
            // n - i - 1: 每轮结束后，最后i个元素已排好序 每次排序都会把最大的数放在后边
            for (int j = 0; j < n - i - 1; j++) {

                // 比较相邻元素
                if (arr[j] > arr[j + 1]) {//前边元素比后边大就需要交换顺序
                    // 交换元素
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;  // 标记发生交换
                }
            }

            // 若本轮无交换，说明数组已完全有序
            if (!swapped) {
                break;  // 提前结束排序
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("排序后的数组：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
