package com.yangxingang.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    /**
     * 打印日志
     *
     * @param info 打印的前缀
     * @param msg  需要打印的信息内容
     */
    public static void log(String info, String msg) {
        if(info.length()==0&&msg.length()==0){
            System.out.println("===============================");
        }else{
            System.out.println(info + ":" + msg);
        }
    }

    /**
     * 生成电子签名
     *
     * @return
     */
    public static String signWithSha256(String inputStr) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputStr.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @return当前时间
     */
    public static String getSystemTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        return date;
    }


}
