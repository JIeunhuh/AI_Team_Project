package edu.pnu.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.UserBoard;

@Repository
public interface UserBoardRepository extends JpaRepository<UserBoard, String>  {
	
//	@query method
	Optional<UserBoard> findById(int id);
	
	Optional<UserBoard> deleteById(int id);

	List<UserBoard> findByUseridContaining(String keyword);
	
	List<UserBoard> findByTitleContaining(String keyword);
	
	List<UserBoard> findByTitleContainingOrContentContaining(String kw1, String kw2);
}
