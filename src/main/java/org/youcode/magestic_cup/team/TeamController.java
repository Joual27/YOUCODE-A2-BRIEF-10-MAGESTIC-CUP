package org.youcode.magestic_cup.team;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.shared.utils.DTOs.SuccessDTO;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;
import org.youcode.magestic_cup.team.interfaces.TeamService;

import java.util.List;

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

    @PostMapping("/{id}/players")
    public ResponseEntity<SuccessDTO<TeamResponseDTO>> addTeamPlayers(@RequestBody @Valid List<CreatePlayerDTO> req , @PathVariable("id") String id){
        TeamResponseDTO res = teamService.addTeamPlayers(id ,req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Players appended successfully !" , res), HttpStatus.OK);
    }
}
