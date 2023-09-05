package edu.pnu.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, String> {
	
	// query method
	UserComment findById(Integer id);
	
	Optional<UserComment> deleteByBoardId(Integer id);

}
