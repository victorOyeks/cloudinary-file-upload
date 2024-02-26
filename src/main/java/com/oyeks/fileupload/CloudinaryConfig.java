package com.oyeks.fileupload;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        //https://res.cloudinary.com/dgo26zoyw/video/upload/v1707571144/learning-platform/20240210_131900.mpeg
        String cloudName = "dgo26zoyw";
        String apiKey = "437671688726376";
        String apiSecret = "ifEP85xanQe9uBva1iiCTUq39Gk";

        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret
        ));
    }
}