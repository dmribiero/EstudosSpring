package br.com.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.services.UserServices;

@Controller
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		model.addAttribute("userList", this.userServices.findAll());
		
		return "user";
	}
}
