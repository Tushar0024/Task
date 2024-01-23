package com.example.LoginService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Login;
import com.example.Repositories.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepo repo;
	
	public Login saveUser(Login l) {
		return repo.save(l);
	}
	public void deleteUser(int Id) {
		Login login = repo.findById(Id).get();
		if(login != null) {
			repo.delete(login);
		}
	}
	
	
	public Login updateUser(Login l,int Id) {
		Login login=  repo.findById(Id).get();
		login.setId(l.getId());
		login.setUsername(l.getUsername());
		login.setPassword(l.getPassword());
		login.setEmailID(l.getUsername());
		return repo.save(login);
	}
	public List<Login> getAllUsers(){
		return repo.findAll();
	}
	public Login getUserById(int Id) {
		return  repo.findById(Id).get();
	}
	@Override
	public Optional <Login> getUserByEmailID(String EmailID) {
	return repo.getUserByEmailID(EmailID);
	}
	
}
