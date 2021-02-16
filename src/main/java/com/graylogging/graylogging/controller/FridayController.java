package com.graylogging.graylogging.controller;

import com.graylogging.graylogging.log.KfMarker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FridayController {
    @RequestMapping(value = "/friday-list",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public List<String> getFridayList() {
        log.info(KfMarker.REQUEST, "Information log");
        log.warn(KfMarker.REQUEST, "Warning log");
        log.error(KfMarker.REQUEST, "Error log", new RuntimeException());

        return List.of("BEER", "WINE", "JUICE");
    }
}
