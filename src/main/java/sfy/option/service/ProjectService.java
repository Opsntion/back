package sfy.option.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.model.dto.project.ProjectDto;
import sfy.option.model.dto.project.RequestProjectDto;
import sfy.option.model.entity.ProjectEntity;
import sfy.option.repository.ProjectRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<ProjectDto> getAllProjects() {
        return projectRepository
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getProjectById(long id) {
        return convertToDto(Objects.requireNonNull(projectRepository.findById(id).orElse(null)));
    }

    public Boolean createProject(RequestProjectDto requestProjectDto) {
        ProjectEntity.builder()
                .userId(requestProjectDto.getUserId())
                .title(requestProjectDto.getTitle())
                .uri(generateRandomUrl())
                .build();
        return true;
    }

    public boolean updateProject(long id, RequestProjectDto requestProjectDto) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(id);
        if (optionalProjectEntity.isPresent()) {
            ProjectEntity projectEntity = optionalProjectEntity.get();
            projectEntity.setTitle(requestProjectDto.getTitle());
            projectRepository.save(projectEntity);
            return true;
        } else {
            throw new RuntimeException("Project not found with id: " + id);
        }
    }

    public boolean deleteProject(long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private ProjectDto convertToDto(ProjectEntity projectEntity) {
        return ProjectDto.builder()
                .userId(projectEntity.getUserId())
                .title(projectEntity.getTitle())
                .uri(projectEntity.getUri())
                .build();
    }

    private String generateRandomUrl() {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    }

}
