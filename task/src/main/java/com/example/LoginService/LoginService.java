package com.example.LoginService;

import java.util.List;
import java.util.Optional;

import com.example.Entity.Login;

public interface LoginService {
	public Login saveUser(Login l);
	public void deleteUser(int Id);
	public Login updateUser(Login l,int Id);
	public List<Login> getAllUsers();
	public Login getUserById(int Id);
    Optional <Login> getUserByEmailID(String EmailID);
}
