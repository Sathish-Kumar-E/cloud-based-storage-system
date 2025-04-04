package com.aws.cbss.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	
	String saveFile(MultipartFile file);

    byte[] downloadFile(String filename);

    String deleteFile(String filename);

    List<String> listAllFiles();
}
