package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.Recycling;

// @Service
public interface RecyclingService {

	public List<Recycling> getAllRecyclings();

	public List<Recycling> getRecycleType();

	public List<Recycling> getEachTime();

	public List<Recycling> getEachDay();

}
