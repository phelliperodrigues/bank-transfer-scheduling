package com.bank.scheduler.controller;

import com.bank.scheduler.controller.dto.AccountDTO;
import com.bank.scheduler.model.Account;
import com.bank.scheduler.model.enums.Bank;
import com.bank.scheduler.service.AccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerTest {

    private static final String ACCOUNT_API = "/api/account";

    @Autowired
    MockMvc mvc;

    @MockBean
    AccountService service;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("[CREATE] - Should success create a account")
    public void createValid() throws Exception {
        var dto = createValidAccountDTO();

        var saved = createAccountEntity();

        given(service.save(any(Account.class))).willReturn(saved);

        var json = writeValueAsString(dto);

        var request =
                post(ACCOUNT_API)
                        .contentType(APPLICATION_JSON)
                        .accept(APPLICATION_JSON)
                        .content(json);

        mvc
                .perform(request)
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").value(10L))
                .andExpect(jsonPath("balance").value(dto.getBalance()))
                .andExpect(jsonPath("digit").value(dto.getDigit()))
                .andExpect(jsonPath("number").value(dto.getNumber()))
                .andExpect(jsonPath("agency").value(dto.getAgency()))
                .andExpect(jsonPath("bank").isNotEmpty())
                .andExpect(jsonPath("agency").value(dto.getBank().name()))


        ;
    }

    @Test
    @DisplayName("[CREATE] - Should show exception when create a invalid account")
    public void showExceptionWhenCreateInvalid() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that agence required")
    public void createInvalidAccountWithoutAgenceTest() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that number required")
    public void createInvalidAccountWithoutNumberTest() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that balance required")
    public void createInvalidAccountWithoutBalanceTest() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that bank required")
    public void createInvalidAccountWithoutBankTest() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[READ] - Should return all Account")
    public void showAll() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[READ] - Should return Account by ID")
    public void findById() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[READ] - Should return 404 Not Found find by ID")
    public void findByIdNotFound() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[READ] - Should filter a account with parameters")
    public void findAccount() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[UPDATE] - Should update Account by ID")
    public void update() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[UPDATE] - Should return 404 Not Found update by ID")
    public void updateNotFound() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[DELETE] - Should delete Account by ID")
    public void delete() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[DELETE] - Should return exception delete by ID nonexistent")
    public void deleteNotFound() throws Exception {
        Assertions.fail();
    }

    private AccountDTO createValidAccountDTO() {
        return AccountDTO.builder()
                .bank(Bank.NU_BANK)
                .agency(1)
                .number(123456)
                .digit(2)
                .balance(new BigDecimal("100.00"))
                .build();
    }


    private Account createAccountEntity() {
        return Account.builder()
                .id(10L)
                .bank(Bank.NU_BANK)
                .agency(1)
                .number(123456)
                .digit(2)
                .balance(new BigDecimal("100.00"))
                .build();

    }

    private String writeValueAsString(AccountDTO dto) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(dto);
    }
}
