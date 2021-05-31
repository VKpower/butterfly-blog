package me.vkpower.butterflyblog.admin.service.impl;

import me.vkpower.butterflyblog.admin.entity.UserEntity;
import me.vkpower.butterflyblog.admin.mapper.UserMapper;
import me.vkpower.butterflyblog.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Xiayuancheng
 * @since 2021-05-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

}
