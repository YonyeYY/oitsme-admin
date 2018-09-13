package com.oitsme.admin.common.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @Author: pinro
 * @Package_name: com.oitsme.cloud.common.utils
 * @Description:
 * @Date: 2018/5/22
 * @Moditied:
 */
public class BytesHexStrTranslateUtils {

    private static final Logger logger = LogManager.getLogger(BytesHexStrTranslateUtils.class);

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * byte[] to hex string
     *
     * @param bytes
     * @return
     */
    public static String bytesToHexFun(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for (byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

    /**
     * 将16进制字符串转换为byte[]
     *
     * @param str
     * @return
     */
    public static byte[] hexToBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    /**
     * 解码
     * 将字符串（byte转换）做base64解码  结果以16进制显示
     * @return
     */
    public static String base64StringToHex(String data){
        final Base64.Decoder decoder = Base64.getDecoder();
        return bytesToHexFun(decoder.decode(data));
    }
    /**
     * 编码
     * 将十六进制字符串做base64编码
     */
    public static String hexStringToBase64(String data){
        final Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(hexToBytes(data));
    }

    /**
     * 数值型字符转十六进制
     * @param data
     * @return
     */
    public static String string2Hex(String data){
        StringBuffer lili = new StringBuffer();
        for (int i = 0; i < data.length(); i++) {
            int cp = data.codePointAt(i);
            if (!Character.isSupplementaryCodePoint(cp)) {
                lili.append("0"+(char)cp);
            } else {
                lili.append("0"+cp);
                i++;
            }
        }
        return lili.toString();
    }

    /**
     * 字符串转byte
     * 16位定长  最后一位校验值
     * @param keyName
     * @return
     */
    public static byte[] getNameData(String keyName) {
        if ("".equals(keyName) || null == keyName) return null;
        byte[] data = new byte[19];
        byte[] name = stringToBytes(keyName);
        int nameLen = name.length > 18 ? 18 : name.length;
        System.arraycopy(name, 0, data, 0, nameLen);

        //crc 1 byte
        data[18] = getCrc(data, 18);
        return data;
    }
    public static byte[] stringToBytes(String value){
        if( value != null && !value.isEmpty()) {
            return value.getBytes(Charset.forName("UTF-8"));
        }
        return null;
    }
    public static byte getCrc(byte[] data, int bits){
        int result = 0;
        for( int i = 0 ; i < bits ; i ++ ){
            byte b = data[i];
            result += b & 0xff;
        }
        return lowUint16((short) result);
    }
    public static byte lowUint16(short v) {
        return (byte) (v & 0xFF);
    }

    /**
     * 转byte字符串
     * @param data
     * @return
     */
    public static String bytesToString(byte[] data){
        if(data!=null && data.length!=0){
            return new String(data,Charset.forName("UTF-8"));
        }
        return null;
    }

    public static String string2bytes(String s) {
        byte[] b = new byte[s.length() / 2];
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 1) {
                Byte aByte1 = Byte.valueOf(Character.toString(s.charAt(i - 1)), 16);
                Byte aByte2 = Byte.valueOf(Character.toString(s.charAt(i)), 16);
                b[i / 2] = (byte) ((aByte1 << 4) + (aByte2 & 0x0f));
            }
        }
        return bytesToString(b).trim();
    }

    /**
     * 字符串每两位一组转化为数组
     * @param data
     * @return
     */
    public static byte[] str2HexByte(String data) {
        if(1==data.length()%2)
            return null;
        else{
            byte[] li = new byte[data.length()/2];
            for (int i = 0; i < data.length(); i+=2) {
                int cp1 = data.codePointAt(i);
                int cp2 = data.codePointAt(i+1);
                li[i/2] = (byte)(asc2Hex(cp1)<<4|asc2Hex(cp2));
            }
            return li;
        }
    }

    /**
     * 字符asc码数值转为byte数值
     * @param data
     * @return
     */
    public static int asc2Hex(int data){
        int li;
        if(data >= 0X30 && data <= 0X39){//0-9
            li = data - 0X30;
        }else if (data >= 0X41 && data <= 0X5A){//A-F
            li = data - 0X37;
        }else if(data >= 0X61 && data <= 0X7A){//a-f
            li = data - 0X57;
        }else{
            li = data;
        }
        return li;
    }
    /**
     * 设备crc校验
     * @param data
     * @return
     */
    public static int findCRC(byte[] data){
        int  CRC=0;
        for(int i=0;i<data.length; i++){
            int li = data[i];
            if(li<0)
                li &= 0XFF;
            CRC ^= li;
            for(int j=0;j<8;j++){
                if((CRC & 0x01) != 0){
                    CRC = (CRC >> 1) ^ 0X8c;
                }else{
                    CRC >>= 1;
                }
            }
        }
        CRC &= 0xff;//保证CRC余码输出为2字节。
        return CRC;
    }
    public static void main(String args[]){
        System.out.println(base64StringToHex("AQUC0FNoYXJlS2V5AAAAAAAAAAAAAACB+WvTTgAAAAAA"));
        String li = "6f51015301560100010081f96bd34e";

        System.out.println(li.substring(18,30));
    }
}
