package com.oyeks.fileupload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.EOFException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Service
//@RequiredArgsConstructor
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    private boolean handlerAdded = false;

    public Map<String, Object> uploadFile(MultipartFile file) throws IOException {

        if (file != null && !file.isEmpty()) {

            if (file.getSize() > 100 * 1024 * 1024) {
                throw new EOFException("File size exceeds maximum limit of 100MB");
            }

            String uniquePart = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "public_id", uniquePart,
                            "folder", "learning-platform",
                            "overwrite", true,
                            "resource_type", "auto"
                    ));

            String mediaUrl = null;
            String duration = "0";

            if (uploadResult.containsKey("secure_url")) {
                mediaUrl = uploadResult.get("secure_url").toString();
            }

            if (uploadResult.containsKey("duration")) {
                duration = String.valueOf(uploadResult.get("duration"));
            } else if (uploadResult.containsKey("data") && uploadResult.get("data") instanceof Map) {
                Map dataInfo = (Map) uploadResult.get("data");

                if (dataInfo.containsKey("video") && dataInfo.get("video") instanceof Map) {
                    Map videoInfo = (Map) dataInfo.get("video");

                    if (videoInfo.containsKey("duration")) {
                        duration = String.valueOf(videoInfo.get("duration"));
                    }
                }
            }

            Map<String, Object> simplifiedResponse = new HashMap<>();
            simplifiedResponse.put("mediaUrl", mediaUrl);
            simplifiedResponse.put("duration", duration);

            return simplifiedResponse;

        } else {
            throw new EOFException("File is required");
        }
    }



    public void deleteFile(String publicId) throws IOException {
        if (publicId != null && !publicId.isEmpty()) {
            try {

                cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            }catch (Exception e){
                e.printStackTrace();
            }

//            if (deleteResult.containsKey("result") && deleteResult.get("result").equals("ok")) {
//            } else {
//                // Deletion failed, handle accordingly
//                String errorMessage = deleteResult.containsKey("error") ? deleteResult.get("error").toString() : "Unknown error";
//                throw new CustomException("Failed to delete file from Cloudinary. Error: " + errorMessage);
//            }
        }
    }
}