package com.arno.rest.dto;

import com.arno.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {

    private TokenDto tokenDto;
    private OrganizationDto organizationDto;

    private int id;

    private String firstname;

    private String middlename;

    private String lastname;

    private String workingPosition;

    private String login;

    private String password;

    public static UserDto toDto(User user){
        return new UserDto(
                TokenDto.toDto(user.getTokenId()),
                OrganizationDto.toDto(user.getOrganization_id()),
                user.getId(),
                user.getFirstname(),
                user.getMiddlename(),
                user.getLastname(),
                user.getWorking_position(),
                user.getLogin(),
                user.getPassword()
        );
    }

    public static User toDomainObject(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getMiddlename(),
                userDto.getLastname(),
                TokenDto.toDomainObject(userDto.getTokenDto()),
                userDto.getWorkingPosition(),
                userDto.getLogin(),
                userDto.getPassword(),
                OrganizationDto.toDomainObject(userDto.getOrganizationDto())
        );
    }
    @JsonProperty("token")
    public TokenDto getTokenDto() {
        return tokenDto;
    }
    @JsonProperty("organization")
    public OrganizationDto getOrganizationDto() {
        return organizationDto;
    }
}
