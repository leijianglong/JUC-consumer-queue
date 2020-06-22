package com.danielei.service.impl;

import com.danielei.entity.User;
import com.danielei.service.UserService;
import com.danielei.thread.ProviderTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * date: 2020/6/22 0022
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    public void register(User user) {
        String email = user.getEmail();
        //给队列推送邮箱账号过去,队列处理发送邮件
        ProviderTask.pushQueue(email);

        //some action
        log.info("保存用户信息到数据库");
    }
}
