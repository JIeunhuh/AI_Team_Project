package edu.pnu.service;

import java.util.List;
import java.util.Optional;

import edu.pnu.domain.UserBoard;

public interface UserBoardService {
	// 글 작성	
	public UserBoard createBoard(UserBoard board);
	// 목록
	public List<UserBoard> readBoardLists();
	// 글 수정
	public void updateBoard(Integer id, UserBoard board) throws Exception;
	// 글 검색(닉네임, 내용 + 제목, 제목 검색)
	public List<UserBoard> searchNickname(String nickname);
	
	public List<UserBoard> searchTitle(String title);
	
	public List<UserBoard> searchTitleOrContent(String kw1, String kw2);
	// 글 삭제
	void deleteBoard(UserBoard board);
	
}
