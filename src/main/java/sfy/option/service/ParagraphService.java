package sfy.option.service;

import org.springframework.stereotype.Service;
import sfy.option.model.dto.paragraph.ParagraphDto;
import sfy.option.model.entity.ParagraphEntity;

import java.util.List;

@Service
public class ParagraphService {

	public List<ParagraphEntity> getAllParagraphs() {
		return null;
	}

	public ParagraphDto getParagraphById(int id) {
		return null;
	}

	public boolean createParagraph(ParagraphDto projectDto) {
		return true;
	}

	public boolean deleteParagraph(int id) {
		return true;
	}

	public boolean updateParagraph(int id, ParagraphDto projectDto) {
		return true;
	}

}
