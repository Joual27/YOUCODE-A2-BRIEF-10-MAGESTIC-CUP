package org.youcode.magestic_cup.team;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.EntityNotFoundException;
import org.youcode.magestic_cup.exceptions.InvalidNumberOfTeamsException;
import org.youcode.magestic_cup.exceptions.TeamNameAlreadyExistsException;
import org.youcode.magestic_cup.player.DTOs.CreatePlayerDTO;
import org.youcode.magestic_cup.player.Player;
import org.youcode.magestic_cup.player.PlayerDAO;
import org.youcode.magestic_cup.player.interfaces.PlayerService;
import org.youcode.magestic_cup.player.mappers.CreatePlayerDTOToPlayerDocumentMapper;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;
import org.youcode.magestic_cup.team.interfaces.TeamService;
import org.youcode.magestic_cup.team.mappers.CreateTeamDTOToTeamDocumentMapper;
import org.youcode.magestic_cup.team.mappers.TeamDocumentToTeamResponseDTOMapper;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TeamServiceImp implements TeamService {

    private final TeamDao teamDao;
    private final CreateTeamDTOToTeamDocumentMapper createTeamDTOToTeamDocumentMapper;
    private final TeamDocumentToTeamResponseDTOMapper teamDocumentToTeamResponseDTOMapper;
    private final PlayerService playerService;
    private final CreatePlayerDTOToPlayerDocumentMapper createPlayerDTOToPlayerDocumentMapper;
    private final PlayerDAO playerDAO;

    @Override
    public TeamResponseDTO save(CreateTeamDTO data){
        if (teamDao.findByName(data.name()).isPresent()){
            throw new TeamNameAlreadyExistsException("Given team name already exists ! ");
        }
        Team teamToCreate = createTeamDTOToTeamDocumentMapper.toDocument(data);
        teamToCreate.setPlayers(new ArrayList<>());
        Team createdTeam = teamDao.save(teamToCreate);
        return teamDocumentToTeamResponseDTOMapper.documentToDto(createdTeam);
    }

    @Override
    public TeamResponseDTO addTeamPlayers(String teamId , List<CreatePlayerDTO> players){
        Team existingTeam = teamDao.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("No team found with given Id !"));
        if (players.size() < 15 || players.size() > 22){
            throw new InvalidNumberOfTeamsException("Team players number must be between 15 and 22");
        }
        List<Player> createdPlayers = players.stream()
                .map(playerService::save)
                .toList();
        existingTeam.getPlayers().addAll(createdPlayers);
        teamDao.save(existingTeam);
        return teamDocumentToTeamResponseDTOMapper.documentToDto(existingTeam);
    }

    @Override
    public Team getTeamDocumentById(String id){
        return teamDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No team was found with given ID "));
    }
}
