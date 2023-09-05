package edu.pnu.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	public String uploadCSV(MultipartFile file);
	public String uploadExcel(MultipartFile file);
	public String imageUpload(MultipartFile file);
}
