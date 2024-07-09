package sfy.option.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "Project")
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private long uid;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

    @Setter
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false, unique = true)
    private String uri;

    @Builder
    public ProjectEntity(long uid, UserEntity user, String title, String uri) {
        this.uid = uid;
        this.user = user;
        this.title = title;
        this.uri = uri;
    }
}
