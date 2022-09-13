package com.Restaurant.API.service;

import com.Restaurant.API.entity.Login;
import com.Restaurant.API.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public List<Login>lista(){
        return loginRepository.findAll();
    }

    public Optional<Login> BuscarLogin(int id){return loginRepository.findById(id);}

    public void saveProcedure(Login login){
        try{
            loginRepository.saveProcedure(login.getUSER_NAME(),login.getUSER_PASS());
        }catch (Exception e){
            throw e;
        }
    }

    public void deleteLogin(int id){
        loginRepository.deleteLogin(id);
    }
}
