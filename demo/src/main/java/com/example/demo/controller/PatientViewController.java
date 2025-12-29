package com.example.demo.controller;

import com.example.demo.model.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientViewController {

    // In-memory storage
    private List<Patient> patients = new ArrayList<>();

    // Load HTML page
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("patients", patients);
        return "patients"; // loads patients.html
    }

    // Add Patient
    @PostMapping("/add")
    public String addPatient(@ModelAttribute Patient patient) {
        patients.add(patient);
        return "redirect:/";
    }

    // Update Patient
    @PostMapping("/update")
    public String updatePatient(@ModelAttribute Patient patient) {
        for (Patient p : patients) {
            if (p.getId() == patient.getId()) {
                p.setName(patient.getName());
                p.setDisease(patient.getDisease());
            }
        }
        return "redirect:/";
    }

    // Delete Patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patients.removeIf(p -> p.getId() == id);
        return "redirect:/";
    }
}
