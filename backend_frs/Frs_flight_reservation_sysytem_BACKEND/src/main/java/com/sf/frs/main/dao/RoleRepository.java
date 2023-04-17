package com.sf.frs.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sf.frs.main.beans.Role;
import com.sf.frs.main.beans.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleName roleName);
}