package org.example.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class KafkaConsumerAdapter {

    public final KafkaConsumer<String, String> CONSUMER =
            new KafkaConsumer<>(KafkaConfig.CONFIG_CONS);

    void consumeMessage() {
        CONSUMER.subscribe(List.of("java.example.main"));
        ConsumerRecords<String, String> poll = CONSUMER.poll(500);
        System.out.println("Consume message " + poll.count());
        poll.iterator().forEachRemaining(el -> {
            System.out.print(el.value() + " ");
        });
        CONSUMER.commitSync();
    }
}
