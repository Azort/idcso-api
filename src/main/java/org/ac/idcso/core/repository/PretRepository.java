package org.ac.idcso.core.repository;

import org.ac.idcso.core.model.Livre;
import org.ac.idcso.core.model.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PretRepository extends JpaRepository<Pret,Long> {
}
