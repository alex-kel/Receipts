package ru.dz.receipts.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import ru.dz.receipts.domain.Account
import ru.dz.receipts.dto.AccountCreationDto
import ru.dz.receipts.dto.AccountUpdateDto
import ru.dz.receipts.service.AccountService

import javax.validation.Valid

/**
 * Created by Alex on 21.03.16.
 */
@RestController
class AccountController {

    @Autowired AccountService accountService

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody ResponseEntity register(@RequestBody @Valid AccountCreationDto accountCreationDto) {
        new ResponseEntity(accountService.createNewAccount(accountCreationDto), HttpStatus.CREATED)
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    @ResponseBody ResponseEntity update(@RequestBody @Valid AccountUpdateDto accountUpdateDto) {
        new ResponseEntity(accountService.updateAccount(accountUpdateDto),HttpStatus.ACCEPTED)
    }
}
