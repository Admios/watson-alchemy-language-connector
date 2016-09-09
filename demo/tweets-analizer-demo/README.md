Tweets Analizer Demo
===========================

INTRODUCTION
------------
The Tweets Analizer Demo project offer one use case using this flow:

* **AnalyseTweetsBatch** - Use a batch that ingests tweets from the company twitter account and then extract their key concepts in order to get statistics about your social presence and save this data in a monitoring system.


HOW TO RUN DEMO
---------------

### Prerequisites
In order to build run this demo project you'll need;

* Anypoint Studio with Mule ESB 3.6 Runtime or higher.
* Watson AlchemyLanguage Connector v1.0.0 or higher.
* Mule Twitter Connector v4.0.0 or higher.
* Watson AlchemyLanguage api key from Bluemix.
* Twitter OAuth Credentials.

### Import the demo

With Anypoint Studio up and running, open the Import wizard from the File menu. A pop-up wizard will offer you the chance to pick Anypoint Studio Project from External Location. On the next wizard window point Project Root to the location of the demo project and select the Server Runtime as Mule Server 3.8.0 CE or EE. Once successfully imported the studio will automatically present the Mule Flows.

From the Package Explorer view, expand the demo project and open the mule-app.properties file. Fill in the api key of Watson and the credentials of Twitter.

### Test the flows

- **AnalyseTweetsBatch**

Run the demo project, the batch will start to retrieve tweets that constains the word "mulesoft" and will extract their key concepts, then it'll execute the flow **SaveDataInMonirotingSystem** to save the results if you choose to implement this flow. 

**Input**: It will search for new tweets automatically.

**Response**: You can see the results in the console.

```javascript
INFO  2016-08-31 14:09:36,843 [batch-job-AnalyseTweets-work-manager.01] org.mule.api.processor.LoggerMessageProcessor: {
  "concepts": [
    {
      "dbpedia": "http://dbpedia.org/resource/Peer-to-peer",
      "freebase": "http://rdf.freebase.com/ns/m.060b5",
      "relevance": 0.902865,
      "text": "Peer-to-peer"
    },
    {
      "dbpedia": "http://dbpedia.org/resource/Internet",
      "freebase": "http://rdf.freebase.com/ns/m.03rlt",
      "opencyc": "http://sw.opencyc.org/concept/Mx4rvVnZe5wpEbGdrcN5Y29ycA",
      "relevance": 0.87576,
      "text": "Internet"
    },
    {
      "dbpedia": "http://dbpedia.org/resource/Internet_of_Things",
      "freebase": "http://rdf.freebase.com/ns/m.02vnd10",
      "relevance": 0.852144,
      "text": "Internet of Things"
    }
  ],
  "language": "english"
}
```

SUMMARY
-------

Congratulations! You have imported the Tweets Analizer Demo project and used the Watson AlchemyLanguage Connector to extract valuable data from the tweets using natural language recognition. 
