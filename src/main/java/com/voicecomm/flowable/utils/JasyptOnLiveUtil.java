package com.voicecomm.flowable.utils;

import java.util.Scanner;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
/**
 * @author yulin.li
 * 数据库加密工具类
 */
public class JasyptOnLiveUtil {

   private static StandardPBEStringEncryptor encryptor;

   public static void main(String[] args) {
      encryptor = new StandardPBEStringEncryptor();
      EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
      @SuppressWarnings("resource")
      Scanner s = new Scanner(System.in);
      config.setAlgorithm("PBEWithMD5AndDES");
      System.out.println("输入加密盐:");
      String factor = s.nextLine();
      config.setPassword(factor);
      encryptor.setConfig(config);
      while (true) {
         System.out.println("输入需要加密的字符串:");
         String line = s.nextLine();
         if ("end".equals(line)) {
            break;
         } else {
            getPass(line);
         }
      }
   }

   // 加密
   public static String getPass(String plaintext) {
      String ciphertext = encryptor.encrypt(plaintext);
      System.out.println("加密结果：" + ciphertext);
      return ciphertext;
   }
   // 解密

   public static String passDecrypt(String ciphertext) {
      String plaintext = encryptor.decrypt(ciphertext);
      System.out.println("解密结果：" + plaintext);
      return plaintext;
   }
}
