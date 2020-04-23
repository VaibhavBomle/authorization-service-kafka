package com.amdocs.media.assignement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amdocs.media.assignement.dto.UserCredDTO;

@Controller
public class HomeController {

	@RequestMapping(value = "/assignment", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		model.addAttribute("userCred", new UserCredDTO());
		System.out.println("index page");
		return "home";
	}
}
