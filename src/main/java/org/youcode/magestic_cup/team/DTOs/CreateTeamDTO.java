package org.youcode.magestic_cup.team.DTOs;

import jakarta.validation.constraints.NotNull;

public record CreateTeamDTO(@NotNull String name ,@NotNull String city) {
}
