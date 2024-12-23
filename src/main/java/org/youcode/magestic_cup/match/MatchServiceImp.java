package org.youcode.magestic_cup.match;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.magestic_cup.exceptions.NotEligiblePlayersException;
import org.youcode.magestic_cup.exceptions.PlayerNotInGameException;
import org.youcode.magestic_cup.exceptions.TeamStatsLimitExceededException;
import org.youcode.magestic_cup.exceptions.UnmatchedResultGoalsException;
import org.youcode.magestic_cup.match.DTOs.CreateMatchDTO;
import org.youcode.magestic_cup.match.DTOs.MatchResponseDTO;
import org.youcode.magestic_cup.match.interfaces.MatchService;
import org.youcode.magestic_cup.match.mappers.CreateMatchDTOToMatchDocumentMapper;
import org.youcode.magestic_cup.match.mappers.MatchDocumentToMatchResponseDTOMapper;
import org.youcode.magestic_cup.player.Player;
import org.youcode.magestic_cup.round.Round;
import org.youcode.magestic_cup.round.RoundService;
import org.youcode.magestic_cup.stats.Stats;
import org.youcode.magestic_cup.stats.interfaces.StatsService;
import org.youcode.magestic_cup.team.Team;
import org.youcode.magestic_cup.team.interfaces.TeamService;
import java.util.List;

@AllArgsConstructor
@Service
public class MatchServiceImp implements MatchService {
    private final RoundService roundService;
    private final TeamService teamService;
    private final StatsService statsService;
    private final MatchDAO matchDAO;
    private final CreateMatchDTOToMatchDocumentMapper createMatchDTOToMatchDocumentMapper;
    private final MatchDocumentToMatchResponseDTOMapper matchDocumentToMatchResponseDTOMapper;

    public MatchResponseDTO save(CreateMatchDTO data){
        Round gameRound = roundService.getRoundDocumentById(data.roundId());
        Team homeTeam = teamService.getTeamDocumentById(data.homeId());
        Team awayTeam = teamService.getTeamDocumentById(data.awayId());
        if (!areAllPlayersOfGame(data.result().getStats() , homeTeam , awayTeam)){
            throw new PlayerNotInGameException("The Given stats contains a player that is in neither teams !");
        }
        if (!areLegitimateFootballGameStats(data.result().getStats() , homeTeam ,awayTeam)){
            throw new TeamStatsLimitExceededException("Each team can have at most 17 stats ");
        }

        if (!areValidGoalsStats(data.result().getStats() , data.result().getHomeGoals() , data.result().getAwayGoals() , homeTeam , awayTeam)){
            throw new UnmatchedResultGoalsException("The result and stats aren't matched !");
        }

        if (!arePlayersEligible(data.result().getStats() , gameRound)){
            throw new NotEligiblePlayersException("Players with 2 yellow cards in previous rounds or a red card can't play this game !");
        }
        Match matchToCreate = createMatchDTOToMatchDocumentMapper.toDocument(data);
        Match createdMatch = matchDAO.save(matchToCreate);
        return matchDocumentToMatchResponseDTOMapper.documentToDto(createdMatch);
    }

    private boolean areAllPlayersOfGame(List<Stats> stats, Team home, Team away) {
        List<String> allPlayerIds = stats.stream()
                .map(stat -> stat.getPlayer().getId())
                .toList();

        List<String> homePlayerIds = home.getPlayers().stream()
                .map(Player::getId)
                .toList();

        List<String> awayPlay,erIds = away.getPlayers().stream()
                .map(Player::getId)
                .toList();

        return allPlayerIds.stream()
                .allMatch(playerId -> homePlayerIds.contains(playerId) || awayPlayerIds.contains(playerId));
    }

    private boolean areLegitimateFootballGameStats(List<Stats> stats, Team home, Team away) {
        long homeStatsCount = stats.stream()
                .filter(stat -> home.getPlayers().contains(stat.getPlayer()))
                .count();

        long awayStatsCount = stats.stream()
                .filter(stat -> away.getPlayers().contains(stat.getPlayer()))
                .count();

        return homeStatsCount <= 17 && awayStatsCount <= 17;
    }

    private boolean areValidGoalsStats(List<Stats> stats, int homeGoals, int awayGoals , Team home, Team away ) {
        int totalHomeGoals = stats.stream()
                .filter(stat -> home.getPlayers().contains(stat.getPlayer()))
                .mapToInt(Stats::getGoals)
                .sum();

        int totalAwayGoals = stats.stream()
                .filter(stat -> away.getPlayers().contains(stat.getPlayer()))
                .mapToInt(Stats::getGoals)
                .sum();

        return totalHomeGoals == homeGoals && totalAwayGoals == awayGoals;
    }

    @Override
    public List<Match> getMatchesByRoundId(String roundId) {
        return matchDAO.findByRoundId(roundId);
    }

    private boolean arePlayersEligible(List<Stats> stats, Round currentRound) {
        return stats.stream().allMatch(stat -> {
            Player player = stat.getPlayer();
            List<Stats> previousStats = statsService.getPlayerStatsPreviousToRound(player.getId(), currentRound.getId());
            int yellowCards = previousStats.stream().mapToInt(Stats::getYellowCards).sum();
            int redCards = previousStats.stream().mapToInt(Stats::getRedCards).sum();
            return yellowCards < 2 && redCards == 0;
        });
    }
}
