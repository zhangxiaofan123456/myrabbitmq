package com.heida;

import com.heida.producer.Producer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication()
@ComponentScan("com.heida.*")
public class MyrabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyrabbitmqApplication.class, args);
        new Thread(new Producer()).start();


    }

}
