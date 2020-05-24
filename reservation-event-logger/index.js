const express = require('express');
const bodyParser = require('body-parser');
const {argv} = require('yargs')
const eurekaClient = require('./eurekaClient')
const databaseClient = require('./databaseClient')

const SERVER_PORT = argv.port;

const app = express();
app.use(bodyParser.json());

app.get('/status', (req, res) => {
    res.send(`Hello from NodeJS port: ${SERVER_PORT}`);
});

// Create new event
app.post('/event', (req, res) => {
    let {type, reservationId, name} = req.body;
    databaseClient.insert({type: type, reservationId: reservationId, name: name});
    console.log('new event inserted');
    res.statusCode = 200;
    res.end();
});

app.get('/', (req, res) => {
    res.json({info: 'Home'});
});

app.listen(SERVER_PORT, () => {
    console.log(`user-service on ${SERVER_PORT}`);
});

eurekaClient.createEurekaClient(SERVER_PORT).start(error => {
    if (error) {
        console.error(error);
    }
});