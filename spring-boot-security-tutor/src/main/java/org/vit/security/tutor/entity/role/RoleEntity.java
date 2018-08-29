package org.vit.security.tutor.entity.role;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.vit.security.tutor.entity.user.UserEntity;

import lombok.Data;

@Entity
@Table(name = "Roles")
@Data
public class RoleEntity implements GrantedAuthority {
	

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private Long roleId;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@ManyToMany(mappedBy = "roles")
	Set<UserEntity> users;

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleName;
	}
}
