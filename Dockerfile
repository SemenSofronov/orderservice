From java:8
expose 8081
add /target/orderservice-0.0.1-SNAPSHOT.jar orderservice-0.0.1-SNAPSHOT.jar
entrypoint ["java","-jar","orderservice-0.0.1-SNAPSHOT.jar"]