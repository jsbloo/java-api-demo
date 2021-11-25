package com.qa.QAAPIPROJECT.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "A airport with that code does not exist")
public class AirportNotFoundException extends EntityNotFoundException {


}