package common;

import java.math.BigDecimal;

/**
 * @author dongyajie
 * @date 2025/10/6 16:49
 */
public class 大数之和 {
    /**
     * 两个大整数的加法，输入为数字字符串，返回其和的字符串
     */
    public static String add(String num1, String num2) {
        BigDecimal a = new BigDecimal(num1);
        BigDecimal b = new BigDecimal(num2);
        return a.add(b).toPlainString();
    }

    public static void main(String[] args) {
        String num1 = "123456789012345678901234567890";
        String num2 = "987654321098765432109876543210";
        System.out.println(add(num1, num2)); // 输出: 1111111110111111111011111111100
    }
}
