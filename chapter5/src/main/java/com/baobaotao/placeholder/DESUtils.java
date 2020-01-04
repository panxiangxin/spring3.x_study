package com.baobaotao.placeholder;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import org.apache.commons.codec.binary.Base64;

//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;

public class DESUtils {
	
	private static Key key;
	private static String KEY_STR = "myKey";
	
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES加密
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return Base64.encodeBase64String(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 对str进行DES解密
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		
		try {
			byte[] strBytes = Base64.decodeBase64(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void main(String[] args) throws Exception {
		
		
		System.out.println("请输入要加密的字符，用空格分隔.");
		Scanner input = new Scanner(System.in);
		String url = input.nextLine();
		String[] urls = url.split(" ");
		
		for (int i = 0; i < urls.length; i++) {
			System.out.println(urls[i]+": "+getEncryptString(urls[i]));
		}
//		if (args == null || args.length < 1) {
//			System.out.println("请输入要加密的字符，用空格分隔.");
//		} else {
//			for (String arg : args) {
//				System.out.println(arg + ":" + getEncryptString(arg));
//			}
//		}
		
		System.out.println(getDecryptString("bXhaNuvf9AE="));
		System.out.println(getDecryptString("33FbB3jaX0w="));
	}
}
