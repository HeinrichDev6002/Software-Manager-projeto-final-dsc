package com.example.software_manager.DTO;

import com.example.software_manager.Model.Image;
import com.example.software_manager.Validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    @NotBlank(message = "O nome não pode estar vazio")
    @Pattern(
            regexp = "^[\\p{L}]{3,}$",
            message = "O nome de usuário deve ter no mínimo 3 letras"
    )
    private String userName;
    @NotBlank(message = "O email não pode estar vazio")
    @Email
    private String userEmail;
    private Image image;
    @NotBlank
    @ValidPassword
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", image=" + image +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
