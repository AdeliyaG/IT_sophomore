package ru.itis.wschat.voice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoiceController {

    @GetMapping("/")
    private String getPage() {
        return "voiceReader.html";
    }
}
