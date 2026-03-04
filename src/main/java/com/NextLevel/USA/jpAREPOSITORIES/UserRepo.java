 package com.NextLevel.USA.jpAREPOSITORIES;

import com.NextLevel.USA.ENTITIES.User;
import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.io.Serializable;
import java.util.Optional;

 public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


     Optional<Object> findById(SingularAttribute<AbstractPersistable, Serializable> id);
 }
