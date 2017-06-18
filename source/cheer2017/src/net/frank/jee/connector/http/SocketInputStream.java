package net.frank.jee.connector.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.StringManager;

public class SocketInputStream extends InputStream {
	
	protected static StringManager sm =
	        StringManager.getManager(Constants.Package);
	
	/**
	 * CR.
	 */
	private static final byte CR = (byte) '\r';

	/**
	 * LF.
	 */
	private static final byte LF = (byte) '\n';

	/**
	 * SP.
	 */
	private static final byte SP = (byte) ' ';

	/**
	 * HT.
	 */
	private static final byte HT = (byte) '\t';

	/**
	 * COLON.
	 */
	private static final byte COLON = (byte) ':';

	/**
	 * Lower case offset.
	 */
	private static final int LC_OFFSET = 'A' - 'a';                                                                                                                          

	/**
	 * Internal buffer.
	 */
	protected byte buf[];

	/**
	 * Last valid byte.
	 */
	protected int count;

	/**
	 * Position in the buffer.
	 */
	protected int pos;

	/**
	 * Underlying input stream.
	 */
	protected InputStream is;

	public SocketInputStream(InputStream is, int bufferSize) {
		this.is = is;
		buf = new byte[bufferSize];
	}

	@Override
	public int read() throws IOException {
		if(pos>=count){
			fill();
			if(pos>=count){
				return -1;
			}
		}
		return buf[pos++] & 0xff;
	}

	protected void fill() throws IOException {
		pos = 0;
		count = 0;
		int nRead = is.read(buf, 0, buf.length);
		if (nRead > 0) {
			count = nRead;
		}
	}

}
