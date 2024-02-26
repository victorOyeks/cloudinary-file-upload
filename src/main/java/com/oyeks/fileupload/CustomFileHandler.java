//package com.oyeks.fileupload;
//
//import com.oyeks.fileupload.logger.NewLineLoggerFormatter;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.logging.FileHandler;
//import java.util.logging.LogRecord;
//
//@Service
//public class CustomFileHandler extends FileHandler {
//
//	private static CustomFileHandler instance = null;
//	private String currentLogFileName;
//
//	private static final String LOG_DIRECTORY = path();
//
//	private CustomFileHandler() throws IOException, SecurityException {
//		super(getLogFileName(), true);
//		setFormatter(new NewLineLoggerFormatter());
//	}
//
//	private static String getLogFileName() {
//		LocalDate now = LocalDate.now();
//		return LOG_DIRECTORY + File.separator + "logs-" + now.format(DateTimeFormatter.ISO_LOCAL_DATE) + ".log";
//	}
//
//	private synchronized void updateLogFile() throws IOException {
//		String newLogFileName = getLogFileName();
//		if (!newLogFileName.equals(currentLogFileName)) {
//			close();
//			setOutputStream(new java.io.FileOutputStream(newLogFileName, true));
//			currentLogFileName = newLogFileName;
//		}
//	}
//
//	@Override
//	public synchronized void publish(LogRecord record) {
//		try {
//			updateLogFile();
//			super.publish(record);
//			flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//
//	private static String path() {
//
//		String localpath = "";
//
//		try {
//			File directory = new File("./BigFootLogs/");
//			localpath = directory.getCanonicalPath();
//			if (!directory.exists()) {
//				if (directory.mkdir()) {
//					System.out.println("Directory created: " + directory.getCanonicalPath());
//				} else {
//					System.err.println("Failed to create directory: " + directory.getCanonicalPath());
//				}
//			}
//			localpath = directory.getCanonicalPath();
//			System.out.println("Absolute name " + localpath);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return localpath;
//	}
//}