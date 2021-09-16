#!/usr/bin/env bash

# create all ecnounter kafka topics
arr=(
    "oneview-encounter-finalize-command"
    )
for i in "${arr[@]}"
do
   echo "creating $i"
   kafka-topics --zookeeper localhost:2181 --create --topic $i --partitions 1 --replication-factor 1 --config retention.ms=180000
done

# list all topics
kafka-topics --zookeeper localhost:2181 --list

# delete topic
#kafka-topics --zookeeperka localhost:2181 --delete --topic oneview-encounter-finalize-command