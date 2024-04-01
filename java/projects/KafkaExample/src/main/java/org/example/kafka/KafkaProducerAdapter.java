package org.example.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.protocol.types.Field;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class KafkaProducerAdapter {

    public final KafkaProducer<String, String> PRODUCER =
            new KafkaProducer<>(KafkaConfig.CONFIG);
    private final Random random = new Random();

    void sendMessage() throws ExecutionException, InterruptedException, TimeoutException {
        final ProducerRecord<String, String> record = new ProducerRecord<>("java.example.main",
                String.valueOf(random.nextInt()),
                "String=" + random.nextInt());
        System.out.println("Produce message " + record.value());
        RecordMetadata recordMetadata = PRODUCER.send(record).get(10, TimeUnit.SECONDS);
        System.out.println("Produce=" + recordMetadata.offset());
    }
}
