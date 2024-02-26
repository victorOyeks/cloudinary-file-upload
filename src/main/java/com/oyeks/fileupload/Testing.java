//package com.oyeks.fileupload;
//
//import com.oyeks.fileupload.CustomFileHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.logging.Logger;
//
//@Service
//public class Testing {
//
//    private final CustomFileHandler customFileHandler;
//    static final Logger logger = Logger.getLogger(Testing.class.getName());
//
//    private boolean handlerAdded = false;
//
//    @Autowired
//    public Testing(CustomFileHandler customFileHandler) {
//        this.customFileHandler = customFileHandler;
//    }
//
//    public String returnAnotherString() throws IOException {
//        if (!handlerAdded) {
//            logger.addHandler(customFileHandler);
//            handlerAdded = true;
//        }
//
//        logger.info("Saving Hello World");
//
//        return "Hello world";
//    }
//    public String returnString() throws IOException {
//        if (!handlerAdded) {
//            logger.addHandler(customFileHandler);
//            handlerAdded = true;
//        }
//        logger.info("Saving Hello Another World");
//        return "Hello world Again";
//    }
//}
