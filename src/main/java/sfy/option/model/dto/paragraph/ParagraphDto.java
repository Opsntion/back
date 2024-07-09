package sfy.option.model.dto.paragraph;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParagraphDto {
	private long projectUid;
	private int blockNumber;
	private ContentType contentType;
	private String content;
}
