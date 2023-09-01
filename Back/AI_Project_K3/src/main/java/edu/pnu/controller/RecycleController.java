package edu.pnu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.RecycleRes;
import edu.pnu.domain.Recycling;
import edu.pnu.service.RecyclingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class RecycleController {

	private final RecyclingService recycleService;

	// 모든 리스트 가져오기
	@GetMapping("/readAllRecycle")
	public List<Recycling> readDB() {
		return recycleService.getAllRecyclings();
	}

	// 분리수거 종류별 통계
	@GetMapping("/{type}")
	public Optional<RecycleRes> recyclingType(@PathVariable String type) {
		return recycleService.getRecycleType(type);
	}

	// 시간별 통계
	@GetMapping("/eachtime")
	public List<Recycling> readEachTime() {
		return recycleService.getEachTime();
	}

//	// 일자별 통계
//	@GetMapping("/eachday")
//	public List<Recycling> readEachDay() {
//		return recycleService.getEachDay();
//	}

}
