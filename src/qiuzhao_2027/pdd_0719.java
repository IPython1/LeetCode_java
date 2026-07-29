package qiuzhao_2027;

import java.io.*;
import java.util.*;

public class pdd_0719 {

        public static String findOperation(String a, String b) {
            int n = a.length();
            int left = -1;
            int right = -1;

            // 找到第一个和最后一个不同的位置
            for (int i = 0; i < n; i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }

            // 题目保证存在合法操作，此判断用于保证代码完整
            if (left == -1) {
                return "-1";
            }

            char target = b.charAt(left);

            // 左侧可以扩展，说明操作不唯一
            if (left > 0 && b.charAt(left - 1) == target) {
                return "-1";
            }

            // 右侧可以扩展，说明操作不唯一
            if (right + 1 < n && b.charAt(right + 1) == target) {
                return "-1";
            }

            // 下标转换为从 1 开始
            return (left + 1) + " " + (right + 1) + " " + target;
        }

        public static void main(String[] args) throws Exception {
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));

            int t = Integer.parseInt(reader.readLine().trim());
            StringBuilder answer = new StringBuilder();

            for (int caseIndex = 0; caseIndex < t; caseIndex++) {
                int n = Integer.parseInt(reader.readLine().trim());
                String a = reader.readLine().trim();
                String b = reader.readLine().trim();

                answer.append(findOperation(a, b));

                if (caseIndex + 1 < t) {
                    answer.append('\n');
                }
            }

            System.out.print(answer);
        }
}
