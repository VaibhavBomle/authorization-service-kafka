package com.amdocs.media.assignement.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.media.assignement.model.UserCredDTO;
import com.amdocs.media.assignement.model.UserProfileDTO;
import com.amdocs.media.assignement.service.UserProfileService;
import com.amdocs.media.assignement.userprofileclient.UserProfileClient;

@Controller
public class UserController {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Autowired
	private UserProfileClient userProfileClient;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @Valid UserCredDTO userCredDTO,BindingResult result) {
		System.out.println("userCredDTO "+userCredDTO);
		
		// code to authenticate username and password
		if(userCredDTO.getId() != null) {
			return "redirect:/get-user?id="+userCredDTO.getId();
		}
		return "redirect:/get-user";
	}
	
	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String createUser(ModelMap model, @Valid UserProfileDTO userProfileDTO ,BindingResult result) {
		System.out.println("userProfileDTO "+userProfileDTO);
		userProfileService.createUserProfile(userProfileDTO);
		return "viewPage";
	}
	
	@RequestMapping(value = "/delete-user", method = RequestMethod.DELETE)
	public String deleteUser(@RequestParam Long id) {
		userProfileService.deleteUserProfileById(id);
		return "redirect:/get-user";
	}
	
	@RequestMapping(value = "/update-user", method = RequestMethod.PUT)
	public String UpdateUser(ModelMap model,@RequestParam Long id) {
		//get user data
		//UserProfileDTO userProfileDTO = userProfileClient.getUserProfileByUserCredId(id, null);
		model.addAttribute("userProfile", userProfileClient.getUserProfileByUserCredId(id, null));
		System.out.println("update user");
		return "userProfile";
		
	}
	
	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	public String getUser(ModelMap model,@RequestParam(required = false)  Long id) {
		// need to get data from db
		UserProfileDTO userProfileDTO = new UserProfileDTO();
		userProfileDTO.setUserCredId(id);
		System.out.println("userProfileDTO " + userProfileDTO);
		model.addAttribute("userProfile", userProfileDTO);
		if(id != null) {
			return "viewPage";
		}
		return "userProfile";
	}
	
	

}
