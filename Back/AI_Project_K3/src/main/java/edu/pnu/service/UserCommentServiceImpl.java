package edu.pnu.service;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.UserComment;
import edu.pnu.persistence.UserCommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommentServiceImpl implements UserCommentService {

	private final UserCommentRepository commentRepo;

	// table insert
	@Override
	public UserComment insertComment(UserComment comment) {
		// TODO Auto-generated method stub
		UserComment rv = new UserComment();
		rv.setContent(comment.getContent());
		rv.setDate(new Date());
		rv.setTime(LocalTime.now());
		rv.setUser_id(comment.getUser_id());
		rv.setBoardId(comment.getBoardId());
		return commentRepo.save(rv);
	}

	// read table
	@Override
	public List<UserComment> commentLists(Integer id) {
		List<UserComment> c = new ArrayList<>();
		UserComment newComment = commentRepo.findById(id);
		c.add(newComment);
		return c;

	}

	// update table
	@Override
	public void updateComment(Integer id, UserComment comment) throws Exception {
		// TODO Auto-generated method stub
		UserComment listComment = commentRepo.findById(id);
		if (!listComment.toString().isEmpty()) {
			listComment.setContent(comment.getContent());
			listComment.setDate(new Date());
			listComment.setTime(LocalTime.now());

			commentRepo.save(listComment);
		} else {
			throw new Exception("해당하는 board id가 없습니다.");
		}
	}

	// delete table
	@Override
	public void deleteComment(UserComment comment) {
		// TODO Auto-generated method stub
		commentRepo.deleteByBoardId(comment.getBoardId());
	}

}
