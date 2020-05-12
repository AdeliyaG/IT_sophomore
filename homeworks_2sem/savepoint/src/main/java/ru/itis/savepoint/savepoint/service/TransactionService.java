package ru.itis.savepoint.savepoint.service;

import org.springframework.stereotype.Service;
import ru.itis.savepoint.savepoint.aspects.SavePointAnnotation;

@Service
public class TransactionService {

    @SavePointAnnotation
    public void save(Integer integer){
        System.out.println("I'm saving" + integer);
    }

    @SavePointAnnotation
    public void delete(){
        System.out.println("I'm deleting");
    }
}
