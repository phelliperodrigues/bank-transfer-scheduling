package com.bank.scheduler.controller;

import com.bank.scheduler.service.TransferService;
import com.bank.scheduler.service.TransferService;
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

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(controllers = TransferController.class)
@AutoConfigureMockMvc
public class TransferControllerTest {
    private static final String ACCOUNT_API = "/api/transfer";

    @Autowired
    MockMvc mvc;

    @MockBean
    TransferService service;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("[CREATE] - Should success scheduler a transfer")
    public void create() throws Exception {
        Assertions.fail();
    }


    @Test
    @DisplayName("[CREATE] - Should show exception when scheduler a invalid transfer")
    public void createInvalid() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that value money required")
    public void createWithoutValue() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should show message exceptions that date transfer required")
    public void createWithoutDate() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should return rate for same day transfer")
    public void calculateRateSameDay() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should multiply the transfer rate up to 10 days, $12 a day")
    public void calculateRateUpTo10Day() throws Exception {
        Assertions.fail();
    }



    @Test
    @DisplayName("[CREATE] - Should returned Total rate if transfer is between 10 and 20 days, 8% rate")
    public void calculateRateBetween10And20Day() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should returned Total rate if transfer is between 20 and 30 days, 6% rate")
    public void calculateRateBetween20And30Day() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should returned Total rate if transfer is between 30 and 40 days, 4% rate")
    public void calculateRateBetween20And40Day() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should return rate for scheduler greater than 40 days and value greater $100.000, 2% rate")
    public void calculateRateGreater40DayAndGreater$100000() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[CREATE] - Should return rate for same day transfer")
    public void showExceptionNotFoundRate() throws Exception {
        Assertions.fail();
    }

    @Test
    @DisplayName("[READ] - Should show all Transfer Scheduled")
    public void show() throws Exception {
        Assertions.fail();
    }

    private Optional createValidTransfer() {
        return null;
    }
}
