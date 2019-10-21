package br.com.bandtec.agendadeobjetivos.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosMemoryLine extends JpaRepository<MemoryLine, Long> {

    @Query("from MemoryLine where owner = :owner")
    public List<MemoryLine> findByOwner(@Param("owner") Usuario usuario);
}
