package ru.itis.savepoint.savepoint.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.itis.savepoint.savepoint.service.TransactionService;

@Component
public class RunCommand implements CommandLineRunner {

    @Autowired
    private TransactionService transactionService;

    @Override
    public void run(String... args) {
        transactionService.save(4);
    }
}
