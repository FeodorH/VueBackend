package org.example.vuebackend.controller;

import org.example.vuebackend.model.FormRequest;
import org.example.vuebackend.model.FormResponse;
import org.example.vuebackend.service.FormService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/testVueApi/forms")
public class FormController {

    private final FormService service;

    public FormController(FormService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FormRequest form) {
        try {
            FormResponse saved = service.addForm(form);
            return ResponseEntity.ok(saved);
        }catch (ResponseStatusException e){
            return ResponseEntity.status(e.getStatusCode()).build();
        }
    }

    @GetMapping
    public List<FormResponse> getAll() {
        return service.getAllForms();
    }

}
