package sfy.option.model.entity;

import lombok.Getter;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import sfy.option.model.dto.paragraph.ContentType;

@Getter
@Entity
@Table(name = "Paragraph")
public class ParagraphEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int uid;

    @Column(name = "project_uid", nullable = false)
    private int projectUid;

    @Column(name = "block_number", nullable = false)
    private int blockNumber;

    @Column(name = "content_type", nullable = false)
    private ContentType contentType;

    @Column(name = "content", nullable = false)
    private String content;
}
