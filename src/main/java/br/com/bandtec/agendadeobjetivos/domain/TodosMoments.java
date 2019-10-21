package br.com.bandtec.agendadeobjetivos.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodosMoments extends JpaRepository<Moments, Long> {

    @Query("from Moments where memoryLine = :memoryLine")
    public List<Moments> findByMemoryLine(@Param("memoryLine") MemoryLine memoryLine);

}
