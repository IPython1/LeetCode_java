package baseSortAlgotithm;
import java.util.*;

public class quicksort {
    public static void quickSort(int[] a,int l,int r){
        //递归的终止条件 最终仅有一个元素结束递归
        if (l>=r)
            return;
        //分成子问题
        int i=l-1,j=r+1;
        int x=a[l+r>>1];//选定一个基准 使左边的元素全都小于x 右边的元素全都大于x
        while(i<j){
            do i++;while(a[i]<x);
            do j--;while(a[j]>x);
            if(i<j){
                int temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        //递归处理子问题
        quickSort(a,l,j);
        quickSort(a,j+1,r);
        //子问题合并 快排这一步不需要操作（因为在划分的时候已经同步进行了swap排序），但归并排序的核心在这一步骤
    }
    public static void main(String[] args) {
//        int[] a=new int[]{1,5,2,4,3,6,7,8,9,10};
        int[] a=new int[5];
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<5;i++){
            a[i]=sc.nextInt();
        }

        quickSort(a,0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }

}
