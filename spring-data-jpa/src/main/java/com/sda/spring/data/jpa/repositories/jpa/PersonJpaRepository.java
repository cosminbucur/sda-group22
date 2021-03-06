package com.sda.spring.data.jpa.repositories.jpa;

import com.sda.spring.data.jpa.repositories.crud.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {
}
