package sfy.option.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sfy.option.model.dto.project.ProjectDto;
import sfy.option.model.dto.project.RequestProjectDto;
import sfy.option.model.entity.ProjectEntity;
import sfy.option.model.entity.UserEntity;
import sfy.option.repository.ProjectRepository;
import sfy.option.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public Boolean createProject(RequestProjectDto requestProjectDto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(requestProjectDto.getUserId());

        if (optionalUserEntity.isEmpty()) {
            throw new RuntimeException("User not found with user uid: " + requestProjectDto.getUserId());
        }

        projectRepository.save(ProjectEntity.builder()
                .user(UserEntity.builder().id(requestProjectDto.getUserId()).build())
                .title(requestProjectDto.getTitle())
                .uri(generateRandomUrl())
                .build());
        return true;
    }

    public boolean updateProject(long uid, RequestProjectDto requestProjectDto) {
        Optional<ProjectEntity> optionalProjectEntity = projectRepository.findById(uid);

        if (optionalProjectEntity.isEmpty()) {
            throw new RuntimeException("Project not found with uid: " + uid);
        }

        ProjectEntity projectEntity = optionalProjectEntity.get();
        projectEntity.setTitle(requestProjectDto.getTitle());
        projectRepository.save(projectEntity);
        return true;
    }

    public boolean deleteProject(long uid) {
        if (!projectRepository.existsById(uid)) {
            return false;
        }

        projectRepository.deleteById(uid);
        return true;
    }

    private ProjectDto convertToDto(ProjectEntity projectEntity) {
        return ProjectDto.builder()
                .userId(projectEntity.getUser().getId())
                .title(projectEntity.getTitle())
                .uri(projectEntity.getUri())
                .build();
    }

    public ProjectDto getProjectById(long uid) {
        return convertToDto(Objects.requireNonNull(projectRepository.findById(uid).orElse(null)));
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository
                .findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private String generateRandomUrl() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

}
