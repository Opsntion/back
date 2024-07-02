package sfy.option.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.model.dto.paragraph.ParagraphDto;
import sfy.option.model.entity.ParagraphEntity;
import sfy.option.model.entity.ProjectEntity;
import sfy.option.repository.ParagraphRepository;
import sfy.option.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParagraphService {

	private final ProjectRepository projectRepository;
	private final ParagraphRepository paragraphRepository;

	public List<ParagraphEntity> getAllParagraphs() {
		return paragraphRepository.findAll();
	}

	public ParagraphEntity getParagraphById(long id) {
		Optional<ParagraphEntity> optionalParagraph = paragraphRepository.findById(id);
		return optionalParagraph.orElse(null);
	}

	public boolean createParagraph(ParagraphDto paragraphDto) {
		Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(paragraphDto.getProjectId());
		// contentType 별로 처리 필요, 그림 <> 글
		if (optionalProjectEntity.isPresent()) {
			paragraphRepository.save(ParagraphEntity.builder()
					.project(optionalProjectEntity.get())
					.blockNumber(paragraphDto.getBlockNumber())
					.contentType(paragraphDto.getContentType())
					.content(paragraphDto.getContent())
					.build());
			return true;
		}
		throw new RuntimeException("Project not found with project id: " + paragraphDto.getProjectId());
	}

	public boolean deleteParagraph(long id) {
		paragraphRepository.deleteById(id);
		return true;
	}

	public boolean updateParagraph(ParagraphEntity paragraphEntity) {
		Optional<ParagraphEntity> optionalParagraph = paragraphRepository.findById(paragraphEntity.getId());
		if (optionalParagraph.isPresent()) {
			paragraphRepository.save(paragraphEntity);
			return true;
		} else {
			return false;
		}
	}
}
