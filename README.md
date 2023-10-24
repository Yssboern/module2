
```
curl -X POST -H "Content-Type: application/json" -d 'tst message' http://localhost:8080/kafka/publish
```


# Avro part (3 point)
In this task, you need to create a Kafka producer and consumer using Avro to serialize messages.

* Create a simple Kafka producer that sends a simple message to a topic serializing it using Avro.
* Create a simple Kafka consumer which listens to a topic for a message, deserializes the message, and prints it.
 
Start Kafka, create a topic, and run consumer and producer.
Try to use different Avro schemas for serialization and deserialization. 
Include Avro schema version/id into the massage so a client can understand which schema to use.

When practical task is implemented and ready for verification please upload an archive (jar, zip) with resources to the Result field and submit the results.

