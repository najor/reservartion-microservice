const express  = require('express');
const Eureka  = require('eureka-js-client').Eureka;


const app = express();
app.get('/hello', (req, res) => {
    res.send('Hello from NodeJS');
    res.end();
});

app.get('/', (req, res) => {
    res.json({info: 'Home'});
});

app.listen(8090, () => {
    console.log("user-service on 3000");
});

// example configuration
const client = new Eureka({
    // application instance information
    instance: {
        app: 'event-logger-service',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: {
            '$': 8080,
        },
        vipAddress: 'event.logger.service',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn',
        },
    },
    eureka: {
        // eureka server host / port
        host: '127.0.0.1',
        port: 8761,
        servicePath: '/eureka/apps/'
    },
});

client.start(error => {

});