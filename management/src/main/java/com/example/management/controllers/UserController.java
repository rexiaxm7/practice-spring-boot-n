package com.example.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.management.Entity.UserEntity;
import com.example.management.details.AccountDetails;
import com.example.management.domains.model.User;
import com.example.management.form.UserAddForm;
import com.example.management.form.UserUpdateForm;
import com.example.management.service.UserService;

@EntityScan("com.example.management.Entity")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user_list")
	public String index(@AuthenticationPrincipal AccountDetails accountDetails, Model model,
			@PageableDefault(page = 0) Pageable pageable) {
		Page<UserEntity> pageList = userService.findList(pageable);
		List<UserEntity> userList = pageList.getContent();
		model.addAttribute("pages", pageList);
		model.addAttribute("Users", userList);
		return "user_list";
	}

	@GetMapping("/user_add")
	public String showAddForm(Model model) {
		model.addAttribute("userAddForm", new UserAddForm());
		return "user_add";
	}

	@PostMapping("/user_add")
	public String add(@Validated @ModelAttribute UserAddForm userAddForm, BindingResult result) {

		if (result.hasErrors()) {
			return "user_add";
		}

		userService.addTest(userAddForm);
		return "redirect:/list";
	}

	@PostMapping("/user_detail")
	public String detail(Model model, String id) {
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		model.addAttribute("updateForm", new UserUpdateForm());
		return "user_detail";
	}

	@PostMapping("/user_update")
	public String update(@Validated @ModelAttribute UserUpdateForm updateForm, BindingResult result, Model models) {
		userService.updateUser(updateForm);

		return "redirect:/list";
	}

}
