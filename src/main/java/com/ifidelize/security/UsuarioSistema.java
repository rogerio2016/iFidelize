package com.ifidelize.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ifidelize.model.TbUsuario;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
	
	private TbUsuario usuario;
	
	public UsuarioSistema(TbUsuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getDes_email(), usuario.getDes_senha(), authorities);
		this.usuario = usuario;
	}

	public TbUsuario getUsuario() {
		return usuario;
	}

}
