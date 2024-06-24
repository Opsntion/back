package sfy.option.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDto {
	String userId;
	String title;
	String content;

	@Builder
	public BoardDto(String userId, String title, String content, int viewCount) {
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
}
