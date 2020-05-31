package org.ac.idcso.core.controller;

import org.ac.idcso.core.exceptions.EntityNotFoundException;
import org.ac.idcso.core.model.Livre;
import org.ac.idcso.core.service.LivreService;
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
@RequestMapping("/api/livres")
public class LivreController {

    @Autowired
    LivreService livreService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Livre>> getAll() {
        return new ResponseEntity<>(this.livreService.getAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/paginated", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Livre>> getAll(@Valid @RequestBody PagingData pagingData) {
        return new ResponseEntity<>(this.livreService.getAllPaginated(pagingData), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Livre> findOne(@PathVariable("id") Long id) {
        final Livre Livre = Optional.ofNullable(this.livreService.getById(id)).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Le Livre identifié par l'id '%s' n'existe pas.", id),
                        HttpStatus.NOT_FOUND));
        return new ResponseEntity<>(Livre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Livre> save(@Valid @RequestBody Livre livre) {
        return new ResponseEntity<>(this.livreService.save(livre) , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.livreService.delete(id);
    }




}
