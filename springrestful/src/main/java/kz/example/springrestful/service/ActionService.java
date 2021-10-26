package kz.example.springrestful.service;

import kz.example.springrestful.entity.Action;
import kz.example.springrestful.repository.ActionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {

    @Autowired
    private ActionRepo actionRepo;

    public Action addAction(Action action){
        action = actionRepo.save(action);
        return action;
    }
}
