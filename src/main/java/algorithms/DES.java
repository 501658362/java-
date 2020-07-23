package algorithms;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.Security;

/**
 * DES加密介绍
 * DES是一种对称加密算法，所谓对称加密算法即：加密和解密使用相同密钥的算法。DES加密算法出自IBM的研究，
 * 后来被美国政府正式采用，之后开始广泛流传，但是近些年使用越来越少，因为DES使用56位密钥，以现代计算能力，
 * 24小时内即可被破解。虽然如此，在某些简单应用中，我们还是可以使用DES加密算法，本文简单讲解DES的JAVA实现
 * 。
 * 注意：DES加密和解密过程中，密钥长度都必须是8的倍数
 */
public class DES {
    /**
     * 对称加解密DES密钥Key
     */
    private String key;

    private static Cipher mEncryptCipher = null;
    private static Cipher mDecryptCipher = null;


    public DES(String key, String algorithm) throws Exception {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        this.key = key;
        //初始化加密和解密密码提供类
        mEncryptCipher = Cipher.getInstance(algorithm);
        mEncryptCipher.init(Cipher.ENCRYPT_MODE, getKey(this.key.getBytes()));
        mDecryptCipher = Cipher.getInstance(algorithm);
        mDecryptCipher.init(Cipher.DECRYPT_MODE, getKey(this.key.getBytes()));
    }

    //测试
    public static void main(String args[]) throws Exception {

        //待加密内容
//        String str = "{\"UseType\":1,\"PatternType\":1,\"VehicleTypeList\":[51],\"DuseLocation\":{\"Address\":\" 樟 宜 机 场 \",\"DetailAddress\":\" 樟 宜 机 场 \",\"Longitude\":103.991531,\"Latitude\":1.36442},\"Aus eLocation\":{\"Address\":\"新加坡洲际酒店(Intercontinental Singapore)\",\"DetailAddress\":\"80Mid dleRd\",\"Longitude\":103.85626,\"Latitude\":1.297311},\"UseTime\":\"2016-04-05 23:05\",\"FixedCod e\":\"SIN\"}";
        String str = "{\"UseType\":1,\"PatternType\":1,\"VehicleTypeList\":[51],\"DuseLocation\":{\"Address\":\"樟宜机场\",\"DetailAddress\":\"樟宜机场\",\"Longitude\":103.991531,\"Latitude\":1.36442},\"AuseLocation\":{\"Address\":\"新加坡洲际酒店(Intercontinental Singapore)\",\"DetailAddress\":\"80Mid dleRd\",\"Longitude\":103.85626,\"Latitude\":1.297311},\"UseTime\":\"2016-04-05 23:05\",\"FixedCode\":\"SIN\"}";
        JSONObject jsonObject = JSON.parseObject(str, Feature.OrderedField);
        //密码，长度要是8的倍数
        String password = "12345678";
        DES des = new DES(password, "DES/ECB/PKCS7Padding");
        String result = des.encrypt(jsonObject.toJSONString());
        System.out.println("加密后：" + result);
        String de = "C556A38F5790A1D1EE462A6B1A35681234D2D645124A07D16EE044123B2C9C836FC92904D699CC657B15035721C8BBB6F8C77F8BE6D9ADAF65FB174ADDB381C12BB4B0141D30623038AEC90FB815364B0BFBE6500C148FCDF095042BD3EA60BBF61DC3C1871CEEC7385197AECAAC6C002F23965F9F2F078C9A1E1DB4561567DB420B5BC59149997B342632206E2EC7F8505B9D5F90A17AD2E338230D04D975127C86873ACB9CB9ACBD6E7FD40B09401D721C9E5934896CCEEEDBF400606DCCEF27A68531C9848A8E67E443C6CDB4B79BDBC0151AE6639A55CBC89A4A7E6075CCBD0175AC09A151394FAAD8BF8BD9D4EF24E8FE00DEA8E30AF61DC3C1871CEEC7349D51BD72769633915E0B3E0071F28EF0D75EF7D4FC0E842DDB7ED79D1A246EDD33AFDED0EC3047DD8A03CF4AFB817D11CDA6312E589C5380E33387444A9DC5538FAEF3409087EA1BD640A0374962208BDB1070A5B1C0110695CF9787FFB8C7BE8D1804C7627C646FD5500F7681DAF6";
        //直接将如上内容解密
        try {
            String decryResult = des.decrypt(result);

            System.out.println("携程的：" + de);
            System.out.println("解密后：" + decryResult);

            System.out.println("解密后：" + (result.equalsIgnoreCase(de) ? "和携程一致" : "和携程不一致"));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        result = des.encrypt(str);
        System.out.println("加密后：" + result.toUpperCase());
        //直接将如上内容解密
        try {
            String decryResult = des.decrypt(result);
            System.out.println("携程的：" + de);
            System.out.println("解密后：" + decryResult);

            System.out.println("解密后：" + (result.equalsIgnoreCase(de) ? "和携程一致" : "和携程不一致"));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

//   ****** 加密 ******

    /**
     * 对 字符串 加密
     */
    public String encrypt(String strIn) throws Exception {
        return byte2HexStr(encrypt(strIn.getBytes()));
    }

    /**
     * 对 字节数组 加密
     */
    public byte[] encrypt(byte[] arrB) throws Exception {
        return mEncryptCipher.doFinal(arrB);
    }


//   ****** 解密 ******

    /**
     * 解密 字符串
     */
    public String decrypt(String strIn) throws Exception {
        return new String(decrypt(hexStr2Byte(strIn)));
    }

    /**
     * 解密 字节数组
     */
    public byte[] decrypt(byte[] arrB) throws Exception {
        return mDecryptCipher.doFinal(arrB);
    }


    /**
     * 解密用的密钥（字节数组）长度必须为8个字节否则返回null, 不足8位时后面补0，超出8位只取前8位
     *
     * @param arrBTmp 构成该字符串的字节数组
     * @return 生成的密钥
     * @throws Exception
     */

    private Key getKey(byte[] arrBTmp) throws Exception {
        // 创建一个空的8位字节数组（默认值为0）
        byte[] arrB = new byte[8];

        // 将原始字节数组转换为8位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        // 生成密钥
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

        return key;
    }

    /**
     * HEX转码 String to Byte
     */
    public static byte[] hexStr2Byte(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * HEX转码 Byte to  String
     */
    public static String byte2HexStr(byte[] arrB) throws Exception {

        int iLen = arrB.length;
        // 每个byte用两个字符才能表示，所以字符串的长度是数组长度的两倍
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // 把负数转换为正数
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // 小于0F的数需要在前面补0
            if (intTmp < 16) {
                sb.append("0");
            }

            String singdata = String.format("%2s", Integer.toHexString(intTmp & 0xFF).toUpperCase()).replace(' ', '0');
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }
}
