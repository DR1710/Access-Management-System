package com.example.registrationlogindemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

//@ExtendWith(SpringExtension.class) // for Junit 5+ which replaces RunWith
@AutoConfigureMockMvc
//@WebMvcTest(AuthController.class)
@SpringBootTest
public class AuthControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void isLoginUrlExist() throws Exception {
		this.mockMvc.perform(get("/login")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void isRegisterUrlExist() throws Exception {
		this.mockMvc.perform(get("/register")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void isForgotPasswordURLExist() throws Exception {
		this.mockMvc.perform(get("/forgot-password")).andDo(print()).andExpect(status().isOk());
	}

}
