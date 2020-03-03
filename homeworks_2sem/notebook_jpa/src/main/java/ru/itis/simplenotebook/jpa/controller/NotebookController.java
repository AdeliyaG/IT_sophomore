package ru.itis.simplenotebook.jpa.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.simplenotebook.jpa.entity.NoteEntity;
import ru.itis.simplenotebook.jpa.jpa.NoteRepository;

@Controller
public class NotebookController {

    private final NoteRepository noteRepository;

    public NotebookController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/addNote")
    private String getAddForm() {
        return "form";
    }

    @PostMapping("/addNote")
    private String addNote(@ModelAttribute NoteEntity note) {
        noteRepository.save(note);
        return getAddForm();
    }

    @GetMapping("/notebook")
    private String getNotebook(@PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<NoteEntity> page = noteRepository.findAll(pageable);
        model.addAttribute("notes", page);
        model.addAttribute("page", page);
        return "notes";
    }

    @PostMapping("/notebook")
    private String search(@PageableDefault(size = 3) Pageable pageable, @RequestParam String substring, Model model) {
        Page<NoteEntity> page = noteRepository.findAllByNameContains(substring, pageable);
        model.addAttribute("notes", page);
        model.addAttribute("page", page);
        return "notes";
    }
}
