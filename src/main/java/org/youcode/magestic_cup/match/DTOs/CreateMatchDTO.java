package org.youcode.magestic_cup.match.DTOs;

import jakarta.validation.constraints.NotNull;
import org.youcode.magestic_cup.match.Match;

public record CreateMatchDTO(@NotNull String roundId , @NotNull String homeId , @NotNull String awayId , @NotNull
                             Match.Result result) {
}
