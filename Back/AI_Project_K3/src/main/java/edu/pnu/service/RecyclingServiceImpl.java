package edu.pnu.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.pnu.domain.RecycleStaticsProjection;
import edu.pnu.domain.Recycling;
import edu.pnu.dto.RecycleDTO;
import edu.pnu.persistence.RecycleResultRepository;
import edu.pnu.persistence.RecyclingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RecyclingServiceImpl implements RecyclingService {

    private final RecyclingRepository recycleRepo;
    private final RecycleResultRepository recycleResRepo;
    

    @Override
    public List<Recycling> getAllRecyclings() {
        return recycleRepo.findAll();
    }

    @Override
    public List<RecycleDTO> getRecycleType(String type) {	
    	 List<RecycleStaticsProjection> projections = recycleRepo.findRecycleStatisticsByCategory(type);
       return projections.stream().map(RecycleDTO::from).collect(Collectors.toList());
    }

    @Override
    public List<RecycleDTO> getEachTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEachTime'");
    }

	@Override
	public List<RecycleDTO> getEachDay(LocalDate day) {
		List<RecycleStaticsProjection> projections = recycleRepo.findRecycleStaticsProjectionsByDate(day);
		return projections.stream().map(RecycleDTO::from).collect(Collectors.toList());
	}

}
