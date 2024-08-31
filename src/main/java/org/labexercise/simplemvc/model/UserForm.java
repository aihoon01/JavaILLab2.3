package org.labexercise.simplemvc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String name;
    private String email;
    private String gender;
    private String password;
    private String address;
}
