package com.heida.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Component
public class RabbitTemplate {

    @Resource
    private RedisTemplate redisTemplate;

    public boolean convertAndSend(String queueId,String message){
        redisTemplate.opsForList().leftPush(queueId,message);
        Object o = redisTemplate.opsForList().index(queueId, 0);
        System.out.println("接收到的消息是"+o);
        if (o!=null){
            return true;
        }else {
            return false;
        }

    }

}
