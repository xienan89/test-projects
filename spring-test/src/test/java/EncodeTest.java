import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by xienan on 2015/11/18.
 */
public class EncodeTest {

    @Test
    public void code(){
        char c = 59;
        System.out.println(c);
    }

    @Test
    public void encode() throws UnsupportedEncodingException {
        String s1 = "汉";
        //String s1  = "abcA";

        //System.out.println(new String(s1.getBytes("utf-8"), "utf-8"));
        System.out.println(byte2hex(s1.getBytes("utf-8")));
    }

    //将指定byte数组以16进制的形式打印到控制台
    private static String byte2hex(byte [] buffer){
        String h = "";

        for(int i = 0; i < buffer.length; i++){
            String temp = Integer.toHexString(buffer[i] & 0xFF);
            if(temp.length() == 1){
                temp = "0" + temp;
            }
            h = h + " "+ temp;
        }

        return h;

    }
}
