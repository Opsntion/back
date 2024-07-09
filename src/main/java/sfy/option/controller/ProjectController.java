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

    @PostMapping("")
    public ResponseEntity<Boolean> createProject(@RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.createProject(requestProjectDto));
    }

    @PutMapping("/{uid}")
    public ResponseEntity<Boolean> updateProject(@PathVariable("uid") long uid, @RequestBody RequestProjectDto requestProjectDto) {
        return ResponseEntity.ok(projectService.updateProject(uid, requestProjectDto));
    }

    @DeleteMapping("/{uid}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable("uid") long uid) {
        return ResponseEntity.ok(projectService.deleteProject(uid));
    }

    @GetMapping("/{uid}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable("uid") long uid) {
        return ResponseEntity.ok(projectService.getProjectById(uid));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }
}
