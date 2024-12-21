package org.youcode.magestic_cup.team;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.TeamNameAlreadyExistsException;
import org.youcode.magestic_cup.team.DTOs.CreateTeamDTO;
import org.youcode.magestic_cup.team.DTOs.TeamResponseDTO;
import org.youcode.magestic_cup.team.interfaces.TeamService;
import org.youcode.magestic_cup.team.mappers.CreateTeamDTOToTeamDocumentMapper;
import org.youcode.magestic_cup.team.mappers.TeamDocumentToTeamResponseDTOMapper;

@AllArgsConstructor
@Service
public class TeamServiceImp implements TeamService {

    private final TeamDao teamDao;
    private final CreateTeamDTOToTeamDocumentMapper createTeamDTOToTeamDocumentMapper;
    private final TeamDocumentToTeamResponseDTOMapper teamDocumentToTeamResponseDTOMapper;

    @Override
    public TeamResponseDTO save(CreateTeamDTO data){
        if (teamDao.findByName(data.name()).isPresent()){
            throw new TeamNameAlreadyExistsException("Given team name already exists ! ");
        }
        Team teamToCreate = createTeamDTOToTeamDocumentMapper.toDocument(data);
        Team createdTeam = teamDao.save(teamToCreate);
        return teamDocumentToTeamResponseDTOMapper.documentToDto(createdTeam);
    }
}
