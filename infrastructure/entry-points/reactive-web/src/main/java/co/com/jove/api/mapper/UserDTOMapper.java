package co.com.jove.api.mapper;

import co.com.jove.api.dto.CreateUserDTO;
import co.com.jove.api.dto.UserDTO;
import co.com.jove.model.user.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserDTOMapper {
    UserDTO toResponse(User user);
    List<UserDTO> toResponse(List<User> users);
    User toModel(CreateUserDTO createUserDTO);

}
