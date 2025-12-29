package com.example.demo.controller;

import com.example.demo.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private List<Patient> patients = new ArrayList<>();

    // POST - Add Patient
    @PostMapping
    public String addPatient(@RequestBody Patient patient) {
        patients.add(patient);
        return "Patient added successfully";
    }

    // GET - Get All Patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patients;
    }

    // PUT - Update Patient
    @PutMapping("/{id}")
    public String updatePatient(@PathVariable int id,
                                @RequestBody Patient updatedPatient) {

        for (Patient p : patients) {
            if (p.getId() == id) {
                p.setName(updatedPatient.getName());
                p.setDisease(updatedPatient.getDisease());
                return "Patient updated successfully";
            }
        }
        return "Patient not found";
    }

    // DELETE - Delete Patient
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {
        patients.removeIf(p -> p.getId() == id);
        return "Patient deleted successfully";
    }
}

