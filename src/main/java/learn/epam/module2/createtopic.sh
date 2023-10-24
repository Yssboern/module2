#~/kafka/bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

#~/kafka/bin/kafka-server-start.sh ~/kafka/config/server.properties
#bin/kafka-server-start.sh ~/kafka/config/server.properties


#~/kafka/bin/kafka-topics.sh --list --bootstrap-server localhost:9092

#KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
#xpv43OY9T_mCHzxwW33boA
#KAFKA_CLUSTER_ID="$(bin/kafka-storage.sh random-uuid)"
#echo $KAFKA_CLUSTER_ID
./bin/kafka-storage.sh format -t $KAFKA_CLUSTER_ID -c config/kraft/server.properties

./bin/kafka-topics.sh --create --topic blep --bootstrap-server localhost:9092

export CONFLUENT_HOME=~/confluent-7.5.1
export PATH=$PATH:$CONFLUENT_HOME/bin
