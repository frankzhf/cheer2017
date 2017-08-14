package net.frank.commons.util;

import net.frank.commons.CommonConstants;

public final class PermissionUtil {
	public static Boolean[] integerToBoolean(Integer value) {
		Boolean[] returnValue = new Boolean[] { false, false, false };
		if (value == null) {
			return returnValue;
		}
		if (value >= CommonConstants.PERMISSION.READ) {
			returnValue[0] = true;
			value -= CommonConstants.PERMISSION.READ;
		}
		if (value >= CommonConstants.PERMISSION.WRITE) {
			returnValue[1] = true;
			value -= CommonConstants.PERMISSION.WRITE;
		}
		if (value >= CommonConstants.PERMISSION.RUN) {
			returnValue[2] = true;
			value -= CommonConstants.PERMISSION.RUN;
		}
		return returnValue;
	}

	public static Integer booleanToInteger(Boolean[] permissions) {
		Integer returnValue = new Integer(0);
		if (permissions == null) {
			return returnValue;
		}
		if (permissions[0])
			returnValue += CommonConstants.PERMISSION.READ;
		if (permissions[1])
			returnValue += CommonConstants.PERMISSION.WRITE;
		if (permissions[2])
			returnValue += CommonConstants.PERMISSION.RUN;
		return returnValue;
	}
}
