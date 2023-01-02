package com.xavia.ris.Repo;

import com.xavia.ris.Entidades.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaRepo extends JpaRepository<Cita, Long> {
  @Query(
    "SELECT c FROM Cita c WHERE c.fechaCita LIKE %?1%" +
    " OR c.paciente LIKE %?1%"
  )
  public List<Cita> findAll(String palBuscarCita);
}
