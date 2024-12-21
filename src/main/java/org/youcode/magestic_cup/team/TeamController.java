package org.youcode.magestic_cup.team;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.magestic_cup.shared.utils.DTOs.SuccessDTO;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;
import org.youcode.magestic_cup.team.interfaces.TeamService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin/teams")
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<SuccessDTO<TeamResponseDTO>> createTeam(@RequestBody @Valid CreateTeamDTO req){
        TeamResponseDTO res = teamService.save(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "team created successfully !" , res), HttpStatus.OK);
    }
}
