package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Recycling;
import edu.pnu.persistence.RecyclingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RecyclingServiceImpl implements RecyclingService {

    private final RecyclingRepository recycleRepo;

    @Override
    public List<Recycling> getAllRecyclings() {
        return recycleRepo.findAll();
    }

    @Override
    public List<Recycling> getRecycleType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRecycleType'");
    }

    @Override
    public List<Recycling> getEachTime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEachTime'");
    }

    @Override
    public List<Recycling> getEachDay() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEachDay'");
    }

}
