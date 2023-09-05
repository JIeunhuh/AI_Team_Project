package edu.pnu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.UserBoard;
import edu.pnu.service.UserBoardService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class UserBoardController {
	
	private final UserBoardService boardService;
	
	@PostMapping("/insertBoard")
	public ResponseEntity<UserBoard> insert(@RequestBody UserBoard board) {
		UserBoard createBoard =  boardService.createBoard(board);
		return ResponseEntity.ok(createBoard);
	}
	
	@PutMapping("/updateBoard/{id}")
	public ResponseEntity<UserBoard> update(@PathVariable Integer id, @RequestBody UserBoard board){
		try {
			boardService.updateBoard(id, board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return ResponseEntity.ok(board);
		
	}
	
	@DeleteMapping("/deleteBoard/{id}")
	public ResponseEntity<String> delete(@PathVariable UserBoard id){
		boardService.deleteBoard(id);
		return ResponseEntity.ok("Delete Success");
	}
	
	@GetMapping("/boardList")
	public List<UserBoard> showAllList(){
		return boardService.readBoardLists();
	}
	
	@GetMapping("/searchBoard/nickname")
	public List<UserBoard> searchList(@RequestParam("nickname") String nickname){
		return boardService.searchNickname(nickname);
	}
	
	@GetMapping("/searchBoard/title")
	public List<UserBoard> searchTitle(@RequestParam("title") String title){
		return boardService.searchTitle(title);
	}
	
	@GetMapping("/searchBoard/keyword")
	public List<UserBoard> searchKw(@RequestParam("kw") String kw){
		return boardService.searchTitleOrContent(kw,kw);
	}
}
