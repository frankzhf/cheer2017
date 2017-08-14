package net.frank.commons.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class OsUtil {
	
	private static final String SYS_PROP_OS_KEY = "os.name";
	private static final String WIN_COMMAND_START = "cmd.exe";
	private static final String WIN_COMMAND_PARAM = "/c";
	
	private static final String UNIT_COMMAND_START = "/bin/sh";
	private static final String UNIT_COMMAND_PARAM = "-c";
	
	public interface RETURN_TYPE {
		int SUCCESS = 0;
		int ERROR = -1;
	}
	
	public static class CommandReturn {
		private int type;
		private String value;

		public CommandReturn(int type, String value) {
			this.type = type;
			this.value = value;
		}

		public int getType() {
			return this.type;
		}

		public String getValue() {
			return this.value;
		}
	}
	
	public static boolean isWin(){
		String osName = System.getProperty(SYS_PROP_OS_KEY);
		if (osName != null) {
			if (osName.startsWith("Windows")) {
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public static String[] getOsBatchCommand(String commandLine){
		if(isWin()){
			return new String[]{
					WIN_COMMAND_START,
					WIN_COMMAND_PARAM,
					commandLine
			};
		}else{
			return new String[]{
					UNIT_COMMAND_START,
					UNIT_COMMAND_PARAM,
					commandLine
			};
		}
	}
	
	public static CommandReturn execute(String commandLine) {
		String[] commandGroup = getOsBatchCommand(commandLine);
		Runtime runtime = Runtime.getRuntime();
		String errorMessage = "";
		try {
			Process prc = runtime.exec(commandGroup);
			prc.waitFor();
			InputStream is = null;

			if (prc.exitValue() == 0) {
				is = prc.getInputStream();
			} else {
				is = prc.getErrorStream();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			StringBuffer cmdout = new StringBuffer();
			while ((line = br.readLine()) != null) {
				cmdout.append(line).append("\n");
			}
			if (prc.exitValue() == 0) {
				return new CommandReturn(RETURN_TYPE.SUCCESS, cmdout.toString());
			} else {
				return new CommandReturn(RETURN_TYPE.ERROR, cmdout.toString());
			}
		} catch (IOException e) {
			errorMessage = e.getMessage();
		} catch (InterruptedException e) {
			errorMessage = e.getMessage();
		}
		return new CommandReturn(RETURN_TYPE.ERROR, errorMessage);
	}
}
