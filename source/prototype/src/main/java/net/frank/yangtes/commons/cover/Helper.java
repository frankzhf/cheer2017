package net.frank.yangtes.commons.cover;

import java.util.Random;

import net.frank.commons.util.DesEncryptUtil;


public final class Helper {

	protected static ThreadLocal<Boolean> t = new ThreadLocal<Boolean>();

	public static void doFilter() {
		t.set(Boolean.TRUE);
	}
	
	public static String encodeDes(String input) {
		int len = input.length();
		int random = new Random().nextInt(100) % 123;
		char mask = '#';
		if ((random > 32) && ((random < 48) || (random > 57))) {
			mask = (char) random;
		}
		input = len % 8 > 0 ? DesEncryptUtil.fillMask(mask, 8 * (len / 8 + 1), input) : input;
		return DesEncryptUtil.encodeDES(input);
	}

	public static String decodeDES(String input) {
		byte[] tk = DesEncryptUtil.decodeDES(input).getBytes();
		int len = tk.length;
		StringBuilder sb = new StringBuilder();
		boolean isBegin = false;
		for (int i = 0; i < len; i++) {
			if ((!isBegin) && (tk[i] < 58) && (tk[i] > 47)) {
				isBegin = true;
			}
			if (isBegin) {
				sb.append((char) tk[i]);
			}
		}
		return sb.toString();
	}
	
	
	public static String encodeDes(String input, String desKey) {
		int len = input.length();
		int random = new Random().nextInt(100) % 123;
		char mask = '#';
		if ((random > 32) && ((random < 48) || (random > 57))) {
			mask = (char) random;
		}
		input = len % 8 > 0 ? DesEncryptUtil.fillMask(mask, 8 * (len / 8 + 1), input) : input;
		return DesEncryptUtil.encodeDES(input, desKey);
	}

	public static String decodeDES(String input, String desKey) {
		byte[] tk = DesEncryptUtil.decodeDES(input, desKey).getBytes();
		int len = tk.length;
		StringBuilder sb = new StringBuilder();
		boolean isBegin = false;
		for (int i = 0; i < len; i++) {
			if ((!isBegin) && (tk[i] < 58) && (tk[i] > 47)) {
				isBegin = true;
			}
			if (isBegin) {
				sb.append((char) tk[i]);
			}
		}
		return sb.toString();
	}
}
