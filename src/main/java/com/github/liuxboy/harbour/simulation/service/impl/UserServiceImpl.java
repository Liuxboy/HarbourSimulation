package com.github.liuxboy.harbour.simulation.service.impl;

import com.github.liuxboy.harbour.simulation.service.UserService;
import org.apache.commons.lang3.StringUtils;
import com.github.liuxboy.harbour.simulation.common.util.ENCODEUtil;
import com.github.liuxboy.harbour.simulation.dao.entity.UserEntity;
import com.github.liuxboy.harbour.simulation.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(UserEntity entity) {
        //将密码进行MD5加密
        String pwd = ENCODEUtil.md5(entity.getPassWord());
        entity.setPassWord(pwd);
        return userMapper.insert(entity);
    }

    @Override
    public UserEntity login(UserEntity entity) {
        /*Map<String, String> param = new HashMap<String, String>();
        param.put("userName", entity.getUserName());
        //param.put("passWord", ENCODEUtil.md5(entity.getPassWord()));
        param.put("passWord", entity.getPassWord());
        return userMapper.queryByUserNameAndPassWord(param);*/
        Map<String, UserEntity> hashMap = new HashMap<String, UserEntity>();
        hashMap.put("liuchundong", new UserEntity("liuchundong", "123456"));
        hashMap.put("lulili", new UserEntity("lulili", "123456"));
        return hashMap.containsValue(entity) ? entity : null;
    }

    @Override
    public int delete(long id) {
        return userMapper.delete(id);
    }

    @Override
    public List<UserEntity> list() {
        return userMapper.list();
    }

    @Override
    public List<UserEntity> queryByParam(Map param) {
        return userMapper.queryByParam(param);
    }

    @Override
    public UserEntity get(long id) {
        return userMapper.get(id);
    }

    @Override
    public int update(UserEntity entity) {
        //将密码进行MD5加密
        if(!StringUtils.isBlank(entity.getPassWord())){
            String pwd = ENCODEUtil.md5(entity.getPassWord());
            entity.setPassWord(pwd);
        }
        return userMapper.updateUser(entity);
    }
}
