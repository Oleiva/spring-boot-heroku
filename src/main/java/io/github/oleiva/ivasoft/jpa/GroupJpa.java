package io.github.oleiva.ivasoft.jpa;


import io.github.oleiva.ivasoft.entity.MarksEntity;
import io.github.oleiva.ivasoft.entity.PGroup;
import io.github.oleiva.ivasoft.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface GroupJpa extends JpaRepository<PGroup, Long> {

    PGroup findByGroupName (String fioHash);
}
