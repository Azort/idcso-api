package org.ac.idcso.core.service;

import org.ac.idcso.core.model.Pret;
import org.ac.idcso.core.repository.PretRepository;
import org.ac.idcso.core.utils.paging.PageDataFactory;
import org.ac.idcso.core.utils.paging.PagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PretService {
    @Autowired
    PretRepository pretRepository;

    public Pret getById(Long id){
        return pretRepository.findById(id).orElse(null);
    }

    public List<Pret> getAll(){
        return pretRepository.findAll();
    }

    public Page<Pret> getAllPaginated(PagingData pagingData) {
        Pageable pageable = PageDataFactory.of(pagingData);
        return pretRepository.findAll(pageable);
    }

    public Pret save(Pret Pret){
        return pretRepository.save(Pret);
    }

    public void delete(Long id){
        pretRepository.deleteById(id);
    }
}
