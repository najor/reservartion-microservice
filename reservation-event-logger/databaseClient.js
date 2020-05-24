const MongoClient = require('mongodb').MongoClient;

async function execute(callback) {
    const client = new MongoClient('mongodb://localhost:27017', {
        useNewUrlParser: true,
        useUnifiedTopology: true
    });

    client.connect();
    const db = client.db('reservation');
    return await callback(db).then((newEvent) => {
        console.log(newEvent);
        client.close();
        return newEvent;
    });
}

module.exports = {
    insert: async function (newEvent) {
        return execute(async db => {
            return db
                .collection('event')
                .insertOne(newEvent);
        });
    }
}