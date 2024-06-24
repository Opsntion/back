package sfy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfy.option.model.entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}