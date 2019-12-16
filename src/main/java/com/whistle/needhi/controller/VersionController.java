package com.whistle.needhi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author thanga
 */

@RestController
public class VersionController {

    private static final String URL_PREFIX = "/v1/version";

    @GetMapping(value = URL_PREFIX)
    @ResponseStatus(HttpStatus.OK)
    public String getVersion() {
        return "1.0";
    }
}
