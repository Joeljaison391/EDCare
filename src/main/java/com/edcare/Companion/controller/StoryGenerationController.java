package com.edcare.Companion.controller;

import com.edcare.Companion.service.StoryGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/story")
public class StoryGenerationController {

    @Autowired
    private StoryGenerationService storyGenerationService;

    @GetMapping("/generate/{analysisResultId}")
    public String generateStory(@PathVariable String analysisResultId) {
        try {
            System.out.println("Generating story for analysis result: " + analysisResultId);
            return storyGenerationService.generateStory(analysisResultId);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
            return "Error generating story: " + e.getMessage();
        }
    }
}
