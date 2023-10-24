# Usage:

* run springboot app:
 * ```
   mvn clean install -U
   mvn spring-boot:run
   ``` 
* to test simple message producer/consumer:
 * ```
   curl -X POST -H "Content-Type: application/json" -d 'tst message' http://localhost:8080/api/simple
   ```

* to test avro producer/consumer:
 * ```
   curl -X POST -H "Content-Type: application/json" -d '{"name": "John Doe",  "age": 30, "email": "blep@blap.xom"}' http://localhost:8080/api/user
   ```

expected results in app terminal:
* ```
  Simple consumer consumed: tst message
  Simple consumer consumed: {"message": "test msg"}
  Avro producer send: {"name": "John Doe", "age": 30}
  Avro Consumer consumed: {"name": "John Doe", "age": 30}
  ```

# Avro part (3 point)
In this task, you need to create a Kafka avroProducer and consumer using Avro to serialize messages.

* Create a simple Kafka avroProducer that sends a simple message to a topic serializing it using Avro.
* Create a simple Kafka consumer which listens to a topic for a message, deserializes the message, and prints it.
 
Start Kafka, create a topic, and run consumer and avroProducer.
* Try to use different Avro schemas for serialization and deserialization. 
  *Include Avro schema version/id into the massage so a client can understand which schema to use.
