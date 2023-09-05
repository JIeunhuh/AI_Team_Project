package edu.pnu.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.pnu.domain.UserBoard;
import edu.pnu.persistence.UserBoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserBoardServiceImpl implements UserBoardService {

	private final UserBoardRepository boardRepo;

	// Board 게시판 글
	@Override
	public UserBoard createBoard(UserBoard board) {
		UserBoard newBoard = new UserBoard();
		newBoard.setTitle(board.getTitle());
		newBoard.setContent(board.getContent());
//		newBoard.setDate(en);
		newBoard.setUserid(board.getUserid());
		newBoard.setDate(LocalDate.now());
		newBoard.setTime(LocalTime.now());
		newBoard.setViewcnt(0);
		return boardRepo.save(newBoard);
	}

	// list
	@Override
	public List<UserBoard> readBoardLists() {
		return boardRepo.findAll();
	}

	// update
	@Override
	public void updateBoard(Integer id, UserBoard board) throws Exception {
		Optional<UserBoard> optionalBoard = boardRepo.findById(id);
		if (optionalBoard.isPresent()) {
			UserBoard updateB = optionalBoard.get();
			updateB.setTitle(board.getTitle());
			updateB.setContent(board.getContent());
			updateB.setDate(LocalDate.now());
			updateB.setTime(LocalTime.now());
			
			boardRepo.save(updateB);
		}
		else {
			throw new Exception("해당 id에 해당하는 게시글을 찾을 수 없습니다.");
		}
	}

	// delete
	@Override
	public void deleteBoard(UserBoard board) {
		boardRepo.deleteById(board.getId());
	}

	// search
	@Override
	public List<UserBoard> searchNickname(String nickname) {
		// TODO Auto-generated method stub
		return boardRepo.findByUseridContaining(nickname);
	}

	@Override
	public List<UserBoard> searchTitle(String title) {
		// TODO Auto-generated method stub
		return boardRepo.findByTitleContaining(title);
	}

	@Override
	public List<UserBoard> searchTitleOrContent(String kw1, String kw2) {
		// TODO Auto-generated method stub
		return boardRepo.findByTitleContainingOrContentContaining(kw1, kw2);
	}
}
