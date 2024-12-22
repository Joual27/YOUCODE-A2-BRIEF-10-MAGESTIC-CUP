package org.youcode.magestic_cup.stats;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.competition.interfaces.CompetitionService;
import org.youcode.magestic_cup.match.interfaces.MatchService;
import org.youcode.magestic_cup.stats.interfaces.StatsService;
import org.youcode.magestic_cup.round.Round;
import org.youcode.magestic_cup.round.RoundService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StatsServiceImp implements StatsService {
    private final RoundService roundService;
    private final CompetitionService competitionService;
    private final MatchService matchService;
    private final StatsDAO statsDAO;

    @Override
    public List<Stats> getPlayerStatsPreviousToRound(String playerId, String roundId) {
        Round currentRound = roundService.getRoundDocumentById(roundId);
        String competitionId = currentRound.getCompetition().getId();
        List<Round> allRounds = competitionService.getAllRoundsByCompetitionId(competitionId);

        List<Round> previousRounds = allRounds.stream()
                .filter(round -> round.getRoundNumber() < currentRound.getRoundNumber())
                .collect(Collectors.toList());

        return previousRounds.stream()
                .flatMap(round -> matchService.getMatchesByRoundId(round.getId()).stream())
                .flatMap(match -> match.getResult().getStats().stream())
                .filter(stats -> stats.getPlayer().getId().equals(playerId))
                .collect(Collectors.toList());
    }
}