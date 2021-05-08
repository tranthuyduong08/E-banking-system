package com.ebanking.controller.customer;

import com.ebanking.entity.Role;
import com.ebanking.entity.User;
import com.ebanking.repository.UserRepository;
import com.ebanking.service.UserService;
import com.ebanking.service.impl.CustomUserDetailsService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@NoArgsConstructor
class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;
    @InjectMocks
    private UserDetailsService service = new CustomUserDetailsService();
    @MockBean
    private UserService userService;
    @Mock
    private UserRepository repository;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new CustomUserDetailsService();
    }

    @Test
    void customerHomePage() throws Exception {
        mvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/home"))
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
    void customerProfile() throws Exception{
        mvc.perform(get("/customer/profile"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/profile/profile"))
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
    void customerEditProfile() throws Exception {
        mvc.perform(get("/customer/profile/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/profile/edit-profile"))
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
    void customerViewCurrentAccount() throws Exception{
        mvc.perform(get("/customer/current-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/account/current-account"))
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
    void customerViewSavingAccount() throws Exception{
        mvc.perform(get("/customer/saving-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/account/saving-account-list"))
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
    void customerCreateSavingAccount() throws Exception {
        mvc.perform(get("/customer/saving-account/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/account/create-saving-account"))
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
    void customerViewLoanAccount() throws Exception{
        mvc.perform(get("/customer/loan-account"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/account/loan-account-list"))
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
    void customerCreateLoanAccount() throws Exception{
        mvc.perform(get("/customer/loan-account/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/account/loan-account-create"))
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
    void customerViewTransaction() throws Exception {
        mvc.perform(get("/customer/transaction"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/transaction-list"))
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
    void customerViewDeposit() throws Exception{
        mvc.perform(get("/customer/transaction/deposit/history"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/deposit-list"))
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
    void customerCreateDeposit() throws Exception{
        mvc.perform(get("/customer/transaction/deposit"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/create-deposit"))
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
    void customerViewWithdraw() throws Exception{
        mvc.perform(get("/customer/transaction/withdraw/history"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/withdraw-list"))
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
    void customerCreateWithdraw() throws Exception {
        mvc.perform(get("/customer/transaction/withdraw"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/create-withdraw"))
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
    void customerViewTransfer() throws Exception {
        mvc.perform(get("/customer"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/home"))
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
    void customerTransferSameBank() throws Exception{
        mvc.perform(get("/customer/transaction/transfer/same-bank"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/transfer-same-bank"))
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
    void customerTransferOtherBank() throws Exception{
        mvc.perform(get("/customer/transaction/transfer/other-bank"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/transaction/transfer-other-bank"))
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
    void customerViewAppointment() throws Exception{
        mvc.perform(get("/customer/appointment"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/appointment/appointment-list"))
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
    void customerCreateAppointment() throws Exception{
        mvc.perform(get("/customer/appointment/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/appointment/create-appointment"))
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
    void customerDeleteAppointment() throws Exception{
        mvc.perform(get("/customer/appointment/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/appointment/delete-appointment"))
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