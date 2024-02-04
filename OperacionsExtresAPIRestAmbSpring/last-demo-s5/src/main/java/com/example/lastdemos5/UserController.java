package com.example.lastdemos5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public List<UserDto> readAll() {

        return userService.readAllUsers()
                .stream()
                .map(UserDto::new)
                .toList();
    }

    public UserDto getUserById(Integer id) {
        return new UserDto(userService.getUserById(id));
    }

    public UserDto addUser(User user) {
        User u = userService.addUser(user);
        return new UserDto(u);
    }

    public void removeUser(Integer id) {
        userService.removeUser(id);
    }

    public User updateUser(Integer id, User newUser) {
        return userService.updateUser(id, newUser);
    }

    public User userUpdate2(Integer id, Map<String, Object> updates){
        return  userService.userUpdate2(id, updates);
    }

}
