package org.youcode.magestic_cup.shared.utils.interfaces;

public interface BaseMapper <T , DTO>{
    T toEntity(DTO dto);
    DTO entityToDto(T entity);
}