package org.youcode.magestic_cup.shared.utils.interfaces;

public interface BaseMapper <T , DTO>{
    T toDocument(DTO dto);
    DTO documentToDto(T document);
}