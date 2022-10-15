package com.psicodidact.agendamiento.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.psicodidact.agendamiento.models.entity.Usuario;
import com.psicodidact.agendamiento.services.UsuarioService;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
   // @Autowired
  //  private BCryptPasswordEncoder bCryptPasswordEncoder;




    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return usuarioService.obtenerUsuario(username);
    }



}
