package com.bank.scheduler.controller;

import com.bank.scheduler.controller.dto.AccountDTO;
import com.bank.scheduler.model.Account;
import com.bank.scheduler.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private final ModelMapper mapper;
    private final AccountService service;

    public AccountController(ModelMapper mapper, AccountService service) {
        this.mapper = mapper;
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO create(@RequestBody AccountDTO dto){
        Account entity = mapper.map(dto, Account.class);
        entity = service.save(entity);

        return mapper.map(entity, AccountDTO.class);

    }

}
