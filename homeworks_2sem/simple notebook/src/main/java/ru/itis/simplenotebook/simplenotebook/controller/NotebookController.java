package ru.itis.simplenotebook.simplenotebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.simplenotebook.simplenotebook.dto.NoteDto;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NotebookController {

    private List<NoteDto> notebook = new ArrayList<>();

    @GetMapping("/addNote")
    private String getAddForm() {
        return "form";
    }

    @PostMapping("/addNote")
    private String addNote(@ModelAttribute NoteDto note) {
        notebook.add(note);
        return getAddForm();
    }

    @GetMapping("/notebook/{var}")
    private String getNotebook(@PathVariable Integer var, Model model) {

        model.addAttribute("notes", getPagination(var, notebook));
        model.addAttribute("pageCount", Math.ceil(1.0 * notebook.size() / 3));
        return "notes";
    }

    @PostMapping("/notebook")
    private String search(@RequestParam String substring, Model model) {
        List<NoteDto> searchList = new ArrayList<>();

        for (NoteDto noteDto : notebook) {
            if (noteDto.getName().contains(substring)) {
                searchList.add(noteDto);
            }
        }
        model.addAttribute("notes", searchList);
        model.addAttribute("pageCount", 0);
        return "notes";
    }

    private List<NoteDto> getPagination(Integer var, List<NoteDto> pagination) {
        if (var * 3 <= pagination.size()) {
            return pagination.subList(var * 3 - 3, var * 3);
        } else {
            return pagination.subList(var * 3 - 3, pagination.size());
        }
    }
}
