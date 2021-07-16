package com.example.management;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.example.management.controllers.LoginController;
import com.example.management.controllers.TaskController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

	
	@Autowired
	private MockMvc mockMvc;

	    @Test
	    public void shouldReturnDefaultMessage() throws Exception {
	    	

//	    	.perform(get("http://localhost:8080/list")
//	    		    .contentType(MediaType.TEXT_HTML)
//	    		    .with(SecurityMockMvcRequestPostProcessors.csrf())
//	    		    .with(user(userDetails));
	    }

}
