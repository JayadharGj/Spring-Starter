package dev.jayadhar.contentcalender.controller;

import dev.jayadhar.contentcalender.model.Content;
import dev.jayadhar.contentcalender.repository.ContentCollectionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    @Autowired
    public ContentController(ContentCollectionRepository contentCollectionRepository) {
        this.repository = contentCollectionRepository;
    }

    // make a request and find all the content in the system
    // return the content as a list
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
        if(repository.existsById(id)) {
            repository.save(content);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Content not found");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }else{
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Content not found");
        }
    }

}
