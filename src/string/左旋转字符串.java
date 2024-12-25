package string;

/**
 * @Author:杰杰睡不醒
 * @Date:2024/12/23 13:05
 * @Description:
 **/
public class 左旋转字符串 {
    public String dynamicPassword(String password, int target) {
        //password
        StringBuilder sb=new StringBuilder();
        //设定一个正整数目标值 target
        //将 password 前 target 个字符按原顺序移动至字符串末尾
        //请返回更新后的密码字符串。
        for (int i = target; i < password.length(); i++) {
            sb.append(password.charAt(i));
        }
        for (int i = 0; i < target; i++) {
            sb.append(password.charAt(i));
        }
        return sb.toString();

    }
}
