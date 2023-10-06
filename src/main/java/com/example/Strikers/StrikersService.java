package com.example.Strikers;

import com.example.Strikers.models.Fighters;
import com.example.Strikers.models.Strikes;
import com.example.Strikers.repositories.FightersRepository;
import com.example.Strikers.repositories.StrikesRepository;
import com.example.Strikers.responses.Option;
import com.example.Strikers.responses.OptionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StrikersService {

    @Autowired
    StrikesRepository strikesRepository;

    @Autowired
    FightersRepository fightersRepository;


    public Strikes addStrike(Strikes strike) {
        Strikes newStrike = strikesRepository.save(strike);
        return newStrike;
    }

    public Fighters addFighter(Fighters fighter) {
        Strikes strike1 = strikesRepository.findById(fighter.getStrike1().getId()).orElseThrow(() -> new NotFoundException("Strike 1 does not exist"));
        Strikes strike2 = strikesRepository.findById(fighter.getStrike2().getId()).orElseThrow(() -> new NotFoundException("Strike 2 does not exist"));
        Strikes strike3 = strikesRepository.findById(fighter.getStrike3().getId()).orElseThrow(() -> new NotFoundException("Strike 3 does not exist"));
        Strikes strike4 = strikesRepository.findById(fighter.getStrike4().getId()).orElseThrow(() -> new NotFoundException("Strike 4 does not exist"));

        fighter.setStrike1Id(strike1.getId());
        fighter.setStrike1Id(strike2.getId());
        fighter.setStrike1Id(strike3.getId());
        fighter.setStrike1Id(strike4.getId());

        Fighters newFighter = fightersRepository.save(fighter);
        return newFighter;
    }


    public Strikes getStrikeById(long id){
        return strikesRepository.findById(id).orElseThrow(() -> new NotFoundException("Strike not found"));
    }
    public Fighters getFightersById(long id){
        return fightersRepository.findById(id).orElseThrow(() -> new NotFoundException("Strike not found"));
    }

    public List<Long> getStrikesIds(){
        return  strikesRepository.getDistinctIds();
    }

    public List<Option> getStrikes(){
        return getFormOptions(strikesRepository.findAll());
    }

    public List<Option> getFighters(){
        return getFormOptions(fightersRepository.findAll());
    }

    public List<Fighters> getAllFighters(int limit) {
    return fightersRepository.findAll();
    }
    public List<Strikes> getAllStrikes(int limit) {
        return strikesRepository.findAll();
    }

    public Strikes getRandomStrike(){
        return strikesRepository.getRandomStrike();
    }
    public List<Fighters> getRandomFighters(){
        return fightersRepository.getRandomFighters();
    }

    // UPDATE

    @Modifying
    public Strikes updateStrike(Strikes newStrike, long id){
        Strikes existingStrike = strikesRepository.findById(id).orElseThrow(()->new NotFoundException("Strike not found"));
        existingStrike.setName(newStrike.getName());
        existingStrike.setPower(newStrike.getPower());
        existingStrike.setStrike_type(newStrike.getStrike_type());
        existingStrike.setVideo_url_fighter(newStrike.getVideo_url_fighter());
        existingStrike.setVideo_url_tutorial(newStrike.getVideo_url_tutorial());

        Strikes updatedStrike = strikesRepository.save(existingStrike);
        return updatedStrike;
    }

    @Modifying
    public Fighters updateFighter(Fighters newFighter, long id){
        Strikes strike1 = strikesRepository.findById(newFighter.getStrike1().getId()).orElseThrow(() -> new NotFoundException("Strike 1 does not exist"));
        Strikes strike2 = strikesRepository.findById(newFighter.getStrike2().getId()).orElseThrow(() -> new NotFoundException("Strike 2 does not exist"));
        Strikes strike3 = strikesRepository.findById(newFighter.getStrike3().getId()).orElseThrow(() -> new NotFoundException("Strike 3 does not exist"));
        Strikes strike4 = strikesRepository.findById(newFighter.getStrike4().getId()).orElseThrow(() -> new NotFoundException("Strike 4 does not exist"));

        newFighter.setStrike1Id(strike1.getId());
        newFighter.setStrike1Id(strike2.getId());
        newFighter.setStrike1Id(strike3.getId());
        newFighter.setStrike1Id(strike4.getId());
        newFighter.setId(id);
        Fighters updatedFighter = fightersRepository.save(newFighter);
        updatedFighter.setStrike1Id(strike1.getId());
        updatedFighter.setStrike2Id(strike2.getId());
        updatedFighter.setStrike3Id(strike3.getId());
        updatedFighter.setStrike4Id(strike4.getId());
        return updatedFighter;
    }

    // DELETE
    @Transactional
    public void deleteStrikeById(long id){
        if(!strikesRepository.existsById(id)){
            throw new NotFoundException("Strike Not Found");
        }
        strikesRepository.deleteStrikeById(id);
    }

    // HELPER

    private List<Option> getFormOptions (List<? extends OptionContract> options){
        return options
                .stream()
                .distinct()
                .map(option -> new Option(option.getId(), option.getName()))
                .collect(Collectors.toList());

    }

}
