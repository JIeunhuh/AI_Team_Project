package edu.pnu.persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pnu.domain.Recycling;

public interface RecyclingRepository extends JpaRepository<Recycling, String> {

	// query method
	// DTO 문제 
	// @Query("select * " 
	// 	+ " from Recycling tr"
	// 	+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id")

	// List<Object[]> findRecycleStatisticsAll();

	@Query("select tr.rm, tr.ce, tr.date, tr.time, rl.category, rl.count" 
			+ " from Recycling tr"
			+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id" 
			+ " where tr.state='t' and rl.category= ?1")
	List<Object[]> findRecycleStatisticsByCategory(String category);
	
	@Query("select tr.rm, tr.ce, tr.date, tr.time, rl.category, rl.count"
			+ " from Recycling tr"
			+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id"
			+ " where tr.state='t' and tr.date between ?1 and ?2")
	List<Object[]> findRecycleStaticsProjectionsByDate(LocalDate date1, LocalDate date2);
	
	@Query("select tr.rm, tr.ce, tr.date, tr.time, rl.category, rl.count" 
			+ " from Recycling tr"
			+ " join RecycleRes rl on tr.detect_log_id=rl.detect_log_id" 
			+ " where tr.state='t' and tr.time between ?1 and ?2")
	List<Object[]> findRecycleStatisticsByTime(LocalTime time1, LocalTime time2);
}
