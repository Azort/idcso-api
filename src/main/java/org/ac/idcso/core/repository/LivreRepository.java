package org.ac.idcso.core.repository;

import org.ac.idcso.core.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre,Long> {
}
