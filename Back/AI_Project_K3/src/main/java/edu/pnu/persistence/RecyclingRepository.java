package edu.pnu.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.RecycleStaticsProjection;
import edu.pnu.domain.Recycling;

public interface RecyclingRepository extends JpaRepository<Recycling, String> {

	// query method
	@Query("select tr.rm, tr.ce, tr.date, tr.time, rl.category, rl.count" 
			+ " from Recycling tr"
			+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id" 
			+ " where tr.state='t' and rl.category= ?1")
	List<RecycleStaticsProjection> findRecycleStatisticsByCategory(String category);
	
	@Query("select tr.rm, tr.ce, tr.date, tr.time, rl.category, rl.count"
			+ " from Recycling tr"
			+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id"
			+ " where tr.state='t' and tr.date= ?1")
	List<RecycleStaticsProjection> findRecycleStaticsProjectionsByDate(LocalDate date);
}
