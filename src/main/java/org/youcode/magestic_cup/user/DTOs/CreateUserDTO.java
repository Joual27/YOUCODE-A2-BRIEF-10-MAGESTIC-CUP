package org.youcode.magestic_cup.user.DTOs;

import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(@NotNull String username ,@NotNull String password) {
}