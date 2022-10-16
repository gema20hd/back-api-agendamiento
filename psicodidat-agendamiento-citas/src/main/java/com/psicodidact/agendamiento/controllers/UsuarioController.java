package com.psicodidact.agendamiento.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.services.IUsuarioService;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
/*
    @Autowired
    private IUsuarioService usuarioService;
  */  
  // @Autowired
  // private BCryptPasswordEncoder bCryptPasswordEncoder;



/*
    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }
    */


}
