package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotebookController {

    @GetMapping("/addNote")
    private String GetNoteBook() {
        return "form";
    }

    @PostMapping("/notebook")
    private String NoteBook() {

        return "redirect:notebook";
    }

//    @PostMapping
//    private String add() {
//
//    }
}
