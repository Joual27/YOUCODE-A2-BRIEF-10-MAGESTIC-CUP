package org.youcode.magestic_cup.match.interfaces;

import org.youcode.magestic_cup.match.DTOs.CreateMatchDTO;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;

public interface MatchService {

    MatchResponseDTO save(CreateMatchDTO data);
}
