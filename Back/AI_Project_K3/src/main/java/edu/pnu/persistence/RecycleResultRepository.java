package edu.pnu.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.RecycleRes;

public interface RecycleResultRepository extends JpaRepository<RecycleRes, String> {

	// query method
	Optional<RecycleRes> findByCategory(String type);
}
