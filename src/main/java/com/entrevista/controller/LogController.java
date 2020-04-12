package com.entrevista.controller;

import com.entrevista.model.Log;
import com.entrevista.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("logs")
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Log> getAllClients() {
        return logService.getAllLogs();
    }
}
