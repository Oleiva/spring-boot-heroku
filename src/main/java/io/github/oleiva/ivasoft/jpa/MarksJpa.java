package io.github.oleiva.ivasoft.jpa;

import io.github.oleiva.ivasoft.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarksJpa  extends JpaRepository<MarksEntity, Long> {

}
