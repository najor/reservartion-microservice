const express = require('express');
const {argv} = require('yargs')
const Eureka = require('eureka-js-client').Eureka;

const SERVER_PORT = argv.port;

const app = express();
app.get('/hello', (req, res) => {
    res.send(`Hello from NodeJS port: ${SERVER_PORT}`);
    res.end();
});

app.get('/', (req, res) => {
    res.json({info: 'Home'});
});

app.listen(SERVER_PORT, () => {
    console.log(`user-service on ${SERVER_PORT}`);
});

// example configuration
const client = new Eureka({
                              instance: {
                                  id: 'event-logger-service',
                                  instanceId: `event-logger-service:${SERVER_PORT}`,
                                  app: `event-logger-service`,
                                  vipAddress: `event-logger-service`,
                                  hostName: `localhost:${SERVER_PORT}`,
                                  ipAddr: '127.0.0.1',
                                  statusPageUrl: `http://localhost:${SERVER_PORT}`,
                                  port: {
                                      '$': 0,
                                      '@enabled': 'true',
                                  },
                                  dataCenterInfo: {
                                      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
                                      name: 'MyOwn',
                                  }
                              },
                              eureka: {
                                  // host: 'localhost',
                                  // port: 8761,
                                  // servicePath: '/eureka/apps/',
                                  preferIpAddress: true,
                                  serviceUrls: {
                                      default: [
                                          'http://localhost:8761/eureka/apps'
                                      ]
                                  }
                              }
                          });

client.start(error => {
    if (error) {
        console.error(error);
    }
});