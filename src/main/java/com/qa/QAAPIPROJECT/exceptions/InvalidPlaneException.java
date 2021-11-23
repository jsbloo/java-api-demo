package com.qa.QAAPIPROJECT.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Invalid object syntax provided")
public class InvalidPlaneException extends IllegalArgumentException{
}
