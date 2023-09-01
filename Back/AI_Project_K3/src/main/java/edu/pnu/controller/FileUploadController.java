package edu.pnu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.service.FileUploadServiceImpl;
import lombok.RequiredArgsConstructor;

// restcontroller : RESTAPI를 위한 데이터를 반환하는 컨트롤러
// json & xml 형태의 데이터를 반환하는 컨트롤러에 사용
@RestController
@RequiredArgsConstructor
// 해당 컨트롤러 클래스 내의 모든 메서드에 대한 url 경로가 upload로 시작됨
// @RequestMapping("/upload")
public class FileUploadController {

	private final FileUploadServiceImpl fileUploadService;

	// @CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/fileupload")
	public String uploadCSVFile(@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				if (file.getOriginalFilename().endsWith(".csv")) {
					// CSV 파일 처리 로직
					return fileUploadService.uploadCSV(file);
				} else if (file.getOriginalFilename().endsWith(".xlsx")
						|| file.getOriginalFilename().endsWith(".xls")) {
					// 엑셀 파일 처리 로직
					return fileUploadService.uploadExcel(file);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return "Error occured : " + e.getMessage();
			}
		}
		return "error ! Excel 파일만 업로드 가능합니다";
	}
}