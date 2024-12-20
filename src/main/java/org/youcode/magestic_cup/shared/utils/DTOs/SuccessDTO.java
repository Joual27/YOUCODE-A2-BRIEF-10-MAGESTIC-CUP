package org.youcode.magestic_cup.shared.utils.DTOs;

public record SuccessDTO<T>(String status , String message , T data) {
}