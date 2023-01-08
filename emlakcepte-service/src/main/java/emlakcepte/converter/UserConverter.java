package emlakcepte.converter;

import emlakcepte.model.User;
import emlakcepte.request.UserRequest;
import emlakcepte.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class UserConverter {

    public UserResponse convert(User user) {
        UserResponse response = new UserResponse();
        response.setEmail(user.getEmail());
        response.setId(user.getId());
        response.setName(user.getName());
        response.setType(user.getType());
        return response;
    }

    public User convert(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setCreateDate(LocalDateTime.now());
        user.setType(userRequest.getType());
        return user;
    }

    public List<UserResponse> convert(List<User> userList) {
        return userList.stream().map(this::convert).toList();
    }

}
