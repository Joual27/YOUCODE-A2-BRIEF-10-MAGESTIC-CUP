package org.youcode.magestic_cup.player.DTOs;

import jakarta.validation.constraints.NotNull;

public record CreatePlayerDTO(@NotNull String name ,@NotNull String surname ,@NotNull String position , @NotNull int number) {
}
