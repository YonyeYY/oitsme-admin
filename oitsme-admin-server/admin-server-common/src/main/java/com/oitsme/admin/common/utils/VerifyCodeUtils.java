package com.oitsme.admin.common.utils;

/**
 * Created by Administrator on 2017/1/11.
 */
public class VerifyCodeUtils {
    /**
     * 短信验证码生成
     *
     * @param numberFlag 是否只是数字
     * @param length     验证码长度
     * @return
     */
    public static String createRandom(boolean numberFlag, int length) {
        String retStr = "";
        String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = strTable.length();
        boolean bDone = true;
        do {
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = strTable.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                retStr += String.valueOf(strTable.charAt(intR));
            }
            if (count >= 2) {
                bDone = false;
            }
        } while (bDone);
        return retStr;
    }

    public static void main(String[] a) {
        for (int i = 0; i < 10; i++) {
            //   System.out.println(VerifyCodeUtils.createRandom(true, 6));
        }
    }
}
