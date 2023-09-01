package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.UserBoard;

public interface UserBoardRepository extends JpaRepository<UserBoard, String>  {

}
