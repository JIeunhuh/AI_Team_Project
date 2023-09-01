package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import edu.pnu.domain.RecycleRes;
import edu.pnu.domain.Recycling;

public interface RecyclingService {

	public List<Recycling> getAllRecyclings();

	public Optional<RecycleRes> getRecycleType(String type);

	public List<Recycling> getEachTime();

	public List<Recycling> getEachDay(String Day);


}
