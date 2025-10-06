package common;

import java.math.BigDecimal;

/**
 * @author dongyajie
 * @date 2025/10/6 16:50
 */
public class 大数之积 {
    /**
     * 两个大整数的乘法，输入为数字字符串，返回其积的字符串
     */
    public static String multiply(String num1, String num2) {
        BigDecimal a = new BigDecimal(num1);
        BigDecimal b = new BigDecimal(num2);
        return a.multiply(b).toPlainString();
    }

    public static void main(String[] args) {
        String num1 = "123456789012345678901234567890";
        String num2 = "987654321098765432109876543210";
        System.out.println(multiply(num1, num2)); // 输出: 121932631137021795226185032733622923332237463801111263526900
    }
}
