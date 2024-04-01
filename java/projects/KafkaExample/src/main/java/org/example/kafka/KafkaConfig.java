package org.example.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class KafkaConfig {

    public static final Properties CONFIG = new Properties();

    static {
        try {
            CONFIG.put("client.id", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        CONFIG.put("bootstrap.servers", "localhost:29092");
        CONFIG.put("group.id", "test");
        CONFIG.put("enable.auto.commit", "true");
        CONFIG.put("auto.create.topics.enable", "true");
        CONFIG.put("key.deserializer", StringDeserializer.class);
        CONFIG.put("value.deserializer", StringDeserializer.class);
        CONFIG.put("key.serializer", StringSerializer.class);
        CONFIG.put("value.serializer", StringSerializer.class);

    }public static final Properties CONFIG_CONS = new Properties();

    static {
        try {
            CONFIG_CONS.put("client.id", InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        CONFIG_CONS.put("bootstrap.servers", "localhost:29092");
        CONFIG_CONS.put("group.id", "test_cons");
        CONFIG_CONS.put("enable.auto.commit", "true");
        CONFIG_CONS.put("auto.create.topics.enable", "true");
        CONFIG_CONS.put("key.deserializer", StringDeserializer.class);
        CONFIG_CONS.put("value.deserializer", StringDeserializer.class);
        CONFIG_CONS.put("key.serializer", StringSerializer.class);
        CONFIG_CONS.put("value.serializer", StringSerializer.class);

    }
}
