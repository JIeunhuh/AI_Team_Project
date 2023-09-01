package edu.pnu.dto;

import edu.pnu.domain.RecycleRes;


public class RecycleDTO {
	private final Long id;
	private final String category;
	private final Integer count;  
	
	public RecycleResDTO(Long id, String category, Integer count) {
		this.id = id;
		this.category = category;
		this.count = count;
	}
	
	
	public static RecycleResDTO from(RecycleRes res) {
		return new RecycleResDTO(res.getId(), res.getCategory(), res.getCount());
	}
}
