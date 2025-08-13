package easy;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author dongyajie
 * @date 2025/8/7 10:30
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合
 * 左括号必须以正确的顺序闭合
 * 每个右括号都有一个对应的相同类型的左括号
 *
 * 利用栈进行解题 遇到左括号就入栈 遇到右括号就进行出栈 判断栈是否为空
 */
public class 有效的括号 {
    public static void main(String[] args) {

        System.out.println(isValid("([)]"));
    }
    public static boolean isValid(String s) {
        char[] chars =s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : chars) {
            if(c=='(' || c=='{' || c=='['){
                stack.addLast(c);
            }else {
                if(stack.isEmpty()){//如果栈为空说明没有有效的括号 直接返回false
                    return false;
                }
                // 出栈：用pollLast()移除尾部元素（符合栈的LIFO）
                char top = stack.pollLast();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

}
