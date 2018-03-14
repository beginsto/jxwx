package pers.jess.template.common.util;

import java.util.Random;

public class StringRandomUtil {

    private static Random random = new Random();

    /**
     * 随机 纯数字字符串
     * @param length 自定义长度
     * @return
     */
    public static String numberRandom(int length){
        String val = "";

        for(int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 随机小写字符串
     * @param length 自定义长度
     * @return
     */
    public static String charLowercaseRandom(int length){
        String val = "";
        for(int i = 0; i < length; i++) {
            val += (char)(random.nextInt(26) + 97);
        }
        return val;
    }

    /**
     * 随机大写字符串
     * @param length 自定义长度
     * @return
     */
    public static String charCapitalRandom(int length){
        String val = "";
        for(int i = 0; i < length; i++) {
            val += (char)(random.nextInt(26) + 65);
        }
        return val;
    }

    /**
     * 随机大小写混合字符串
     * @param length 自定义长度
     * @return
     */
    public static String charCapitalAndLowercaseRandom(int length){
        String val = "";
        for(int i = 0; i < length; i++) {
            //输出是大写字母还是小写字母
            int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val += (char)(random.nextInt(26) + temp);
        }
        return val;
    }

    /**
     * 随机 数字 大小写 字符串
     * @param length 自定义长度
     * @return
     */
    public static String stringRandom(int length) {

        String val = "";

        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    public static void main(String[] args){
        System.out.println(numberRandom(26));
        System.out.println(charLowercaseRandom(26));
        System.out.println(charCapitalRandom(26));
        System.out.println(charCapitalAndLowercaseRandom(26));
        System.out.println(stringRandom(26));
    }

}
