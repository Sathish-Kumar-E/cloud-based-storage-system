package com.aws.cbss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.multipart.MultipartFile;

import com.aws.cbss.service.S3Service;

import static java.net.HttpURLConnection.HTTP_OK;

@RestController
public class S3Controller {
	
	@Autowired
	private S3Service s3Service;
	
	@PostMapping("upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		return s3Service.saveFile(file);
	}
	
	@GetMapping("download/{filename}")
	public ResponseEntity<byte[]> downloadFile(@PathVariable("filename") String filename) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", MediaType.ALL_VALUE);
		headers.add("Content-Disposition", "attachment; filename=" + filename);
		byte[] bytes = s3Service.downloadFile(filename);
		return ResponseEntity.status(HTTP_OK).headers(headers).body(bytes);
	}
	
	@DeleteMapping("delete/{filename}")
	public String deleteFile(@PathVariable("filename") String filename) {
		return s3Service.deleteFile(filename);
	}
	
	@GetMapping("list")
	public List<String> getAllFiles() {
		return s3Service.listAllFiles();
	}
	
}
