/*
Question 4 - TABA of Distributed Systems
TemperatureHumidityPublisher.java
@author Muhammad Syamil (x23104660)
07/05/2024
*/



import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class TemperatureHumidityPublisher {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
    private static final String TOPIC = "smart_office/69th_floor";

    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());
        client.connect();

        while (true) {
            double temperature = 17 + Math.random() * 10; // Simulate temperature readings
            double humidity = 25 + Math.random() * 20; // Simulate humidity readings

            String message = String.format("Temperature: %.2f°C, Humidity: %.2f%%", temperature, humidity);
            client.publish(TOPIC, new MqttMessage(message.getBytes()));

            Thread.sleep(1000); // Publish every second
        }
    }
}
