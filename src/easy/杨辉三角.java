package easy;


import java.util.*;

/**
 * @author dongyajie
 * @date 2025/8/7 10:31
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 */
public class 杨辉三角 {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static  List<List<Integer>> generate(int numRows) {
        List<List<Integer>> c = new ArrayList<>(numRows); // 预分配空间
        c.add(Arrays.asList(1));//[[1]]
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1); // 预分配空间
            row.add(1);// 每一行的第一个元素是 1
            for (int j = 1; j < i; j++) {//i:2 3
                // 左上方的数 + 正上方的数
                row.add(c.get(i - 1).get(j - 1) + c.get(i - 1).get(j));
            }
            row.add(1);// 每一行的最后一个元素是 1
            c.add(row);
        }
        return c;
    }

}
