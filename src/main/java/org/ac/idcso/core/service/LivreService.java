package org.ac.idcso.core.service;

import org.ac.idcso.core.model.Livre;
import org.ac.idcso.core.repository.LivreRepository;
import org.ac.idcso.core.utils.paging.PageDataFactory;
import org.ac.idcso.core.utils.paging.PagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreService {
    @Autowired
    LivreRepository livreRepository;

    public Livre getById(Long id){
        return livreRepository.findById(id).orElse(null);
    }

    public List<Livre> getAll(){
        return livreRepository.findAll();
    }

    public Page<Livre> getAllPaginated(PagingData pagingData) {
        Pageable pageable = PageDataFactory.of(pagingData);
        return livreRepository.findAll(pageable);
    }

    public Livre save(Livre Livre){
        return livreRepository.save(Livre);
    }

    public void delete(Long id){
        livreRepository.deleteById(id);
    }
}
