package com.github.liuxboy.harbour.simulation.dao.mapper;


import com.github.liuxboy.harbour.simulation.dao.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by wyliuchundong on 14-4-14.
 */
public interface UserMapper {

    int insert(UserEntity entity);

    int updateUser(UserEntity entity);

    int delete(long id);

    UserEntity get(long id);

    List<UserEntity> list();

    List<UserEntity> queryByParam(Map map);

    UserEntity queryByUserNameAndPassWord(Map map);
}
