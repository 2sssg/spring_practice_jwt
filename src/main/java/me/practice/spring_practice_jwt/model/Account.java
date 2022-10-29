package me.practice.spring_practice_jwt.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import me.practice.spring_practice_jwt.enums.Role;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter @Setter
public class Account {

	@Id @GeneratedValue
	private Integer id;

	private String username;

	private String password;

	private String email;

	@Enumerated(EnumType.STRING)
	private Role role;

	@CreationTimestamp
	private Timestamp createDate;
}
