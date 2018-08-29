package org.vit.security.tutor.entity.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.vit.security.tutor.entity.role.RoleEntity;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class UserEntity implements UserDetails {
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "USER_NAME")
	private String userName;
	
	@Column(name = "ENCRYPTED_PASSWORD")
	private String encryptedPassword;
	
	@Column(name = "ENABLED")
	private boolean active;
	
	@ManyToMany
	@JoinTable(name = "Users_Roles", joinColumns =  @JoinColumn(name = "USER_ID", referencedColumnName="USER_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
	
	)
	Set<RoleEntity> roles;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return encryptedPassword;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return active;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return active;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return active;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.active;
	}
	
	
}
