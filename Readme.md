### Market Price Handler Exercise

**Application consist of next modules:**

- **subscriber** - the main service for doing business logic according to the task (listens the topic of kafka, does some action on
  messages, and sends results to the client)
- **producer** - the service for convenient work with kafka using rest endpoint for publishing messages into the quest
- **client** - according to the task, just rest endpoint with takes prices and stores them (in order to have the ability to test the flow)
- **test** - contains just simple test class, when we can run test and check the whole flow
- **scripts** - contains docker-compose file with all configuration for launching kafka and all services needed

##### To launch fully operated application - Docker is required to be installed on a machine

##### How to test:

1. go to `scripts` folder and run `./start` bash script
2. go to `test` and find `FlowTest.java`, then launch `testTheFlow` test (if test is green, app is functioning well, also you can check logs
   for the test results)
3. to stop app, run `docker-compose down`
