package sfy.option.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sfy.option.model.dto.paragraph.ParagraphDto;
import sfy.option.model.entity.ParagraphEntity;
import sfy.option.service.ParagraphService;

import java.util.List;

@RestController
@RequestMapping("/api/paragraphs")
@RequiredArgsConstructor
public class ParagraphController {

	private final ParagraphService paragraphService;

	@GetMapping("/all")
	public ResponseEntity<List<ParagraphEntity>> getAllParagraphs() {
		return ResponseEntity.ok(paragraphService.getAllParagraphs());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ParagraphEntity> getParagraphById(@PathVariable int id) {
		return ResponseEntity.ok(paragraphService.getParagraphById(id));
	}

	@PostMapping("")
	public ResponseEntity<Boolean> createParagraph(@RequestBody ParagraphDto paragraphDto) {
		return ResponseEntity.ok(paragraphService.createParagraph(paragraphDto));
	}

	@PutMapping("")
	public ResponseEntity<Boolean> updateParagraph(@RequestBody ParagraphEntity paragraphEntity) {
		return ResponseEntity.ok(paragraphService.updateParagraph(paragraphEntity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteParagraph(@PathVariable int id) {
		return ResponseEntity.ok(paragraphService.deleteParagraph(id));
	}
}
