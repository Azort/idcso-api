package org.ac.idcso.core.controller;

import org.ac.idcso.core.exceptions.EntityNotFoundException;
import org.ac.idcso.core.model.Lecteur;
import org.ac.idcso.core.model.Livre;
import org.ac.idcso.core.service.LecteurService;
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
@RequestMapping("/api/lecteurs")
public class LecteurController {

    @Autowired
    LecteurService lecteurService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lecteur>> getAll() {
        return new ResponseEntity<>(this.lecteurService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/paginated", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Lecteur>> getAll(@Valid @RequestBody PagingData pagingData) {
        return new ResponseEntity<>(this.lecteurService.getAllPaginated(pagingData), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Lecteur> findOne(@PathVariable("id") Long id) {
        final Lecteur Lecteur = Optional.ofNullable(this.lecteurService.getById(id)).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Le lecteur identifié par l'id '%s' n'existe pas.", id),
                        HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(Lecteur, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Lecteur> save(@Valid @RequestBody Lecteur lecteur) {
        return new ResponseEntity<>(this.lecteurService.save(lecteur) , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.lecteurService.delete(id);
    }


}
