package com.psicodidact.agendamiento.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.psicodidact.agendamiento.entidades.autoridades.Authority;

import lombok.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Data
@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {

	//private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;

	@Column(name = "nombre_usuario")
	private String username;

	@Column(name = "clave_usuario")
	private String password;

	
    private boolean enabled = true;
	
	//@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinTable(name="rol", joinColumns= @JoinColumn(name="id_rol"),
	//inverseJoinColumns=@JoinColumn(name="id_profesional"),
	///uniqueConstraints= {@UniqueConstraint(columnNames= {"id_rol", "id_profesional"})})
	//private List<Rol> roles;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_rol")
	@JsonIgnore
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Rol rol;
	
	
	@ManyToOne
	@JoinColumn(name="id_profesional")
	@JsonIgnore
//	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Profesional profesional;
	

    
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    //	System.out.println(rol.getDescripcionRol()+"LA DESCRIPCION QUE TRAE");
        Set<Authority> autoridades = new HashSet<>();
    //   this.roles.forEach(usuarioRol -> {
    	   System.out.println("ME TRAE");
        System.out.println(rol.getDescripcionRol());
            autoridades.add(new Authority(rol.getDescripcionRol()));
       // });
        return autoridades;
    }


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public Long getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	public Profesional getProfesional() {
		return profesional;
	}


	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}



	
	
	
	

}