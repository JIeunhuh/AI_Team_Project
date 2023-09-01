package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pnu.domain.RecycleRes;
import edu.pnu.domain.Recycling;
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
    public Optional<RecycleRes> getRecycleType(String type) {
       return recycleResRepo.findByCategory(type);
    }

    @Override
    public List<Recycling> getEachTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEachTime'");
    }

	@Override
	public List<Recycling> getEachDay(String Day) {
		// TODO Auto-generated method stub
		return null;
	}

}
