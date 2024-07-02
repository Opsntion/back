package sfy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfy.option.model.entity.ParagraphEntity;

public interface ParagraphRepository extends JpaRepository<ParagraphEntity, Long> {

}