package io.github.oleiva.ivasoft.jpa;


import io.github.oleiva.ivasoft.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentJpa extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByStudname(String name);

}
