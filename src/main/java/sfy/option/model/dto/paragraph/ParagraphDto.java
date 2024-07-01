package sfy.option.model.dto.paragraph;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParagraphDto {
	String userId;
	String title;
	String content;

	@Builder
	public ParagraphDto(String userId, String title, String content, int viewCount) {
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
}
