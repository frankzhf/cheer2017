package net.frank.commons.util;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class DesEncryptUtil {
	private static transient Log log = LogFactory.getLog(DesEncryptUtil.class);

	private static final String DESKEY = "net.frank.f3ew2k";

	private static final char MASK = '#';
	private static int _MASK = (int) MASK;

	public static String encodeDES(String input) {
		return encodeDES(input, DESKEY);
	}

	public static String encodeDES(String input, String deskey) {
		int len = input.length();
		input = len % 8 > 0 ? DesEncryptUtil.fillMask(MASK, 8 * (len / 8 + 1), input) : input;
		try {
			return DesEncryptImplUtil.getInstance().encrypt(input, deskey);
		} catch (Exception e) {
			log.error("encode error", e);
		}
		return null;
	}

	public static String decodeDES(String input) {
		return decodeDES(input, DESKEY);
	}

	public static String decodeDES(String input, String deskey) {
		try {
			String s = DesEncryptImplUtil.getInstance().decrypt(input, deskey);
			byte[] tk = s.getBytes();
			int len = tk.length;
			StringBuilder sb = new StringBuilder();
			boolean isBegin = false;
			for (int i = 0; i < len; i++) {
				if (!isBegin && tk[i] != _MASK) {
					isBegin = true;
				}
				if (isBegin) {
					sb.append((char) tk[i]);
				}
			}
			return sb.toString();
		} catch (Exception e) {
			log.error("decode error", e);
		}
		return null;
	}

	public static String fillMask(char mask, int length, String input) {
		final int inputLen = input.length();
		if (inputLen >= length) {
			return input;
		}
		int maskLen = length - inputLen;
		char[] chars = new char[maskLen];
		for (int i = 0; i < maskLen; i++) {
			chars[i] = mask;
		}
		return new String(chars) + input;
	}

	private static final class DesEncryptImplUtil {
		private static DesEncryptImplUtil des;

		static DesEncryptImplUtil getInstance() {
			if (null == des) {
				des = new DesEncryptImplUtil();
			}
			return des;
		}

		final static String KEY_ALGORITHM = "DES";
		final static String CIPHER_ALGORITHM = "DES/ECB/NoPadding";

		SecretKey keyGenerator(String keyStr) throws Exception {
			byte input[] = HexString2Bytes(keyStr);
			DESKeySpec desKey = new DESKeySpec(input);
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
			SecretKey securekey = keyFactory.generateSecret(desKey);
			return securekey;
		}

		int parse(char c) {
			if (c >= 'a')
				return (c - 'a' + 10) & 0x0f;
			if (c >= 'A')
				return (c - 'A' + 10) & 0x0f;
			return (c - '0') & 0x0f;
		}

		byte[] HexString2Bytes(String hexstr) {
			byte[] b = new byte[hexstr.length() / 2];
			int j = 0;
			for (int i = 0; i < b.length; i++) {
				char c0 = hexstr.charAt(j++);
				char c1 = hexstr.charAt(j++);
				b[i] = (byte) ((parse(c0) << 4) | parse(c1));
			}
			return b;
		}

		String encrypt(String data, String key) throws Exception {
			Key deskey = keyGenerator(key);
			// 实例化Cipher对象，它用于完成实际的加密操作
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			SecureRandom random = new SecureRandom();
			// 初始化Cipher对象，设置为加密模式
			cipher.init(Cipher.ENCRYPT_MODE, deskey, random);
			byte[] results = cipher.doFinal(data.getBytes());
			// 执行加密操作。加密后的结果通常都会用Base64编码进行传输
			return Base64Util.encodeToString(results, Base64Util.DEFAULT);
		}

		String decrypt(String data, String key) throws Exception {
			Key deskey = keyGenerator(key);
			Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
			// 初始化Cipher对象，设置为解密模式
			cipher.init(Cipher.DECRYPT_MODE, deskey);
			// 执行解密操作
			return new String(cipher.doFinal(Base64Util.decode(data, Base64Util.DEFAULT)));
		}
	}

	public static void main(String[] args) {
		String input = "zhaofeng:baijie:" + new Date().getTime();
		String ss = DesEncryptUtil.encodeDES(input);
		log.info(ss);
		String sss = DesEncryptUtil.decodeDES(ss);
		log.info(sss);
	}
}
