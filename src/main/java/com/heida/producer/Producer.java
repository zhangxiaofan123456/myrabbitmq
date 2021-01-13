package com.heida.producer;

import com.heida.rabbitmq.RabbitTemplate;

import java.util.UUID;

public class Producer implements Runnable{
    @Override
    public void run() {
            try {
                Thread.sleep(1000);
                String message = UUID.randomUUID().toString();
                RabbitTemplate rabbitTemplate = new RabbitTemplate();
                boolean messageState = rabbitTemplate.convertAndSend("firstQueue", message);
                if (messageState){
                    System.out.println("消息成功被发送到队列中");
                }else {
                    System.out.println("消息发送队列失败");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
