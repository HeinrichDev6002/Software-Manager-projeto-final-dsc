package com.example.software_manager.DTO;

import com.example.software_manager.Model.Image;
import com.example.software_manager.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long userId;
    private String userName;
    private String userEmail;
    private Image image;
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
