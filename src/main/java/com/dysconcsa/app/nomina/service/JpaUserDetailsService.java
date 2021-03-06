package com.dysconcsa.app.nomina.service;

import com.dysconcsa.app.nomina.model.RoleUser;
import com.dysconcsa.app.nomina.model.Users;
import com.dysconcsa.app.nomina.repository.IRoleRepository;
import com.dysconcsa.app.nomina.repository.IRoleUserRepository;
import com.dysconcsa.app.nomina.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleUserRepository roleUserRepository;
	@Autowired
	private IRoleRepository roleRepository;

	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Username: " + username);
		Users usuario = userRepository.findByUsername(username);
		if (usuario == null) {
			logger.error("Error en el Login: no existe el usuario '" + username + "' en el sistema!");
			throw new UsernameNotFoundException("Username: " + username + " no existe en el sistema!");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();
		var roles = roleUserRepository.findByIduser(usuario.getIdusers());
		for (RoleUser roleUser : roles) {
			var role = roleRepository.findById(roleUser.getRoleUserPK().getIdrole()).get();
			logger.info("Role: ".concat(role.getDescription()));
			authorities.add(new SimpleGrantedAuthority(role.getDescription()));
		}

		if (authorities.isEmpty()) {
			logger.error("Error en el Login: Usuario '" + username + "' no tiene roles asignados!");
			throw new UsernameNotFoundException(
					"Error en el Login: usuario '" + username + "' no tiene roles asignados!");
		}
		logger.info("Password: " + usuario.getPassword());

		return new User(usuario.getUsername(), usuario.getPassword(), authorities);
	}

}
