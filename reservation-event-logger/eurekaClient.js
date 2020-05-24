const Eureka = require('eureka-js-client').Eureka;

module.exports.createEurekaClient = (serverPort) => {
    return new Eureka({
                          instance: {
                              id: 'event-logger-service',
                              instanceId: `event-logger-service`,
                              app: `event-logger-service`,
                              vipAddress: `event-logger-service`,
                              hostName: `localhost`,
                              ipAddr: '127.0.0.1',
                              statusPageUrl: `http://localhost:${serverPort}/status`,
                              port: {
                                  '$': 8090,
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
}