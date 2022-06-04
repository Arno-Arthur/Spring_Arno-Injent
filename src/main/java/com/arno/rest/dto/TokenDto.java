package com.arno.rest.dto;

import com.arno.domain.Token;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TokenDto {

    private int id;

    private String value;

    private long expiration;

    private int user;

    public static TokenDto toDto(Token token){
        return new TokenDto(
                token.getId(),
                token.getValue(),
                token.getExpiration(),
                token.getUser()
        );
    }

    public static Token toDomainObject(TokenDto tokenDto){
        return new Token(
                tokenDto.getId(),
                tokenDto.getValue(),
                tokenDto.getExpiration(),
                tokenDto.getUser()
        );
    }
}
