/*
Question 4 - TABA of Distributed Systems
SyamilLightsWindowsPublisher.java
@author Muhammad Syamil (x23104660)
07/05/2024
*/



import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SyamilLightsWindowsPublisher {
    private static final String BROKER_URL = "tcp://broker.hivemq.com:1883";
    private static final String TOPIC = "smart_office/69th_floor";

    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttClient client = new MqttClient(BROKER_URL, MqttClient.generateClientId());
        client.connect();

        while (true) {

            // Simulates lights status
            String lightStatus = Math.random() < 0.5 ? "ON" : "OFF";
            // Simulates windows status
            String windowStatus = Math.random() < 0.5 ? "OPEN" : "CLOSE";

            String message = String.format("Lights: %s, Windows: %s", lightStatus, windowStatus);
            client.publish(TOPIC, new MqttMessage(message.getBytes()));

            Thread.sleep(500); // <--- Publishes the message every half a second
        }
    }
}