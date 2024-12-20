package org.youcode.magestic_cup.user.DTOs;

import jakarta.validation.constraints.NotNull;

public record AuthDTO(@NotNull String username , @NotNull String password) {
}