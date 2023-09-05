package edu.pnu.service;

import java.time.LocalDate;
import java.util.List;

import edu.pnu.domain.Recycling;
import edu.pnu.dto.RecycleDTO;

public interface RecyclingService {

	public List<Recycling> getAllRecyclings();

	public List<RecycleDTO> getRecycleType(String type);

	public List<RecycleDTO> getEachTime();

	public List<RecycleDTO> getEachDay(LocalDate Day);


}
