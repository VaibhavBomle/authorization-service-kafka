package com.amdocs.media.assignement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amdocs.media.assignement.dto.UserCredDTO;
import com.amdocs.media.assignement.dto.UserProfileDTO;
import com.amdocs.media.assignement.model.UserCred;
import com.amdocs.media.assignement.service.UserCredService;
import com.amdocs.media.assignement.service.UserProfileService;
import com.amdocs.media.assignement.userprofileclient.UserProfileClient;


/**
 * 
 * User Controller
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private UserCredService userCredService;

	@Autowired
	private UserProfileClient userProfileClient;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(ModelMap model, @Valid UserCredDTO userCredDTO) {
		UserCred userCred = userCredService.getUserCredByUserNameAndpassword(userCredDTO.getUsername(),
				userCredDTO.getPassword());
		if (userCred != null) {
			if (userCred.getId() != null) {
				return "redirect:/get-user?id=" + userCred.getId();
			}
		}
		model.addAttribute("userCred", new UserCredDTO());
		model.addAttribute("error", "Invalid username and password");
		return "home";
	}

	@RequestMapping(value = "/create-user", method = RequestMethod.POST)
	public String createUser(ModelMap model, @Valid UserProfileDTO userProfileDTO) {
		UserProfileDTO userProfile = null;
		if (userProfileDTO.getId() != null) {
			userProfile = userProfileService.updateUserProfile(userProfileDTO);
			model.addAttribute("userCred", new UserCredDTO());
			model.addAttribute("msg", "Profile Successfully Updated...");
			return "home";
		}
		userProfile = userProfileService.createUserProfile(userProfileDTO);
		model.addAttribute("userProfile", userProfile);
		return "viewPage";
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @RequestParam Long id) {
		userProfileService.deleteUserProfileById(id);
		model.addAttribute("userCred", new UserCredDTO());
		model.addAttribute("msg", "Profile Successfully Deleted...");
		return "home";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.GET)
	public String UpdateUser(ModelMap model, @RequestParam Long id) {
		UserProfileDTO userProfileDTO = userProfileClient.getUserProfileByUserProfileIdOrUserCredId(id, null);
		model.addAttribute("userProfile", userProfileDTO);
		return "userProfile";
	}

	@RequestMapping(value = "/get-user", method = RequestMethod.GET)
	public String getUser(ModelMap model, @RequestParam(name = "id", required = false) Long userCredId) {
		UserProfileDTO userProfileDTO = userProfileClient.getUserProfileByUserProfileIdOrUserCredId(null, userCredId);
		if (userProfileDTO != null) {
			model.addAttribute("userProfile", userProfileDTO);
			if (userProfileDTO != null) {
				return "viewPage";
			}
		}
		UserProfileDTO userProfile = new UserProfileDTO();
		userProfile.setUserCredId(userCredId);
		model.addAttribute("userProfile", userProfile);
		return "userProfile";
	}

}
