package com.arno.rest.dto;

import com.arno.domain.Call;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CallDto {

    private int id;

    private int user_id;

    private String edit_card_date;

    private String reason;

    private String bcc;

    private String firstname;

    private String middlename;

    private String lastname;

    private String sex;

    private String residence;

    private int phone_number;

    public static CallDto toDto (Call call){
        return new CallDto(
                call.getId(),
                call.getUser_id(),
                call.getEdit_card_date(),
                call.getReason(),
                call.getBcc(),
                call.getFirstname(),
                call.getMiddlename(),
                call.getLastname(),
                call.getSex(),
                call.getResidence(),
                call.getPhone_number()
        );
    }

    public static Call toDomainObject(CallDto callDto){
        return new Call(
                callDto.getId(),
                callDto.getUser_id(),
                callDto.getEdit_card_date(),
                callDto.getReason(),
                callDto.getBcc(),
                callDto.getFirstname(),
                callDto.getMiddlename(),
                callDto.getLastname(),
                callDto.getSex(),
                callDto.getResidence(),
                callDto.getPhone_number()
        );
    }
}
