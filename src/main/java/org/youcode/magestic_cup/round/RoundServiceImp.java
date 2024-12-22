package org.youcode.magestic_cup.round;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.EntityNotFoundException;

@AllArgsConstructor
@Service
public class RoundServiceImp implements RoundService{

    private final RoundDAO roundDAO;

    @Override
    public Round getRoundDocumentById(String id){
        return roundDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NO round found with given ID "));
    }
}
