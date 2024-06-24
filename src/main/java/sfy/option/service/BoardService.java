package sfy.option.service;

import org.springframework.stereotype.Service;
import sfy.option.model.dto.BoardDto;
import sfy.option.model.entity.BoardEntity;

import java.util.List;

@Service
public class BoardService {

	public List<BoardEntity> getAllBoards() {
		return null;
	}

	public BoardDto getBoardById(int id) {
		return null;
	}

	public boolean createBoard(BoardDto boardDto) {
		return true;
	}

	public boolean deleteBoard(int id) {
		return true;
	}

	public boolean updateBoard(int id, BoardDto boardDto) {
		return true;
	}

}
