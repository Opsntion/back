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
import java.util.Random;
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

    public ProjectDto getProjectById(int id) {
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

    public ProjectEntity updateProject(int id, RequestProjectDto requestProjectDto) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(id);
        if (optionalProjectEntity.isPresent()) {
            ProjectEntity projectEntity = optionalProjectEntity.get();
            projectEntity.setTitle(requestProjectDto.getTitle());
            // URI는 일반적으로 업데이트하지 않는다고 가정하고 무시
            return projectRepository.save(projectEntity);
        } else {
            // 해당 ID로 프로젝트를 찾지 못한 경우 예외 처리 또는 null 반환 등의 방법 선택
            throw new RuntimeException("Project not found with id: " + id);
        }
    }

    public boolean deleteProject(int id) {
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
