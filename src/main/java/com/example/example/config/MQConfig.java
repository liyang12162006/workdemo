package com.example.example.config;

import com.huitongjy.metrics.htmq.MsgReceiveListener;
import com.huitongjy.metrics.htmq.consumer.HtMqConsumer;
import com.huitongjy.metrics.htmq.consumer.listener.HtMessageListenerConcurrently;
import com.huitongjy.statcenter.support.mq.StatCenterConsumerListener;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mq配置文件
 * @author liyangyang
 * @date 2020-12-11 14:09
 */
@Configuration
@Data
public class MQConfig {
    @Value("${rocketmq.name-server}")
    private String nameServerAddr;
    @Value("${rocketmq.mq-env}")
    private String mqEnv;
    @Value("${rocketmq.producer.producer-group}")
    private String producerGroup;
    @Value("${rocketmq.consumer.consumer-group}")
    private String consumerGroup;
    @Value("${rocketmq.consumer.message-model}")
    private String messageModel;
    @Value("${rocketmq.consumer.thread.min}")
    private int consumerThreadMin;
    @Value("${rocketmq.consumer.thread.max}")
    private int consumerThreadMax;
    @Value("${rocketmq.topic.examStatsTopic}")
    private String examStatsTopic;
    @Value("${rocketmq.tag.examStatsTag}")
    private String examStatsTag;
    @Value("${rocketmq.topic.taskStatsInfoTopic}")
    private String taskStatsInfoTopic;
    @Value("${rocketmq.tag.taskStatsInfoTag}")
    private String taskStatsInfoTag;

//    @Bean
//    public MQSendCallBack createMQSendCallBack() {
//        return new MQSendCallBack();
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public HtMqProducer htMqProducer() {
//        HtMqProducer htMqProducer = new HtMqProducer();
//        htMqProducer.setNamesrvAddr(nameServerAddr);
//        htMqProducer.setMqEnv(mqEnv);
//        htMqProducer.setProducerGroup(producerGroup);
//        htMqProducer.setSendCallBack(createMQSendCallBack());
//        return htMqProducer;
//    }

    /**
     * 处理监听器
     */
    @Bean
    public StatCenterConsumerListener statCenterConsumerListener() {
        return new StatCenterConsumerListener();
    }

    @Bean
    public HtMessageListenerConcurrently htMessageListenerConcurrently() {
        HtMessageListenerConcurrently htMessageListenerConcurrently = new HtMessageListenerConcurrently();
        Map<String, MsgReceiveListener> msgReceiveListenerMap = new HashMap<>(16);
        msgReceiveListenerMap.put(examStatsTopic, statCenterConsumerListener());
        msgReceiveListenerMap.put(taskStatsInfoTopic, statCenterConsumerListener());
        htMessageListenerConcurrently.setMsgReceiveListeners(msgReceiveListenerMap);
        return htMessageListenerConcurrently;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public HtMqConsumer htMqConsumer() {
        HtMqConsumer htMqConsumer = new HtMqConsumer();
        htMqConsumer.setNamesrvAddr(nameServerAddr);
        htMqConsumer.setMqEnv(mqEnv);
        htMqConsumer.setConsumerGroup(consumerGroup);
        htMqConsumer.setMessageModel(messageModel);
        htMqConsumer.setConsumeThreadMin(consumerThreadMin);
        htMqConsumer.setConsumeThreadMax(consumerThreadMax);
        HashMap<String, String> topicTags = new HashMap<>(16);
        topicTags.put(examStatsTopic, examStatsTag);
        topicTags.put(taskStatsInfoTopic, taskStatsInfoTag);
        htMqConsumer.setTopicTags(topicTags);
        htMqConsumer.setMessageListener(htMessageListenerConcurrently());
        return htMqConsumer;
    }
}
