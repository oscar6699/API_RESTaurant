package com.Restaurant.API.controller;

import com.Restaurant.API.entity.Login;
import com.Restaurant.API.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/lista")
    public ResponseEntity<List<Login>>lista(){
        List<Login>lista=loginService.lista();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<Login> obtenerLogin(@PathVariable("id") int id){
        Optional<Login> optionalLogin = this.loginService.BuscarLogin(id);
        if (optionalLogin.isPresent())
            return new ResponseEntity<>(optionalLogin.get(), HttpStatus.OK);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> save(@PathVariable Login login){
        try{
            loginService.saveProcedure(login);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Login Borrado", HttpStatus.CREATED);
    }

    @PostMapping("/nuevo2/{username}/{password}")
    public ResponseEntity<?> save2(@PathVariable("username") String username, @PathVariable("password") String password){
        try{
            Login login = new Login(username,password);
            loginService.saveProcedure(login);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Login Creado", HttpStatus.CREATED);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> borrar(@PathVariable("id") int id){
        loginService.deleteLogin(id);
        return new ResponseEntity<>("Login Borrado", HttpStatus.OK);
    }
}
