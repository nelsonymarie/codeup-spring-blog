package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String showDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        boolean correctGuess = guess == roll;
        model.addAttribute("guess", guess);
        model.addAttribute("roll", roll);
        model.addAttribute("correctGuess", correctGuess);
        return "roll-dice-result";
    }
}


















