package com.example.management;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.management.controllers.LoginController;
import com.example.management.details.AccountDetails;
import com.example.management.service.AccountServce;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LoginController.class)
@AutoConfigureMockMvc
public class LoginControllerTest {
	 @Autowired
	    private WebApplicationContext context;

	    private MockMvc mvc;

	    @Before(value = "")
	    public void setup() {
	        mvc = MockMvcBuilders
	                .webAppContextSetup(context)
	                .apply(springSecurity()) 
	                .build();
	    }
//	@Autowired
//    private MockMvc mockMvc;
//	
//	@Autowired
//	private AccountServce accountServce;
//
//	 @Test
//	 @WithAnonymousUser
//    public void shouldReturnDefaultMessage() throws Exception {
//    	AccountDetails accountDetails = (AccountDetails) accountServce.loadUserByUsername("test@crossware.co.jp");
//
//        //@formatter:off
//        mockMvc.perform(post("http://localhost:8080/login")
//            .contentType(MediaType.TEXT_HTML)
//            .with(SecurityMockMvcRequestPostProcessors.csrf())
//            .with(user(accountDetails))
//            .param("username", "test@crossware.co.jp")
//            .param("password", "password")
//        )
//        .andExpect(SecurityMockMvcResultMatchers.authenticated())
//        .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
//        .andExpect(MockMvcResultMatchers.redirectedUrl("/list"))
//        .andReturn();
//    }
}