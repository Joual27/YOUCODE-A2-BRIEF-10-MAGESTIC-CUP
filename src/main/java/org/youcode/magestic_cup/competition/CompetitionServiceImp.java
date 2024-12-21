package org.youcode.magestic_cup.competition;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.competition.DTOs.CompetitionResponseDTO;
import org.youcode.magestic_cup.competition.DTOs.CreateCompetitionDTO;
import org.youcode.magestic_cup.competition.interfaces.CompetitionService;
import org.youcode.magestic_cup.competition.mappers.CompetitionDocumentToCompetitionResponseDTOMapper;
import org.youcode.magestic_cup.competition.mappers.CreateCompetitionDTOToCompetitionDocumentMapper;
import org.youcode.magestic_cup.exceptions.InvalidNumberOfTeamsException;

@AllArgsConstructor
@Service
public class CompetitionServiceImp implements CompetitionService {

    private final CompetitionDao competitionDao;
    private final CreateCompetitionDTOToCompetitionDocumentMapper createCompetitionDTOToCompetitionDocumentMapper;
    private final CompetitionDocumentToCompetitionResponseDTOMapper competitionDocumentToCompetitionResponseDTOMapper;

    public CompetitionResponseDTO save(CreateCompetitionDTO data){
        if (!isValidNumberOfTeams(data.numberOfTeams())){
            throw new InvalidNumberOfTeamsException("Number of teams must be either 8 | 16 | 32 | 64");
        }
        Competition competitionToCreate = createCompetitionDTOToCompetitionDocumentMapper.toDocument(data);
        Competition createdCompetition = competitionDao.save(competitionToCreate);
        return competitionDocumentToCompetitionResponseDTOMapper.documentToDto(competitionToCreate);
    }

    private boolean isValidNumberOfTeams(int numberOfTeams){
        if (numberOfTeams != 8 && numberOfTeams != 16 && numberOfTeams != 32 && numberOfTeams != 64){
            return false;
        }
        return true;
    }
}
