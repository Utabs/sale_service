package co.shop.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String family;
    private String nationalCode;
    private String userName;
    private String password;
    private String phoneNumber;
    private Boolean active;
}
