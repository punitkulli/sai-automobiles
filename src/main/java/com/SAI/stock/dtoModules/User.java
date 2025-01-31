package com.SAI.stock.dtoModules;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@Document(value = "users")
public class User extends BaseEntity {

    @Id
    private String id;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "role cannot be null")
    private String role;
    @NotNull(message = "phoneNo cannot be null")
    private String phoneNo;
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "password cannot be null")
    private String password;
    private String status = "ACTIVE";

}
