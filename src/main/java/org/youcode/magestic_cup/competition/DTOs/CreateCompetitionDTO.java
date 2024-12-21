package org.youcode.magestic_cup.competition.DTOs;

import jakarta.validation.constraints.NotNull;

public record CreateCompetitionDTO(@NotNull String name , @NotNull int numberOfTeams) {
}
