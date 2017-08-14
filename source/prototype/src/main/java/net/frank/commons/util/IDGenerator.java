package net.frank.commons.util;

public final class IDGenerator {

	private final long workerId;
	private final static long twepoch = 1361753741828L;
	private long sequence = 0L;
	private final static long workerIdBits = 8L;
	public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
	private final static long sequenceBits = 10L;

	private final static long workerIdShift = sequenceBits;
	private final static long timestampLeftShift = sequenceBits + workerIdBits;
	public final static long sequenceMask = -1L ^ -1L << sequenceBits;

	private long lastTimestamp = -1L;

	public IDGenerator(final long workerId) {
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(String.format(
					"worker Id can't be greater than %d or less than 0",
					maxWorkerId));
		}
		this.workerId = workerId;
	}

	private synchronized long nextId() {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = (this.sequence + 1) & sequenceMask;
			if (this.sequence == 0) {
				// System.out.println("###########" + sequenceMask);
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			try {
				throw new Exception(
						String.format(
								"Clock moved backwards.  Refusing to generate id for %d milliseconds",
								this.lastTimestamp - timestamp));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.lastTimestamp = timestamp;
		long nextId = (timestamp - twepoch << timestampLeftShift)
				| (workerId << workerIdShift) | (sequence);
		return nextId;
	}

	private long tilNextMillis(final long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	private long timeGen() {
		return System.currentTimeMillis();
	}

	private static IDGenerator generator;

	private static void init() {
		//try {
		//	PropertiesReader props = new PropertiesReader(
		//			"application.properties");
		//	String workerId = props.getProperty("idgenerator.workerid");
		//	generator = new IDGenerator(Long.parseLong(workerId));
		//} catch (Exception ex) {
		generator = new IDGenerator(1L);
		//}
	}

	public static Long generateId() {
		if (null == generator) {
			init();
		}
		return generator.nextId();
	}
	
	public static Long getWorkId(Long id){
		return (id & ((2<<(timestampLeftShift-1)) -1)) >> sequenceBits ;
	}
}
