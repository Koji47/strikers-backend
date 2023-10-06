package com.example.Strikers.repositories;

import com.example.Strikers.models.Strikes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Table(name = "strikes")
@Repository
public interface StrikesRepository extends JpaRepository<Strikes, Long> {

    List<Strikes> findAll();


    // READ
    @Query(value = "SELECT DISTINCT id FROM strikes ORDER BY id", nativeQuery = true)
    List<Long> getDistinctIds();

    @Query(value = "SELECT * FROM strikes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Strikes getRandomStrike();
    // DELETE

    void deleteStrikeById (long id);
}
