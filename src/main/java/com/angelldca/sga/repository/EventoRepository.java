package com.angelldca.sga.repository;

import com.angelldca.sga.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {
    List<Evento> findAllByActivo(boolean activo);
    Optional<Evento> findByName(String  name);

   @Modifying
   @Query(value = "UPDATE Evento e SET e.activo =:active WHERE e.id =:id")
    void changeActiveEvent(@Param("id") Long id,@Param("active") boolean active );
}
