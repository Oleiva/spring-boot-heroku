package io.github.oleiva.ivasoft.jpa;

import io.github.oleiva.ivasoft.entity.StudentEntity;
import io.github.oleiva.ivasoft.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ivasoft on 18.11.2017.
 */
public interface SubjectJpa  extends JpaRepository<SubjectEntity, Long> {
    SubjectEntity findBySubject(String subject);

}

