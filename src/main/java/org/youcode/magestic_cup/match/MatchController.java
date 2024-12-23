package org.youcode.magestic_cup.match;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.magestic_cup.match.DTOs.CreateMatchDTO;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;
import org.youcode.magestic_cup.match.interfaces.MatchService;
import org.youcode.magestic_cup.shared.utils.DTOs.SuccessDTO;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/matches")
public class MatchController {
    private final MatchService matchService;

    @PostMapping
    public ResponseEntity<SuccessDTO<MatchResponseDTO>> createMatch(CreateMatchDTO req){
        MatchResponseDTO res = matchService.save(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "match created successfully !" , res) , HttpStatus.OK);
    }
}
