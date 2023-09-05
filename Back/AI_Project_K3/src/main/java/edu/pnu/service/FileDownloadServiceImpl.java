package edu.pnu.service;

import java.io.StringWriter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;

import edu.pnu.domain.Recycling;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileDownloadServiceImpl implements FileDownloadService {

	private final RecyclingService recycleService;
	
//	error 
	@Override
	public String fileDownToCSV() {
		try {
			List<Recycling> data = recycleService.getAllRecyclings(); // 데이터베이스에서 데이터 가져오기

			// CSV 파일 생성
			StringWriter writer = new StringWriter();
			CSVWriter csvWriter = new CSVWriter(writer);
			List<String[]> dataList = data.stream()
					.map(entity -> new String[] { 
					entity.getDetect_log_id().toString(),
					entity.getDevice_id().toString(),
					entity.getState().toString(), 
					entity.getTime().toString(), 
					entity.getDate().toString(), 
					entity.getCe().toString(),
					entity.getRm().toString()
			}).collect(Collectors.toList());
			
			csvWriter.writeAll(dataList);
			csvWriter.close();

			return writer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "error occured : "+e.getMessage();
		}
	}

	@Override
	public String fileDownToExcel() {
		// TODO Auto-generated method stub
		return null;
	}

}
