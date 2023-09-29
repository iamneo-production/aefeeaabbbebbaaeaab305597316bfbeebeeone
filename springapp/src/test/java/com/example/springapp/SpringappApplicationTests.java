package com.example.springapp;


import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.io.File;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = SpringappApplication.class)
@AutoConfigureMockMvc
class SpringappApplicationTests {

	@Autowired
	private  MockMvc mockMvc ;

	@Test
	void AddStudent() throws Exception{	
	

		String st = "{\"studentId\": 1000,\"studentName\": \"Demo\", \"studentClass\": \"tenth\",\"studentEmail\": \"action\",\"studentMobile\":\"20\"}";
		 mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
		 				.contentType(MediaType.APPLICATION_JSON)
		 				.content(st)
		 				.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(jsonPath("$").value(true))
						.andReturn();
	}


	

    @Test
    public void testApiControllerClassExists() {
        checkClassExists("com.example.springapp.controller.ApiController");
    }

    @Test
    public void testStudentRepoClassExists() {
        checkClassExists("com.example.springapp.repository.StudentRepo");
    }

    @Test
    public void testApiServiceClassExists() {
        checkClassExists("com.example.springapp.service.ApiService");
    }

    @Test
    public void testStudentModelClassExists() {
        checkClassExists("com.example.springapp.model.Student");
    }

     private void checkClassExists(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist.");
        }
    }


}
