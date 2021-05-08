package com.ebanking.controller.admin;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.security.test.context.support.WithMockUser;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@Slf4j
@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
@WithMockUser
@NoArgsConstructor
public class AdminControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void adminHomePage() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(view().name("/admin/home"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminProfile() throws  Exception{
        mvc.perform(get("/admin/profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/profile/edit-profile"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminEditProfile() throws  Exception{
        mvc.perform(get("admin/profile/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/profile/profile"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminViewCustomer() throws  Exception{
        mvc.perform(get("/admin/customer"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/customer"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminCreateCustomer() throws Exception{
        mvc.perform(get("/admin/customer/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/customer"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }



    @Test
    public void adminEditCustomer() throws Exception{
        mvc.perform(get("/admin/customer/edit/{id}"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/customer"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }


    @Test
    public void adminDeleteCustomer() throws Exception{
        mvc.perform(get("/admin/customer/delete/{id}"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/customer"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminViewInterestRate() throws Exception{
        mvc.perform(get("/admin/interest-rate"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/interest-rate-list"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminViewCurrentAccount() throws Exception {
        mvc.perform(get("/admin/current-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/account-list"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminViewSavingAccount() throws Exception{
        mvc.perform(get("/admin/saving-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/account-list"))
                .andExpect(model().attribute("allMessages", hasSize(2)))
                .andExpect(model().attribute("allMessages", hasSize(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))
                ))))
                .andExpect(model().attribute("allMessages", hasItem(allOf(
                        hasProperty("content", is("abc")),
                        hasProperty("sender", is("member"))))));
    }

    @Test
    public void adminViewLoanAccount() throws Exception{
        mvc.perform(get("/admin/loan-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("admin/account-list"))
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