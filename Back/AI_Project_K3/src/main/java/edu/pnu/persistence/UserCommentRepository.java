package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.UserComment;

public interface UserCommentRepository extends JpaRepository<UserComment, String> {

}
