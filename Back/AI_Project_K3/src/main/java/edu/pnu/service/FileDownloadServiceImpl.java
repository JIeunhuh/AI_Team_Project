package edu.pnu.service;

import java.net.MalformedURLException;
import java.util.Optional;

import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.pnu.domain.ImageEntity;
import edu.pnu.persistence.ImageRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileDownloadServiceImpl implements FileDownloadService {

	private final RecyclingService recycleService;

  private final ImageRepository imageRepo;
	
//	error 
	@Override
	public String fileDownToCSV() {
		// try {
		// 	List<Recycling> data = recycleService.getAllRecyclings(); // 데이터베이스에서 데이터 가져오기

		// 	// CSV 파일 생성
		// 	StringWriter writer = new StringWriter();
		// 	CSVWriter csvWriter = new CSVWriter(writer);
		// 	List<String[]> dataList = data.stream()
		// 			.map(entity -> new String[] { 
		// 			entity.getDetect_log_id().toString(),
		// 			entity.getDevice_id().toString(),
		// 			entity.getState().toString(), 
		// 			entity.getTime().toString(), 
		// 			entity.getDate().toString(), 
		// 			entity.getCe().toString(),
		// 			entity.getRm().toString()
		// 	}).collect(Collectors.toList());
			
		// 	csvWriter.writeAll(dataList);
		// 	csvWriter.close();

		// 	return writer.toString();
		// } catch (Exception e) {
		// 	e.printStackTrace();
		// 	return "error occured : "+e.getMessage();
		// }
		return null;
	}

	@Override
	public String fileDownToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<UrlResource> downloadImage(String fileName) {
	
    Optional<ImageEntity> findFile = imageRepo.findByImageName(fileName);
    ImageEntity img = findFile.orElse(null);
    if(img==null) return null;

    String storeFileName = img.getImageName();
    String img_url = img.getImageUrl();

    // http response header(HTTP 응답 헤더) 속성으로 HTTP Response Body에 담겨진 값을 설정해줌
    // 브라우저에 표시되는지 첨부파일로 표시되어 다운로드 할것인지 정하는 속성
    String contentDisposition = "attachment; filename=\"" + storeFileName + "\"";
    UrlResource resource;
    try {
      resource = new UrlResource("file:"+ img_url);
    
      return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
            .body(resource);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
	}

}
