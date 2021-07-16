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
import com.example.management.details.AccountDetails;
import com.example.management.Entity.TaskEntity;
import com.example.management.domains.model.Task;
import com.example.management.form.AddForm;
import com.example.management.form.UpdateForm;
import com.example.management.service.TaskService;
import com.example.management.service.TaskService2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@EntityScan("com.example.management.Entity")
@Controller
public class TaskController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskService2 taskService2;

	@GetMapping("/list")
	public String index(@AuthenticationPrincipal AccountDetails accountDetails, Model model,
			@PageableDefault(page = 0) Pageable pageable) {
		logger.fatal("ログイン成功しました。");
		Page<TaskEntity> pageList = taskService.findList(accountDetails.getUsername(), pageable);
		List<TaskEntity> taskList = pageList.getContent();
		model.addAttribute("pages", pageList);
		model.addAttribute("Tasks", taskList);
		return "list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("addForm", new AddForm());
		return "add";
	}

	@PostMapping("/add")
	public String add(@AuthenticationPrincipal AccountDetails accountDetails,
			@Validated @ModelAttribute AddForm addForm, BindingResult result, Model model) {
		taskService2.addTest(accountDetails, addForm);
		return "redirect:/list";
	}

	@PostMapping("/done")
	public String done(String id) {
		taskService.doneTask(id);
		return "redirect:/list";
	}

	@PostMapping("/delete")
	public String delete(String id) {
		taskService.deleteTask(id);
		return "redirect:/list";
	}

	@PostMapping("/detail")
	public String detail(Model model, String id) {
		Task Task = taskService.findOne(id);
		model.addAttribute("task", Task);
		model.addAttribute("updateForm", new UpdateForm());
		return "detail";
	}

	@PostMapping("/update")
	public String update(@Validated @ModelAttribute UpdateForm updateForm, BindingResult result, Model models) {
		Task Task = taskService.findOne(updateForm.getId());
		if (Task.getVersion() != updateForm.getVersion()) {
			return "error";
		}
		taskService.updateTask(updateForm);

		return "redirect:/list";
	}
}
