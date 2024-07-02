package sfy.option.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sfy.option.model.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}