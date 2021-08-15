package com.hh.myproject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author hejiayuan
 * @date 2020-11-20 9:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MockMvctest {
    //模拟mvc对象
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void before(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void test() throws Exception{
        for (int i = 0; i < 10; i++) {

            MvcResult mvcResult = mockMvc.perform(post("/a/getInfo").param("id","1"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        }
    }

}
