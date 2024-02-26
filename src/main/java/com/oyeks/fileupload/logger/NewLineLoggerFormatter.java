//package com.oyeks.fileupload.logger;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.logging.Formatter;
//import java.util.logging.LogRecord;
//
//public class NewLineLoggerFormatter extends Formatter{
//
//    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
//
//    @Override
//    public String format(LogRecord record) {
//        StringBuilder sb = new StringBuilder();
//        sb.append(dateFormat.format(new Date(record.getMillis()))).append(" ");
//        if (record.getSourceClassName() != null) {
//            sb.append(record.getSourceClassName()).append(" ");
//        }
//        if (record.getSourceMethodName() != null) {
//            sb.append(record.getSourceMethodName()).append(" ");
//        }
//        sb.append(record.getLevel()).append(": ");
//        sb.append(formatMessage(record)).append(System.lineSeparator());
//        sb.append(System.lineSeparator());
//        return sb.toString();
//    }
//}
