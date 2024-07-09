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

    public boolean createParagraph(ParagraphDto paragraphDto) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(paragraphDto.getProjectUid());
        if (optionalProjectEntity.isEmpty()) {
            throw new RuntimeException("Project not found with project uid: " + paragraphDto.getProjectUid());
        }

        // contentType 별로 처리 필요, 그림 <> 글
        paragraphRepository.save(ParagraphEntity.builder()
                .project(optionalProjectEntity.get())
                .blockNumber(paragraphDto.getBlockNumber())
                .contentType(paragraphDto.getContentType())
                .content(paragraphDto.getContent())
                .build());
        return true;
    }


    public boolean updateParagraph(ParagraphEntity paragraphEntity) {
        Optional<ParagraphEntity> optionalParagraph = paragraphRepository.findById(paragraphEntity.getUid());

        if (optionalParagraph.isEmpty()) {
            return false;
        }

        paragraphRepository.save(paragraphEntity);
        return true;
    }

    public boolean deleteParagraph(long uid) {
        if (!paragraphRepository.existsById(uid)){
            return false;
        }

        paragraphRepository.deleteById(uid);
        return true;
    }

    public ParagraphEntity getParagraphById(long uid) {
        Optional<ParagraphEntity> optionalParagraph = paragraphRepository.findById(uid);
        return optionalParagraph.orElse(null);
    }

    public List<ParagraphEntity> getAllParagraphs() {
        return paragraphRepository.findAll();
    }
}
