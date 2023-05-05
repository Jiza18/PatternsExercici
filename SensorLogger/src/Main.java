import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

class SensorData {
    String sensorID;
    LocalDateTime timestamp;
    double value;

    public SensorData(String sensorID, LocalDateTime timestamp, double value) {
        this.sensorID = sensorID;
        this.timestamp = timestamp;
        this.value = value;
    }
}

class SensorLogger {
    static SensorLogger INSTANCE;
    private final String fileName;

    private SensorLogger(String fileName) {
        this.fileName = fileName;
    }

    static SensorLogger getInstance(String fileName){
        if (INSTANCE == null){
            INSTANCE = new SensorLogger(fileName);
        }
        return INSTANCE;
    }

    public void logData(SensorData data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(data.sensorID + "," + data.timestamp + "," + data.value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Sensor {
    interface DataReceiver {
        void receive(SensorData sensorData);
    }

    void start(DataReceiver dataReceiver){
        while(true) {
            dataReceiver.receive(new SensorData("SensorXYZ", LocalDateTime.now(), ThreadLocalRandom.current().nextDouble()));
            try { Thread.sleep(1000); } catch (InterruptedException ignored) { }
        }
    }
}

public classMain {
    public static void main(String[] args) {


        new Sensor().start(new Sensor.DataReceiver() {
            @Override
            public void receive(SensorData sensorData) {
                System.out.println("Saved "  + sensorData.sensorID + "," + sensorData.timestamp + "," + sensorData.value);
                SensorLogger.getInstance("data.log").logData(sensorData);
            }
        });
    }
}