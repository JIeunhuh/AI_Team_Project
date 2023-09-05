package edu.pnu.controller;

import java.util.List;

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

import edu.pnu.domain.UserComment;
import edu.pnu.service.UserCommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class UserCommentController {

	private final UserCommentService commentService;

	@PostMapping("/insertComment")
	private UserComment insertRV(@RequestBody UserComment comment) {
		return commentService.insertComment(comment);
	}

	@GetMapping("/readComment")
	private List<UserComment> readRV(@RequestParam Integer id) {
		return commentService.commentLists(id);
	}

	@PutMapping("/updateComment/{id}")
	private String updateRV(@PathVariable Integer id, @RequestBody UserComment comment) {
		try {
			commentService.updateComment(id, comment);
			return "Upload Success!";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error occured : "+ e.getMessage();
		}
	}
	// 실행 안됨 ! 뿌이뿌이뿌
	@DeleteMapping("/deleteComment/{id}")
	private ResponseEntity<String> deleteRV(@PathVariable UserComment id) {
		commentService.deleteComment(id);
		return ResponseEntity.ok("Delete Success");
	}
}
