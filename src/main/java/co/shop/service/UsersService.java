package co.shop.service;

import co.shop.model.entity.user.Users;

public interface UsersService  {
    Users findByUserName(String loginId);
}
