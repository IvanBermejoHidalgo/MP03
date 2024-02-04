package com.example.lastdemos5;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    public List<User> readAllUsers() {
        return userDAO.findAll();
    }

    public User getUserById(Integer id) {
        Optional<User> optionalUser;
        optionalUser = userDAO.findAllById(id);
        return optionalUser.orElse(null);
    }

    public User addUser(User user) {
        return userDAO.save(user);
    }

    public void removeUser(Integer id) {
        userDAO.deleteById(id);
    }

    public User updateUser(Integer id, User newUser) {
        Optional<User> optionalUser = userDAO.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setFullName(newUser.getFullName());
            // Update other fields as needed

            return userDAO.save(existingUser);
        } else {
            return null;
        }
    }

    public User userUpdate2(Integer id, Map<String,Object> updates){
        Optional<User> optionalUser = userDAO.findById(id);
        if (optionalUser.isPresent()){
            User existe = optionalUser.get();
            if (updates.containsKey("fullName")){
                existe.setEmail((String) updates.get("fullName"));
            }if (updates.containsKey("password")){
                existe.setEmail((String) updates.get("password"));
            }if (updates.containsKey("email")){
                existe.setEmail((String) updates.get("email"));
            }
            return userDAO.save(existe);

        }return null;
    }

}
