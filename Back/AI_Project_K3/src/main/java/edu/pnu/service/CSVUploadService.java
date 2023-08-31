package edu.pnu.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.domain.Recycling;
import edu.pnu.persistence.RecyclingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CSVUploadService {

	private final RecyclingRepository recyclingRepo;

	private List<String> splitString(String line) {
		List<String> list = new ArrayList<>();
		String[] columns = line.split(",");
		StringBuffer sb = new StringBuffer();
		int flag = 0;
		// {} 형태의 데이터가 들어가있는 column을 따로 추출 ('{}'안에 쉼표가 들어가 있음)
		for (String col : columns) {
			if (col.isEmpty()) {
				list.add(col);
				continue;
			}
			if (col.substring(0, 1).equals("\"")) {
				flag = 1;
			}
			if (flag == 0) {
				list.add(col);
			} else {
				if (flag == 1) {
					sb.append(col);
					flag++;
				} else if (flag == 2) {
					sb.append("," + col);
				}
				if (col.substring(col.length() - 1).equals("\"")) {
					flag = 0;
					list.add(sb.toString());
				}
			}
		}
		// columns의 갯수가 10개보다 작을때, 공백으로 채워줌
		for (int i = list.size(); i < 10; i++) {
			list.add("");
		}
		return list;
	}

	// read csv file -> insert DB
	@Transactional
	public String uploadCSV(MultipartFile file) {

		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"))) {
			// List<Recycling> dataList = new ArrayList<>();
			// ObjectMapper objMapper = new ObjectMapper();

			String line;
			br.readLine(); // header skip
			while ((line = br.readLine()) != null) {
				// split을 기준으로 columns 자름(근데 csv 파일인데 뭐가 기준인건지 모르겠다..)

				List<String> columns = splitString(line);

				// true인 경우, reason이 공백이기 때문에 바로 반복문 빠져나가서 종료됨, column 사이즈가 9보다 작기때문에 패싱당
				if (columns.size() < 9) {
					// 예상하는 컬럼 수보다 적을 경우 처리 (로그 출력 등)
					continue;
				}

				Long detect_log_id = Long.parseLong(columns.get(0));
				Integer device_id = Integer.parseInt(columns.get(1));
				String jsonStr = columns.get(2);
				LocalDate date = LocalDate.parse(columns.get(3));
				if (columns.get(4).length() < 8) {
					// columns.set(4, "0" + columns.get(4));
					String[] tList = columns.get(4).split(":");
					StringBuffer sb = new StringBuffer();
					for (int i = 0; i < tList.length; i++) {
						if (i != 0) {
							sb.append(":");
						}
						if (tList[i].length() == 2) {
							sb.append(tList[i]);
						} else {
							sb.append("0" + tList[i]);
						}
					}

					columns.set(4, sb.toString());
				}
				LocalTime time = LocalTime.parse(columns.get(4));
				Boolean state = Boolean.valueOf(columns.get(5));
				Integer ce = columns.get(6).isEmpty() ? 0 : Integer.parseInt(columns.get(6));
				Integer rm = columns.get(7).isEmpty() ? 0 : Integer.parseInt(columns.get(7));
				String reason = columns.get(8);
				String img_url = "";

				// gyo pt 에게 부탁..
				// Parse Json data
				// JsonNode jsonNode = objMapper.readTree(jsonStr);
				Recycling recycle = new Recycling();

				recycle.setDetect_log_id(detect_log_id);
				recycle.setDevice_id(device_id);
				recycle.setAi_result(columns.get(2).isEmpty() ? null : jsonStr);
				recycle.setDate(date);
				recycle.setTime(time);
				recycle.setState(state);
				recycle.setCe(ce);
				recycle.setRm(rm);
				recycle.setReason(columns.get(8).isEmpty() ? null : reason);
				recycle.setImg_url(img_url);

				// dataList.add(recycle);
				recyclingRepo.save(recycle);
			}

			// recyclingRepo.saveAll(dataList);
			br.close();

			return "Upload Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error Occurred : " + e.getMessage();
		}

	}
}
