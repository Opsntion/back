package sfy.option.model.dto.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProjectDto {
	String userId;
	String title;
	String uri;

	@Builder
	public ProjectDto(String userId, String title, String uri) {
		this.userId = userId;
		this.title = title;
		this.uri = uri;
	}
}
