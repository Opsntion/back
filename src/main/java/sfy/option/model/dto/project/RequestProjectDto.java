package sfy.option.model.dto.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestProjectDto {
    String userId;
    String title;

    @Builder
    public RequestProjectDto(String userId, String title) {
        this.userId = userId;
        this.title = title;
    }
}
