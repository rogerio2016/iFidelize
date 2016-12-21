package com.ifidelize.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ifidelize.model.TbGrupo_Usuario;
import com.ifidelize.model.TbUsuario;
import com.ifidelize.repository.TbUsuarioRepository;
import com.ifidelize.util.cdi.CDIServiceLocator;

public class AppUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		TbUsuarioRepository usuarios = CDIServiceLocator.getBean(TbUsuarioRepository.class);
		TbUsuario usuario = usuarios.porEmail(email);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(TbUsuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (TbGrupo_Usuario grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getDes_Nome().toUpperCase()));
		}
		
		return authorities;
	}

}
