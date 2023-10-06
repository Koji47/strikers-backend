package com.example.Strikers.repositories;

import com.example.Strikers.models.Fighters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Table(name = "fighters")
@Repository
public interface FightersRepository  extends JpaRepository<Fighters, Long> {

    List<Fighters> findAll();
    // READ
    // DELETE
    @Query(value = "SELECT * FROM fighters ORDER BY RAND()", nativeQuery = true)
    List<Fighters> getRandomFighters();
    void deleteFighterById(long id);
}
