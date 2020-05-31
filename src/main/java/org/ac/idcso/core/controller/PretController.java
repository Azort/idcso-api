package org.ac.idcso.core.controller;

import org.ac.idcso.core.exceptions.EntityNotFoundException;
import org.ac.idcso.core.model.Pret;
import org.ac.idcso.core.service.PretService;
import org.ac.idcso.core.utils.paging.PagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/prets")
public class PretController {

    @Autowired
    PretService pretService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pret>> getAll() {
        return new ResponseEntity<>(this.pretService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/paginated", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Pret>> getAll(@Valid @RequestBody PagingData pagingData) {
        return new ResponseEntity<>(this.pretService.getAllPaginated(pagingData), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pret> findOne(@PathVariable("id") Long id) {
        final Pret Pret = Optional.ofNullable(this.pretService.getById(id)).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Le pret identifié par l'id '%s' n'existe pas.", id),
                        HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(Pret, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pret> save(@Valid @RequestBody Pret pret) {
        return new ResponseEntity<>(this.pretService.save(pret) , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.pretService.delete(id);
    }


}
