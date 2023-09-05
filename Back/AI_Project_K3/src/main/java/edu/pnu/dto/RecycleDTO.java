package edu.pnu.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import edu.pnu.domain.RecycleStaticsProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

//직렬화 때문에 기본 생성자 추가 함 : 직렬화가 무엇?인지
@Getter
@AllArgsConstructor
public class RecycleDTO {

	private final Integer rm;
	private final Integer ce;
	private final LocalTime time;
	private final LocalDate date;
	private final String category;
	private final Integer count;
	
	public RecycleDTO(Integer rm, Integer ce, LocalDate date, LocalTime time, String category, Integer count) {

		this.rm = rm;
		this.ce = ce;
		this.date = date;
		this.time = time;
		this.category = category;
		this.count = count;
	}
	
	//recyclestatisticsprojection -> recycleDTO로의 변환
	 public static RecycleDTO from(RecycleStaticsProjection projection) {
	        return new RecycleDTO(
	            projection.getRm(),
	            projection.getCe(),
	            projection.getDate(),
	            projection.getTime(),
	            projection.getCategory(),
	            projection.getCount()
	        );
	    }
}
