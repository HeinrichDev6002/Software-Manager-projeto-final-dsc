package com.example.software_manager.DTO;

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
    String userName;
    String userEmail;
    Long id;
    UserMapper mapper;

    public User toEntity(UserDTO user){
        return mapper.toEntity(user);
    }
    public UserDTO toDTO(User user){
        return mapper.toDto(user);
    }

    private static class UserMapper{
        private final ModelMapper modelMapper;

        public UserMapper(ModelMapper modelMapper){
            this.modelMapper = modelMapper;
        }
        public UserDTO toDto(User user){
            return modelMapper.map(user, UserDTO.class);
        }
        public User toEntity(UserDTO userDTO){
            return modelMapper.map(userDTO, User.class);
        }
    }
}
