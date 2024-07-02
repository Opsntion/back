package sfy.option.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sfy.option.model.dto.paragraph.ContentType;

@Getter
@Entity
@Table(name = "Paragraph")
@NoArgsConstructor
public class ParagraphEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "project_uid", nullable = false)
    private ProjectEntity project;

    @Column(name = "block_number", nullable = false)
    private int blockNumber;

    @Column(name = "content_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public ParagraphEntity(long id, ProjectEntity project, int blockNumber, ContentType contentType, String content) {
        this.id = id;
        this.project = project;
        this.blockNumber = blockNumber;
        this.contentType = contentType;
        this.content = content;
    }
}
