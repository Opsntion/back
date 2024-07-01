package sfy.option.model.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "User")
public class UserEntity {

	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;

	@Column(name = "password", nullable = false)
	private String password;

	@ManyToMany
	@JoinTable(
			name = "ProjectUser",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "project_uid")
	)
	private Set<ProjectEntity> projects;
}
