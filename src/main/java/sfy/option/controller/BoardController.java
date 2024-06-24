package sfy.option.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sfy.option.model.dto.BoardDto;
import sfy.option.model.entity.BoardEntity;
import sfy.option.service.BoardService;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping("/all")
	public ResponseEntity<List<BoardEntity>> getAllBoards() {
		return ResponseEntity.ok(boardService.getAllBoards());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoardDto> getBoardById(@PathVariable int id) {
		return ResponseEntity.ok(boardService.getBoardById(id));
	}

	@PostMapping("")
	public ResponseEntity<Boolean> createBoard(@RequestBody BoardDto boardDto) {
		return ResponseEntity.ok(boardService.createBoard(boardDto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Boolean> updateBoard(@PathVariable int id, @RequestBody BoardDto boardDto) {
		return ResponseEntity.ok(boardService.updateBoard(id, boardDto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteBoard(@PathVariable int id) {
		return ResponseEntity.ok(boardService.deleteBoard(id));
	}
}
