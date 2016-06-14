package com.github.liuxboy.harbour.simulation.service;

import com.github.liuxboy.harbour.simulation.dao.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by liuchundong on 2016-06-08 16:30:17
 */
public interface UserService {
    int insert(UserEntity entity);

    int delete(long id);

    List<UserEntity> list();

    List<UserEntity> queryByParam(Map param);

    UserEntity get(long id);

    UserEntity login(UserEntity entity);

    int update(UserEntity entity);

}
