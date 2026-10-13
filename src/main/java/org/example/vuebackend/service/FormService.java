package org.example.vuebackend.service;

import org.example.vuebackend.mapper.FormMapper;
import org.example.vuebackend.model.FormRequest;
import org.example.vuebackend.model.FormResponse;
import org.example.vuebackend.repository.FormRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.rmi.AlreadyBoundException;
import java.util.List;

@Service
public class FormService {

    FormRepository repository;

    public FormService(FormRepository repo){
        repository = repo;
    }

    public FormResponse addForm(FormRequest request){
        if(request.agreement() == false){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(repository.existsByEmail(request.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        return FormMapper.toResponse(repository.save(FormMapper.toEntity(request)));
    }

    public List<FormResponse> getAllForms(){
        return repository.findAll().stream().map(FormMapper::toResponse).toList();
    }

}
