package org.apache.tomcat.util;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class StringManager {
	private ResourceBundle bundle;
	private static Map<String, StringManager> stringManagers = new HashMap<String, StringManager>();

	private StringManager(String packageName) {
		String baseName = packageName + ".LocalStrings";
		bundle = ResourceBundle.getBundle(baseName);
	}

	public synchronized static StringManager getManager(String packageName) {
		StringManager stringManager = stringManagers.get(packageName);
		if (stringManager == null) {
			stringManager = new StringManager(packageName);
			stringManagers.put(packageName, stringManager);
		}
		return stringManager;
	}

	public String getString(String key) {
		if (key == null) {
			String msg = "key is null";
			throw new NullPointerException(msg);
		}
		String result = null;
		try {
			result = bundle.getString(key);
		} catch (MissingResourceException e) {
			result = "can not find message with the key " + key;
		}
		return result;
	}

	public String getString(String key, Object[] args) {
		String result = null;
		String initMessage = getString(key);

		try {
			Object[] notNullArgs = args;
			for (int i = 0; i < args.length; i++) {
				if (args[i] == null) {
					if (notNullArgs == args)
						notNullArgs = (Object[]) args.clone();
					args[i] = "null";
				}
			}
			result = MessageFormat.format(initMessage, notNullArgs);
		}catch (IllegalArgumentException iae) {
			StringBuilder sb = new StringBuilder();
			sb.append(initMessage);
			for (int i = 0; i < args.length; i++) {
				sb.append(" arg[" + i + "]=" + args[i]);
			}
			result = sb.toString();

		}
		return result;
	}

	// 以下是方法的重载，方便客户端的调用
	public String getString(String key, Object arg) {
		Object[] args = new Object[] { arg };
		return getString(key, args);
	}

	public String getString(String key, Object arg1, Object arg2) {
		Object[] args = new Object[] { arg1, arg2 };
		return getString(key, args);
	}

	public String getString(String key, Object arg1, Object arg2, Object arg3) {
		Object[] args = new Object[] { arg1, arg2, arg3 };
		return getString(key, args);
	}

	public String getString(String key, Object arg1, Object arg2, Object arg3, Object arg4) {
		Object[] args = new Object[] { arg1, arg2, arg3, arg4 };
		return getString(key, args);
	}

}
