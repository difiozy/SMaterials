package org.example.kafka;

import static java.lang.Thread.sleep;

public class RunProduceAndConsumeKafka {

    private static KafkaConsumerAdapter kafkaConsumerAdapter = new KafkaConsumerAdapter();
    private static KafkaProducerAdapter kafkaProducerAdapter = new KafkaProducerAdapter();

    public static void run() {
        new Thread(() -> {
            while (true) {
                try {
                    kafkaProducerAdapter.sendMessage();
                    sleep(3000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                System.out.println("Start consume");
                kafkaConsumerAdapter.consumeMessage();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
