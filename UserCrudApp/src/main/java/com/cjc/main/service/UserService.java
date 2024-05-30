package com.cjc.main.service;

import com.cjc.main.model.User;

public interface UserService {

  public User saveUserDetails(User user);

public User getSingleUser(int id);

}
