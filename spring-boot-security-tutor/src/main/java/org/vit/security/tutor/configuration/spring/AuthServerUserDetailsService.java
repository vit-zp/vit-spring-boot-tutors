package org.vit.security.tutor.configuration.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vit.security.tutor.entity.user.UserEntity;
import org.vit.security.tutor.repository.user.UserRepository;

@Service
@Transactional
public class AuthServerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepo.findByUserName(username);
		userEntity.getRoles();
		return userEntity;
		
	}

}
