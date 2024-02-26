package com.oyeks.fileupload;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/cloudinary/")
@RequiredArgsConstructor
public class Upload {

    private final CloudinaryService cloudinaryService;
//    private final Testing testing;

    @PostMapping("upload-files")
    public ResponseEntity<Map> uploadImages(@RequestBody MultipartFile file) throws IOException {
        Map apiResponse = cloudinaryService.uploadFile(file);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping("delete-files")
    public void deleteFiles(@RequestParam String publicId) throws IOException {
        cloudinaryService.deleteFile(publicId);
    }
//
//    @PostMapping("hello")
//    public String hello() throws IOException {
//        return testing.returnString();
//    }
//
//    @PostMapping("hello-again")
//    public String helloAgain() throws IOException {
//        return testing.returnAnotherString();
//    }
}