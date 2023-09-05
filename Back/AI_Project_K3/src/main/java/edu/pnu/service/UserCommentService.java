package edu.pnu.service;

import java.util.List;

import edu.pnu.domain.UserComment;

public interface UserCommentService {
	
	//리뷰 작성
	public UserComment insertComment(UserComment comment);
	
	//리뷰 리스트
	public List<UserComment> commentLists(Integer id);
	
	//리뷰 수정
	public void updateComment(Integer id, UserComment comment) throws Exception;
	
	//delete review
	void deleteComment(UserComment comment);
}
