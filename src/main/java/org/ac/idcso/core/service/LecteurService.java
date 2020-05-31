package org.ac.idcso.core.service;

import org.ac.idcso.core.model.Lecteur;
import org.ac.idcso.core.repository.LecteurRepository;
import org.ac.idcso.core.utils.paging.PageDataFactory;
import org.ac.idcso.core.utils.paging.PagingData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecteurService {
    @Autowired
    LecteurRepository lecteurRepository;

    public Lecteur getById(Long id){
        return lecteurRepository.findById(id).orElse(null);
    }

    public List<Lecteur> getAll(){
        return lecteurRepository.findAll();
    }

    public Page<Lecteur> getAllPaginated(PagingData pagingData) {
        Pageable pageable = PageDataFactory.of(pagingData);
        return lecteurRepository.findAll(pageable);
    }

    public Lecteur save(Lecteur Lecteur){
        return lecteurRepository.save(Lecteur);
    }

    public void delete(Long id){
        lecteurRepository.deleteById(id);
    }
}
