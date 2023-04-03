package com.practice.rest.webservices.restwebservices.dao;

import org.springframework.stereotype.Component;
import com.practice.rest.webservices.restwebservices.pojos.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();

    static int userId = 0;
    static {
        userList.add(new User(++userId, "Raj", LocalDate.now().minusYears(30)));
        userList.add(new User(++userId, "Keerthana", LocalDate.now().minusYears(27)));
        userList.add(new User(++userId, "Tamil", LocalDate.now().minusYears(40)));
        userList.add(new User(++userId, "Peter", LocalDate.now().minusYears(20)));
        userList.add(new User(++userId, "Albert", LocalDate.now().minusYears(44)));
    }

    public List<User> findAll(){
        return userList;
    }

    public User findOne(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
        Predicate<User> userPredicate = user -> user.getId().equals(id);
        userList.removeIf(userPredicate);
    }

    public User save(User user) {
        user.setId(++userId);
        userList.add(user);
        return user;
    }

}
