package com.example.Strikers;

import com.example.Strikers.models.Strikes;
import com.example.Strikers.models.Fighters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class StrikersController {
    @Autowired
    private StrikersService strikerService;

    @ExceptionHandler
    public ResponseEntity<String> handleException(Exception exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // CREATE
    @PostMapping("/strike")
    public ResponseEntity<Strikes> createStrike(@RequestBody Strikes strike) {
        Strikes newStrike = strikerService.addStrike(strike);
        return ResponseEntity.status(HttpStatus.CREATED).body(newStrike);
    }

    @PostMapping("/fighter")
    public ResponseEntity<Fighters> createFighter(@RequestBody Fighters fighter) {
        Fighters newFighter = strikerService.addFighter(fighter);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFighter);
    }

    // READ

    @GetMapping("/strikes")
    public ResponseEntity<List<Strikes>> getStrikes(@RequestParam(defaultValue = "200") int limit){
        return ResponseEntity.status(HttpStatus.OK).body(strikerService.getAllStrikes(limit));
    }

    @GetMapping("/fighters")
    public ResponseEntity<List<Fighters>> getFighters(@RequestParam(defaultValue = "200") int limit){
        return ResponseEntity.status(HttpStatus.OK).body(strikerService.getAllFighters(limit));
    }

    @GetMapping("/strikes/random")
    public ResponseEntity<Strikes> getRandomStrike() {
        return ResponseEntity.status(HttpStatus.OK).body(strikerService.getRandomStrike());
    }

    @GetMapping("/fighters/random")
    public ResponseEntity<List<Fighters>> getRandomFighters() {
        return ResponseEntity.status(HttpStatus.OK).body(strikerService.getRandomFighters());
    }

    @GetMapping("/strike/{id}")
    public ResponseEntity<Strikes> getStrikeById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(strikerService.getStrikeById(id));
    }

    // UPDATE
    @PutMapping("/strike/{id}")
    public ResponseEntity<Strikes> updateStrike(@RequestBody Strikes newStrike, @PathVariable long id){
        Strikes updatedStrike = strikerService.updateStrike(newStrike, id);
        return ResponseEntity.status(HttpStatus.OK).body(updatedStrike);
    }

    // DELETE
    @DeleteMapping("/strike/{id}")
    public ResponseEntity<Void> deleteStrikeById(@PathVariable long id) {
        strikerService.deleteStrikeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}