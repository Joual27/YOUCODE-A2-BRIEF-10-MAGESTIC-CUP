package org.youcode.magestic_cup.competition;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.magestic_cup.competition.DTOs.CompetitionResponseDTO;
import org.youcode.magestic_cup.competition.DTOs.CreateCompetitionDTO;
import org.youcode.magestic_cup.competition.interfaces.CompetitionService;
import org.youcode.magestic_cup.shared.utils.DTOs.SuccessDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<SuccessDTO<CompetitionResponseDTO>> createCompetition(@RequestBody @Valid CreateCompetitionDTO req){
        CompetitionResponseDTO res = competitionService.save(req);
        return new ResponseEntity<>(new SuccessDTO<>("success " , "competition created successfully " , res) , HttpStatus.OK);
    }

}
