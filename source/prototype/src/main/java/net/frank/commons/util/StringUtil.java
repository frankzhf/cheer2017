package net.frank.commons.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import net.frank.commons.CommonConstants;

public final class StringUtil {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";
	
	
	private StringUtil() {
	}

	public static String capitalize(String string) {
		return String.valueOf(string.charAt(0)).toUpperCase()
				+ string.substring(1);
	}

	public static boolean isNotEmpty(String str) {
		return (str != null && str.length() > 0);
	}

	public static boolean isEmpty(String string) {
		return ((string == null) || (string.length() == 0));
	}

	public static boolean isNumber(String str) {
		if (str != null && str.length() > 0) {
			for (int i = 0; i < str.length(); i++) {
				String temp = str.substring(i, i + 1);
				if (temp.compareTo("0") < 0 || temp.compareTo("9") > 0) {
					return false;
				}
			}
		} else {
			return false;
		}

		return true;

	}

	public static boolean compare(String str1, String str2) {
		if (isEmpty(str1) && isEmpty(str2)) {
			return true;
		} else if (!isEmpty(str1) && !isEmpty(str2)) {
			return (str1.equals(str2));
		} else {
			return false;
		}
	}

	public static boolean compareIgnorCase(String str1, String str2) {
		if (isEmpty(str1) && isEmpty(str2)) {
			return true;
		} else if (!isEmpty(str1) && !isEmpty(str2)) {
			return (str1.equalsIgnoreCase(str2));
		} else {
			return false;
		}
	}

	public static String replace(String src, String oldStr, String newStr) {
		int index;
		StringBuffer buffer;

		if (isEmpty(src) || isEmpty(oldStr) || (newStr == null)) {
			return src;
		}

		buffer = new StringBuffer(src);
		index = src.length();

		while ((index = src.lastIndexOf(oldStr, index)) >= 0) {
			buffer.replace(index, index + oldStr.length(), newStr);

			index = index - oldStr.length();
		}

		return buffer.toString();
	}

	public static String replaceIgnoreCase(String src, String oldStr,
			String newStr) {

		int index;
		StringBuffer buffer;
		String s;

		if (isEmpty(src) || isEmpty(oldStr) || (newStr == null)) {
			return src;
		}

		s = src.toLowerCase();
		oldStr = oldStr.toLowerCase();
		buffer = new StringBuffer(src);
		index = s.length();

		while ((index = s.lastIndexOf(oldStr, index)) >= 0) {
			buffer.replace(index, index + oldStr.length(), newStr);

			index = index - oldStr.length();
		}

		return buffer.toString();
	}

	public static String replaceChar(String src, char oldChar, char newChar) {
		StringBuffer buf = new StringBuffer(src);
		int length = buf.length();

		for (int i = 0; i < length; i++) {
			if (buf.charAt(i) == oldChar) {
				buf.setCharAt(i, newChar);
			}
		}
		return new String(buf);
	}

	public static String compressChar(String src, char oldChar) {
		if (src == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer();
		int length = src.length();
		boolean isOldChar = false;

		for (int i = 0; i < length; i++) {
			char c = src.charAt(i);
			if (c == oldChar) {
				if (!isOldChar) {
					buf.append(c);
				}
				isOldChar = true;
			} else {
				buf.append(c);
				isOldChar = false;
			}
		}
		return buf.toString();
	}

	public static String[] split(String str, char c) {
		char[] chs;
		int count;
		String[] ret;
		ArrayList<Integer> vSep;
		int[] sep;

		if ((str == null) || (str.length() == 0)) {
			return new String[0];
		}

		chs = str.toCharArray();
		count = 0;
		vSep = new ArrayList<Integer>();
		// Count the separators
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == c) {
				count++;
				vSep.add(new Integer(i));
			}
		}

		sep = new int[count + 2];
		for (int i = 0; i < count; i++) {
			sep[i + 1] = ((Integer) vSep.get(i)).intValue();
		}
		sep[0] = -1;
		sep[count + 1] = str.length();

		ret = new String[count + 1];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = str.substring(sep[i] + 1, sep[i + 1]);
		}
		return ret;
	}

	public static String[] split(String str, String delimiter) {
		ArrayList<String> array = new ArrayList<String>();
		int index = 0;
		int begin = 0, end;
		String[] result = new String[0];

		if (isEmpty(str)) {
			return new String[0];
		}

		while (true) {
			index = str.indexOf(delimiter, begin);

			if (index == begin) {
				if (index >= 0) {
					array.add("");
				}
				begin += delimiter.length();
			} else if (index > begin) {
				end = index;

				array.add(str.substring(begin, end));

				begin = index + delimiter.length();
			} else {
				if ((begin >= 0) && (begin < str.length())) {
					array.add(str.substring(begin));
				}

				break;
			}
		}

		if (str.endsWith(delimiter)) {
			array.add("");
		}
		if (array.size() > 0) {
			result = new String[array.size()];

			array.toArray(result);
		}

		return result;
	}

	public static String join(Object[] array, String separator) {
		if (separator == null) {
			separator = "";
		}
		int arraySize = array.length;
		int bufSize = (arraySize == 0 ? 0
				: (array[0].toString().length() + separator.length())
						* arraySize);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				buf.append(separator);
			}
			buf.append(array[i]);
		}
		return buf.toString();
	}

	public static boolean isCharInRange(char c, char start, char end) {
		return ((c >= start) && (c <= end));
	}

	public static boolean isWhiteSpace(byte c) {
		return (SPACE_TAB[c] == 1);
	}

	public static String warp(String str, int len) {
		StringBuffer buffer;

		if (isEmpty(str)) {
			return str;
		}

		if ((len <= 0) || (len >= str.length())) {
			return str;
		}

		buffer = new StringBuffer();
		StringReader reader = new StringReader(str);
		BufferedReader r = new BufferedReader(reader);
		String line;
		try {
			while ((line = r.readLine()) != null) {
				for (int i = 0; i < line.length(); i = i + len) {
					if (i + len < line.length()) {
						buffer.append(line.substring(i, i + len));
					} else {
						buffer.append(line.substring(i, line.length()));
					}

					buffer.append("\n");
				}
			}
		} catch (IOException ex) {
		} finally {
			try {
				r.close();
			} catch (IOException ex) {
			}
		}
		return buffer.toString();
	}

	private static final byte SPACE_TAB[] = { 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1,
			1, 1, 1, 0, 0, /* 0x00 - 0x0f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x10 - 0x1f */
			1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x20 - 0x2f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x30 - 0x3f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x40 - 0x4f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x50 - 0x5f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x60 - 0x8f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x70 - 0x7f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x80 - 0x8f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0x90 - 0x9f */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0xa0 - 0xaf */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0xb0 - 0xbf */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0xc0 - 0xcf */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0xd0 - 0xdf */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, /* 0xe0 - 0xef */
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 /* 0xf0 - 0xff */
	};

	public static boolean isValidName(String txt) {
		for (int i = 0; i < txt.length(); i++) {
			char cur = txt.charAt(i);

			// if (!Character.isLetter(cur) && !Character.isDigit(cur)
			// && cur != '#' && cur != '$' && cur != '&' && cur != '+'
			// && cur != '-' && cur != '_' && cur != '~' && cur != '@')
			if (!Character.isLetter(cur) && !Character.isDigit(cur)
					&& cur != '_')
				return false;
		}
		return true;
	}

	public static String getInvalidNameErrMsg() {
		return "Name must be consisted of letter,digit,#,$,&,+,-,_,~,@.";
	}

	/**
	 * Returns true if the email address is valid. These are of the form:
	 * "local-part@domain"
	 * 
	 * @param theEmail
	 *            the email address
	 * @return true if the email address is valid.
	 */
	public static boolean isValidEmail(String theEmail) {

		if (theEmail == null)
			return false;
		else if (theEmail.length() == 0)
			return false;
		else if (theEmail.length() > 78) // email addresses must fit on one
											// line
			return false;
		else {
			// if last character is a period, remove it
			if (theEmail.charAt(theEmail.length() - 1) == '.')
				theEmail = theEmail.substring(0, theEmail.length() - 1);
			// check for presence of "at" sign
			int atIndex = theEmail.indexOf('@');
			if (atIndex < 0)
				return false;

			// check for valid characters in the mailbox portion of the address
			String mailbox = theEmail.substring(0, atIndex);
			if (mailbox == null || mailbox.length() == 0)
				return false;
			else {
				int oldDotIndex = 0;
				int dotEnd = mailbox.indexOf('.', oldDotIndex);
				boolean done = false;
				do {
					// cannot have 2 dots in a row
					if (dotEnd == oldDotIndex)
						return false;
					if (dotEnd < 0) {
						dotEnd = mailbox.length();
						done = true;
					}
					for (int i = oldDotIndex; i < dotEnd; i++) {
						char cur = mailbox.charAt(i);
						if (!Character.isLetter(cur) && !Character.isDigit(cur)
								&& cur != '!' && cur != '#' && cur != '$'
								&& cur != '%' && cur != '&' && cur != '\''
								&& cur != '*' && cur != '+' && cur != '-'
								&& cur != '/' && cur != '=' && cur != '?'
								&& cur != '^' && cur != '_' && cur != '`'
								&& cur != '{' && cur != '|' && cur != '}'
								&& cur != '~')
							return false;
					}
					oldDotIndex = dotEnd + 1;
					dotEnd = mailbox.indexOf('.', oldDotIndex + 1);
				} while (!done);
			}

			// check for a valid domain name
			String domain = theEmail.substring(atIndex + 1);
			if (domain == null || domain.length() == 0)
				return false;
		}
		return true;
	} // end isValidEmail

	/* added by xmsong, 2003-4-8 */
	public static String trimLeft(String str, char c) {
		if (str == null)
			return null;

		int length = str.length();
		if (length == 0)
			return "";

		StringBuffer buffer = new StringBuffer(str);

		int index;

		for (index = 0; index < length && buffer.charAt(index) == c; index++)
			;

		if (index == length)
			return "";

		return buffer.substring(index);
	}

	/* added by xmsong, 2003-4-8 */
	public static String trimRight(String str, char c) {
		if (str == null)
			return null;

		int length = str.length();
		if (length == 0)
			return "";

		StringBuffer buffer = new StringBuffer(str);

		int index;
		for (index = length - 1; index >= 0 && buffer.charAt(index) == c; index--)
			;

		if (index < 0 && buffer.charAt(0) == c)
			return "";

		return buffer.substring(0, index + 1);
	}

	/* added by xmsong, 2003-4-8 */
	public static String trimLeft(String str) {
		return trimLeft(str, ' ');
	}

	/* added by xmsong, 2003-4-8 */
	public static String trimRight(String str) {
		return trimRight(str, ' ');
	}

	public static boolean includePatternChar(String pattern) {
		int len = pattern.length();
		for (int i = 0; i < len; i++) {
			char c = pattern.charAt(i);
			if (c == '*' || c == '?')
				return true;
		}
		return false;
	}

	public static Pattern getPattern(String pattern, boolean case_sensitive) {
		StringBuffer sbuf = new StringBuffer();

		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (c == '*' || c == '?')
				sbuf.append('.');
			else if ("\\[^]!+()|$.{}<>".indexOf(c) >= 0)
				sbuf.append('\\');
			sbuf.append(c);
		}

		if (case_sensitive)
			return Pattern.compile(sbuf.toString());
		return Pattern.compile(sbuf.toString(), Pattern.CASE_INSENSITIVE);
	}

	/* format functions, added by xmsong 2003-01-21 */
	private static final int O2S_OPT_BIN = 1;

	private static final int O2S_OPT_OCT = 2;

	private static final int O2S_OPT_HEX = 3;

	private static class _STRTOI {
		public int value = 0;

		public int position = 0;

		public char lastc = 0;
	}

	private static String o2s(char cs, char cm, int width, int prec,
			int option, Object obj) {
		StringBuffer buf = new StringBuffer();

		if (obj == null)
			buf.append("(null)");
		else if (obj instanceof Short || obj instanceof Integer) {
			int value;
			if (obj instanceof Short)
				value = ((Short) obj).intValue();
			else
				value = ((Integer) obj).intValue();
			if (option == O2S_OPT_BIN)
				buf.append(Integer.toBinaryString(value));
			else if (option == O2S_OPT_OCT)
				buf.append(Integer.toOctalString(value));
			else if (option == O2S_OPT_HEX)
				buf.append(Integer.toHexString(value));
			else
				buf.append(Integer.toString(value));
		} else if (obj instanceof Long) {
			long value = ((Long) obj).longValue();
			if (option == O2S_OPT_BIN)
				buf.append(Long.toBinaryString(value));
			else if (option == O2S_OPT_OCT)
				buf.append(Long.toOctalString(value));
			else if (option == O2S_OPT_HEX)
				buf.append(Long.toHexString(value));
			else
				buf.append(Long.toString(value));
		} else if (obj instanceof Float) {
			float value = ((Float) obj).floatValue();
			buf.append(Float.toString(value));
			if (prec >= 0) {
				int l1 = buf.length();
				int pos = -1;
				for (int i1 = 0; i1 < l1; i1++) {
					if (buf.charAt(i1) == '.')
						pos = i1;
				}
				if (pos > 0) {
					int l2 = l1 - pos - 1;
					if (l2 > prec) {
						String tmp;
						if (prec == 0)
							tmp = buf.substring(0, pos + prec);
						else
							tmp = buf.substring(0, pos + 1 + prec);
						buf = new StringBuffer(tmp);
					} else if (l2 < prec) {
						buf.append(strMake('0', prec - l2));
					}
				} else
					buf.append(strMake('0', prec));
			}
		} else if (obj instanceof Double) {
			double value = ((Double) obj).doubleValue();
			buf.append(Double.toString(value));
			if (prec >= 0) {
				int l1 = buf.length();
				int pos = -1;
				for (int i1 = 0; i1 < l1; i1++) {
					if (buf.charAt(i1) == '.')
						pos = i1;
				}
				if (pos > 0) {
					int l2 = l1 - pos - 1;
					if (l2 > prec) {
						String tmp;
						if (prec == 0)
							tmp = buf.substring(0, pos + prec);
						else
							tmp = buf.substring(0, pos + 1 + prec);
						buf = new StringBuffer(tmp);
					} else if (l2 < prec) {
						buf.append(strMake('0', prec - l2));
					}
				} else
					buf.append(strMake('0', prec));
			}
		} else
			buf.append(obj.toString());

		int length = buf.length();
		char c0 = 0;
		if (length > 0) {
			c0 = buf.charAt(0);
			if (c0 == '+' || c0 == '-' || c0 == '.')
				buf.deleteCharAt(0);
			else
				c0 = 0;
		}

		if (length < width) {
			if (cs == '-' || cs == 0)
				buf.insert(0, strMake(cm, width - length));
			else
				buf.append(strMake(cm, width - length));
		}

		if (c0 != 0)
			buf.insert(0, c0);

		return buf.toString();
	}

	private static _STRTOI _strtoi(String str) {
		StringBuffer buf = new StringBuffer(str);

		_STRTOI r = new _STRTOI();

		int length = buf.length();
		int i;
		for (i = 0; i < length; i++) {
			char c = buf.charAt(i);
			if (c < '0' || c > '9') {
				r.lastc = c;
				break;
			}
		}

		if (i > 0) {
			r.value = Integer.parseInt(str.substring(0, i));
			r.position = i;
		}

		return r;
	}

	public static String strMake(char c, int length) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < length; i++)
			buf.append(c);

		return buf.toString();
	}

	public static String strFormat(String str, Object[] params) {
		StringBuffer r = new StringBuffer();

		StringBuffer buf = new StringBuffer(str);

		int length = buf.length();
		int olength = params == null ? 0 : params.length;
		int i, j;
		char cs = 0, cm = 0;
		int width = -1, prec = -1, option = 0;
		boolean parse = false;
		_STRTOI rtmp;
		for (i = j = 0; i < length; i++) {
			if (j >= olength)
				break;

			char c = buf.charAt(i);
			if (c == '%') {
				i++;
				if (i < length) {
					char c1 = buf.charAt(i);
					if (c1 == c) {
						r = r.append(c);
						continue;
					} else {
						parse = true;
						cs = cm = 0;
						width = prec = -1;
						option = 0;
						c = c1;
					}
				} else
					break;
			}

			if (!parse) {
				r.append(c);
				continue;
			}

			if (cs == 0 && (c == '+' || c == '-')) {
				cs = c;
				continue;
			}

			if (cs != 0 && cm == 0) {
				cm = c;
				continue;
			}

			if (width < 0) {
				rtmp = _strtoi(buf.substring(i));
				width = rtmp.value;
				if (rtmp.lastc == '.')
					i += rtmp.position;
				else
					i += rtmp.position - 1;
				continue;
			}

			if (prec == -1) {
				rtmp = _strtoi(buf.substring(i));
				prec = rtmp.position == 0 ? -2 : rtmp.value;
				i += rtmp.position - 1;
				continue;
			}

			parse = false;
			boolean bo2s = true;
			boolean uc = false, lc = false;
			switch (c) {
			case 's':
			case 'S':
				break;
			case 'v':
				lc = true;
				break;
			case 'V':
				uc = true;
				break;
			case 'b':
			case 'B':
				option = O2S_OPT_BIN;
				break;
			case 'o':
			case 'O':
				option = O2S_OPT_OCT;
				break;
			case 'x':
				lc = true;
				option = O2S_OPT_HEX;
				break;
			case 'X':
				uc = true;
				option = O2S_OPT_HEX;
				break;
			default:
			}

			if (bo2s) {
				String tmp = o2s(cs, cm, width, prec < 0 ? -1 : prec, option,
						params[j++]);
				if (uc)
					tmp = tmp.toUpperCase();
				else if (lc)
					tmp = tmp.toLowerCase();
				r.append(tmp);
			}
		}

		if (i < length)
			r = r.append(replace(buf.substring(i), "%%", "%"));

		return r.toString();
	}

	public static void appendStr(StringBuffer buf, CharSequence str, int len) {
		int space = len;

		if (str != null) {
			space = len - str.length();
			buf.append(str);
		}
		for (int i = 0; i < space; i++) {
			buf.append(' ');
		}
	}

	/* format functions, added by xmsong 2003-01-21 */

	public static String formatIp(String ip) {
		if (ip == null)
			return null;

		String[] elms = split(ip, ".");
		if (elms.length != 4)
			return null;
		try {
			StringBuffer sbuf = new StringBuffer();
			for (int i = 0; i < elms.length; i++) {
				int n = Integer.parseInt(elms[i]);
				if (n > 255 || n < 0)
					return null;
				if (i > 0)
					sbuf.append(".");
				sbuf.append(n);
			}
			return sbuf.toString();
		} catch (NumberFormatException e) {
			return null;
		}
	}

	public static long ip4ToLong(String ip) {
		if (ip == null)
			return -1;

		String[] elms = split(ip, ".");
		if (elms.length != 4)
			return -1;
		try {
			long ipl = 0;
			for (int i = 0; i < elms.length; i++) {
				int n = Integer.parseInt(elms[i]);
				if (n > 255 || n < 0)
					return -1;
				ipl = (ipl << 8) + n;
			}
			return ipl;
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public static String longToIp4(long ip) {
		if (ip < 0)
			return "";

		byte b1 = (byte) (ip >> 24);
		byte b2 = (byte) (ip >> 16);
		byte b3 = (byte) (ip >> 8);
		byte b4 = (byte) ip;

		StringBuffer sbuf = new StringBuffer();

		sbuf.append(b1 & 0xff);
		sbuf.append(".");
		sbuf.append(b2 & 0xff);
		sbuf.append(".");
		sbuf.append(b3 & 0xff);
		sbuf.append(".");
		sbuf.append(b4 & 0xff);

		return sbuf.toString();
	}

	public static boolean bytesEqual(byte[] b1, byte[] b2) {
		if (b1 == b2) {
			return true;
		}
		if ((b1 == null) || (b2 == null)) {
			return false;
		}
		if (b1.length != b2.length) {
			return false;
		}
		for (int i = 0; i < b1.length; i++) {
			if (b1[i] != b2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static String changeDoubleToString(double d) {
		DecimalFormat df = new DecimalFormat();
		df.setGroupingUsed(false);
		df.setMinimumFractionDigits(30);
		String source = df.format(d);

		int length = source.length();

		for (int i = 0; i < length; i++) {
			if (source.substring(source.length() - 1, source.length())
					.equalsIgnoreCase("0")) {
				source = source.substring(0, source.length() - 1);
			} else {
				return source;
			}
		}
		return source;
	}

	/**
	 * 
	 * @param length
	 * @return
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(allChar.length())));
		}
		return sb.toString();
	}

	public static String generateNumber(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
		}
		return sb.toString();
	}
	
	public static String column2property(String columnName){
		columnName = columnName.toLowerCase();
		if(columnName.indexOf("_") ==-1){
			return columnName;
		}
		boolean isUpper = false;
		StringBuffer sb = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		for(int i=0;i<columnName.length();i++){
			char currentChar = columnName.charAt(i);
			if('_' == currentChar){
				isUpper = true;
			}else{
				if(isUpper){
					if(currentChar>=97 && currentChar<=122){
						currentChar = (char)(((int)currentChar)-32);
					}
					isUpper = false;
				}
				sb.append(currentChar);
			}
		}
		return sb.toString();
	}
	
	public static String table2class(String tableName){
		tableName = tableName.toLowerCase();
		if(tableName.indexOf("_") ==-1){
			return (tableName.charAt(0)+CommonConstants.EMPTY_STRING).toUpperCase()+tableName.substring(1);
		}
		boolean isUpper = false;
		StringBuffer sb = new StringBuffer(CommonConstants.SHORT_STRING_BUFFER_LENGTH);
		for(int i=0;i<tableName.length();i++){
			char currentChar = tableName.charAt(i);
			if(i == 0){
				if(currentChar>=97 && currentChar<=122){
					currentChar = (char)(((int)currentChar)-32);
				}
				sb.append(currentChar);
			}else{
				if('_' == currentChar){
					isUpper = true;
				}else{
					if(isUpper){
						if(currentChar>=97 && currentChar<=122){
							currentChar = (char)(((int)currentChar)-32);
						}
						isUpper = false;
					}
					sb.append(currentChar);
				}
			}
		}
		return sb.toString();
	}
	
	public static String lowerFirstChar(String value){
		if(value==null || CommonConstants.EMPTY_STRING.equals(value)){
			return CommonConstants.EMPTY_STRING;
		}
		char firstChar = value.charAt(0);
		if(firstChar>=65 && firstChar<=90){
			firstChar = (char)(((int)firstChar)+32);
		}
		return new StringBuffer(value.length())
			.append(firstChar).append(value.substring(1)).toString();
	}
	
	public static String rightTrim(String value){
		if(value == null || value.trim().length() == 0)
			return null;
		if(value.trim().length() == value.length())
			return value;
		if(!value.startsWith(" ")){
			return value.trim();
		}else{
			return value.substring(0,value.indexOf(value.trim().substring(0,1))+value.trim().length());
		}
	}

	public static void main(String[] args) {
		//System.out.println(table2class("dede_addonarticle"));
		//System.out.println(table2class("dede_addonimages"));
		//System.out.println(table2class("dede_archives"));
		//System.out.println(table2class("dede_admin"));
		// System.out.println(commaSeparated("12"));
		// System.out.println(commaSeparated("123"));
		// System.out.println(commaSeparated("12345"));
		// System.out.println(commaSeparated("123456"));
		// System.out.println(commaSeparated("1234567"));
		// System.out.println(commaSeparated("12345678"));
		// System.out.println(commaSeparated("123456789"));
		// System.out.println(commaSeparated("1234567890"));
		//
		// System.out.println(commaSeparated(".01"));
		// System.out.println(commaSeparated("0.01"));
		// System.out.println(commaSeparated("12.01"));
		// System.out.println(commaSeparated("123.01"));
		// System.out.println(commaSeparated("12345.002"));
		// System.out.println(commaSeparated("123456.0003"));
		// System.out.println(commaSeparated("1234567.01"));
		// System.out.println(commaSeparated("12345678.002"));
		// System.out.println(commaSeparated("123456789.01"));
		// System.out.println(commaSeparated("1234567890.002"));

		// System.out.println(deCommaSeparated("0.01"));
		// System.out.println(deCommaSeparated("12.002"));
		// System.out.println(deCommaSeparated("12,345.002"));
		// System.out.println(deCommaSeparated("123,456.0003"));
		// System.out.println(deCommaSeparated("1,234,567.01"));
		// System.out.println(deCommaSeparated("12,345,678.002"));
		// System.out.println(deCommaSeparated("123,456,789.01"));
		// System.out.println(deCommaSeparated("1,234,567,890.002"));
		/**
		 * System.out.println(generateNumber(6));
		 * System.out.println(generateNumber(6));
		 * System.out.println(generateNumber(6));
		 * System.out.println(generateNumber(6));
		 * System.out.println(generateNumber(6));
		 * System.out.println(generateNumber(6));
		 ***/

	}

}
