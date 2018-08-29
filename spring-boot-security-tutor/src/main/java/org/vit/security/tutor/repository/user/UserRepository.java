package org.vit.security.tutor.repository.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vit.security.tutor.entity.user.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
		
	UserEntity findByUserName(String userId);
}
