package com.exercises.RestTemplate.service;

import com.exercises.RestTemplate.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;

    public List<UserDTO> getUsers() {
        UserDTO[] response = restTemplate.getForObject(basePath + "/user", UserDTO[].class);
        if (response == null) throw new AssertionError();
        return Arrays.asList(response);
    }

    public void saveUser(UserDTO user) {
        restTemplate.postForObject(basePath + "/user", user, UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO user) {
        restTemplate.put(basePath + "/user/" + id, user);
    }

    public void deleteUser(Integer id) {
        restTemplate.delete(basePath + "/user/" + id);
    }
}
