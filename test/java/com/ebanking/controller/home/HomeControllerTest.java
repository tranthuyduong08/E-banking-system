package com.ebanking.controller.home;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

class HomeControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    void homePage()  throws Exception{
        mvc.perform(get("/home"))
            .andExpect(status().isOk())
            .andExpect(view().name("/home/home"))
            .andExpect(model().attribute("allMessages", hasSize(2)))
            .andExpect(model().attribute("allMessages", hasSize(allOf(
                    hasProperty("content", is("abc")),
                    hasProperty("sender", is("member"))
            ))))
            .andExpect(model().attribute("allMessages", hasItem(allOf(
                    hasProperty("content", is("abc")),
                    hasProperty("sender", is("member"))))));
    }
}