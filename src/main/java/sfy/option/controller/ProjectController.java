package sfy.option.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sfy.option.model.dto.project.ProjectDto;
import sfy.option.model.dto.project.RequestProjectDto;
import sfy.option.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable int id) {
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @PostMapping("")
    public ResponseEntity<Boolean> createProject(@RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.createProject(requestProjectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProject(@PathVariable int id, @RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.updateProject(id, requestProjectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable int id) {
        return ResponseEntity.ok(projectService.deleteProject(id));
    }
}
