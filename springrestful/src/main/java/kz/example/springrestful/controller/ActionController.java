package kz.example.springrestful.controller;

import kz.example.springrestful.entity.Action;
import kz.example.springrestful.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actions")
public class ActionController {

    @Autowired
    private ActionService actionService;

    @PostMapping
    public ResponseEntity addAction(@RequestBody Action action){
        return new ResponseEntity(actionService.addAction(action), HttpStatus.OK);
    }
}
