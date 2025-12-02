package hash;

import java.util.*;

public class Groupwords {
    public  static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个HashMap，键是排序后的字符串，值是原始字符串的列表
        Map<String, List<String>> mp = new HashMap<>();

        // 遍历输入的字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组并排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // 如果HashMap中不存在该键，则创建一个新的列表
            mp.putIfAbsent(key, new ArrayList<>());

            // 将原始字符串添加到对应的列表中
            mp.get(key).add(str);
        }

        // 将HashMap中的所有值转换为一个列表
        List<List<String>> ans = new ArrayList<>(mp.values());

        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入的字符串数组
//        System.out.println("请输入字符串数组（以空格分隔）：");
        String input = scanner.nextLine();
        String[] strs = input.split(" ");
        // 调用groupAnagrams方法
        List<List<String>> result = groupAnagrams(strs);

        // 输出结果
//        System.out.println("分组后的字母异位词：");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}

