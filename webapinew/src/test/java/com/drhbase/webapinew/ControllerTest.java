package com.drhbase.webapinew;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.drhbase.webapinew.Controller.ClientController;
import com.drhbase.webapinew.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ClientController.class)
public class ControllerTest {

	@Autowired
    MockMvc mockMvc;
	@MockBean
    ClientService clientService;


	@Test
	public void whencallingget_wereceive_goodstatus() throws Exception{
		mockMvc.perform(get("/Clients")).andExpect(status().isOk());
	}

	@Test
	public void posttest() throws Exception{
		mockMvc.perform(post("/Clients").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
}
