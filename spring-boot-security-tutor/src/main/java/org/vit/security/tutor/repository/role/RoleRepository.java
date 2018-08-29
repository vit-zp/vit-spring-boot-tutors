package org.vit.security.tutor.repository.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.vit.security.tutor.entity.role.RoleEntity;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

}
