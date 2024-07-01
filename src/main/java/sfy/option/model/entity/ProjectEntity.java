package sfy.option.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Entity
@Table(name = "Project")
@NoArgsConstructor
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int uid;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "url", nullable = false, unique = true)
    private String uri;

    @ManyToMany(mappedBy = "projects")
    private Set<UserEntity> users;

    @Builder
    public ProjectEntity(int uid, String userId, String title, String uri, Set<UserEntity> users) {
        this.uid = uid;
        this.userId = userId;
        this.title = title;
        this.uri = uri;
        this.users = users;
    }

    @Setter
    public void setTitle(String title) {
        this.title = title;
    }
}
