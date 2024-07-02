package sfy.option.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Entity
@Table(name = "User")
@NoArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToMany
	@JoinTable(
			name = "User_Project",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "project_uid")
	)
	private Set<ProjectEntity> projects;

	@Builder
	public UserEntity(String id, String password, Set<ProjectEntity> projects) {
		this.id = id;
		this.password = password;
		this.projects = projects;
	}
}
