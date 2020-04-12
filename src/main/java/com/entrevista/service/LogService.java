package com.entrevista.service;

import com.entrevista.model.Log;
import com.entrevista.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void saveLog(String texto) {
        Log log = new Log(texto);

        try {
            logRepository.save(log);
        } catch (Exception ex) {
            System.out.println("Erro ao salvar log: " + ex);
        }
    }

    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }
}
