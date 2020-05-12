<h1>Microservices example</h1>
Techonoligies used:
<ul>
<li>Eureka server (netflix-eureka-server)</li>
<li>Eureka service (netflix-eureka-client)</li>
<li>Zuul balancer (netflix-zuul)</li>
<li>Node service (eureka-js-client)</li>
</ul>

This project is just an example of how to integrate several services from
different technologies and use a load balancer, so several instances of the same services can be run.

``./gradlew bootJar`` // It would create the jars and .sh need to run the application.

Go to ``.build`` folder

``java -jar reservation-eureka-server-0.0.1-SNAPSHOT.jar`` // starts the server

``java -jar reservation-zuul-balancer-0.0.1-SNAPSHOT.jar`` // starts the load balancer

``java -jar -Dserver.port=8097 reservation-eureka-service-0.0.1-SNAPSHOT.jar`` // starts one java micro-service

``java -jar -Dserver.port=8099 reservation-eureka-service-0.0.1-SNAPSHOT.jar`` // starts two java micro-service (to check zuul balancer)

``reservation-event-logger/npm install`` // install all the necessary libraries for node micro-service project

``reservation-event-logger/node index.js --port=8091`` // start the node micro-service

``reservation-event-logger/node index.js --port=8093`` // start second node micro-service (to test zuul balancer)

http://localhost:8761/ // Server should have started with 2 micro-service

``http://192.168.1.137:8762/logger/hello`` Refresh several time to check that zuul balancer is displaying a message where the port text is different each time

``http://192.168.1.137:8762/reservation/hello`` Refresh several time to check that zuul balancer is displaying a message where the port text is different each time

