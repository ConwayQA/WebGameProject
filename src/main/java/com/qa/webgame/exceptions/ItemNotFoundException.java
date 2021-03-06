package com.qa.webgame.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The item does not exist")
public class ItemNotFoundException extends EntityNotFoundException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
}