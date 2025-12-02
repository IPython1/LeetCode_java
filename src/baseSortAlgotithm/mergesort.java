package baseSortAlgotithm;

public class mergesort {
    public static void mergeSort(int[] a,int l,int r,int[] temp){
        if (l >= r) return;  // 递归终止条件

        int mid = (l + r) >> 1;  // 计算中点
        mergeSort(a, l, mid, temp);   // 递归左半部分
        mergeSort(a, mid + 1, r, temp); // 递归右半部分

        int k = 0;  // 临时数组索引
        int i = l;   // 左子数组起始位置
        int j = mid + 1;  // 右子数组起始位置

        // 合并两个有序子数组
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) {  // 稳定排序（相等时左边优先）
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        // 处理剩余元素
        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        // 将排好序的临时数组复制回原数组
        System.arraycopy(temp, 0, a, l, k);
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,5,2,4,3,6,7,8,9,10};
        int[] temp=new int[a.length];//归并过程中的临时数组
        mergeSort(a,0,a.length-1,temp);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
