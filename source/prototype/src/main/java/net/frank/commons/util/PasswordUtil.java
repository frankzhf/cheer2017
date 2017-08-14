package net.frank.commons.util;

import net.sf.acegisecurity.providers.encoding.Md5PasswordEncoder;
import net.sf.acegisecurity.providers.encoding.ShaPasswordEncoder;


public final class PasswordUtil {
	public static String MD5encode(String rawpassword){
		return new Md5PasswordEncoder().encodePassword(rawpassword,null);
	}
	public static String SHAencode(String rawpassword){
		return new ShaPasswordEncoder().encodePassword(rawpassword,null);
	}
}
