Watson AlchemyLanguage Connector Demo
===========================

INTRODUCTION
------------
The Watson AlchemyLanguage connector demo project offer three use cases using this three main flows:

* **GetCombinedResultsFlow** - Provides an example on how to get combined results from several methods in just one call.
* **PostIssueOnSupportSystemFlow** - Show the modernization of a legacy support system, preprocessing the customer request with Watson to classify it and add valuable information before it’s created in the support system.
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

- **GetCombinedResultsFlow**


Run the demo project and in the browser hit - **http://localhost:8081/get-entities?source=[TEXT_OR_URL]**:

**Input**: http://localhost:8081/get-entities?source=google.com

**Response**: The result would be a list of all the concepts, entities, keywords and taxonomy detected in the text or webpage.
```javascript
{
  "totalTransactions": 4,
  "language": "english",
  "url": "",
  "author": null,
  "concepts": [],
  "entities": [],
  "feeds": null,
  "image": null,
  "imageKeywords": null,
  "keywords": [
    {
      "totalTransactions": null,
      "language": null,
      "url": null,
      "knowledgeGraph": null,
      "relevance": 0.939805,
      "sentiment": null,
      "text": "google.com"
    }
  ],
  "publicationDate": null,
  "relations": null,
  "sentiment": null,
  "taxonomy": [
    {
      "confident": true,
      "label": "/technology and computing/internet technology/web search",
      "score": 1
    },
    {
      "confident": false,
      "label": "/business and industrial",
      "score": 0.0000945224
    },
    {
      "confident": false,
      "label": "/business and industrial/advertising and marketing/advertising",
      "score": 0.0000276226
    }
  ],
  "title": null
}
```

**Input**: http://localhost:8081/get-entities?source=IBM Watson won the Jeopardy television show hosted by Alex Trebek


**Response**:

```javascript
{
  "totalTransactions": 4,
  "language": "english",
  "url": "",
  "author": null,
  "concepts": [
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Alex_Trebek",
      "freebase": "http://rdf.freebase.com/ns/m.01tbdb",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.971964,
      "text": "Alex Trebek",
      "website": null,
      "yago": "http://yago-knowledge.org/resource/Alex_Trebek"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Daytime_Emmy_Award_for_Outstanding_Game_Show_Host",
      "freebase": "http://rdf.freebase.com/ns/m.02vm9bf",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.86867,
      "text": "Daytime Emmy Award for Outstanding Game Show Host",
      "website": "http://www.emmyonline.org",
      "yago": null
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Jeopardy!",
      "freebase": "http://rdf.freebase.com/ns/m.014l6l",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.856032,
      "text": "Jeopardy!",
      "website": "http://www.jeopardy.com/",
      "yago": "http://yago-knowledge.org/resource/Jeopardy!"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Celebrity_Jeopardy!_(Saturday_Night_Live)",
      "freebase": "http://rdf.freebase.com/ns/m.06c852",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.784932,
      "text": "Celebrity Jeopardy!",
      "website": null,
      "yago": "http://yago-knowledge.org/resource/Celebrity_Jeopardy!_(Saturday_Night_Live)"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Super_Jeopardy!",
      "freebase": null,
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.725536,
      "text": "Super Jeopardy!",
      "website": null,
      "yago": "http://yago-knowledge.org/resource/Super_Jeopardy!"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Art_Fleming",
      "freebase": "http://rdf.freebase.com/ns/m.0684qh",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.695109,
      "text": "Art Fleming",
      "website": null,
      "yago": "http://yago-knowledge.org/resource/Art_Fleming"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Bob_Barker",
      "freebase": "http://rdf.freebase.com/ns/m.01ydhd",
      "geo": null,
      "geonames": null,
      "opencyc": "http://sw.opencyc.org/concept/Mx4rvnTZ6JwpEbGdrcN5Y29ycA",
      "relevance": 0.678699,
      "text": "Bob Barker",
      "website": null,
      "yago": "http://yago-knowledge.org/resource/Bob_Barker"
    },
    {
      "census": null,
      "ciaFactbook": null,
      "crunchbase": null,
      "dbpedia": "http://dbpedia.org/resource/Jeopardy!_Teen_Tournament",
      "freebase": "http://rdf.freebase.com/ns/m.0dt9v3",
      "geo": null,
      "geonames": null,
      "opencyc": null,
      "relevance": 0.673602,
      "text": "Jeopardy! Teen Tournament",
      "website": "http://www.jeopardy.com",
      "yago": null
    }
  ],
  "entities": [
    {
      "totalTransactions": null,
      "count": 1,
      "disambiguated": null,
      "knowledgeGraph": null,
      "quotations": null,
      "relevance": 0.33,
      "sentiment": null,
      "text": "IBM Watson",
      "type": "Company"
    },
    {
      "totalTransactions": null,
      "count": 1,
      "disambiguated": {
        "census": null,
        "ciaFactbook": null,
        "crunchbase": null,
        "dbpedia": "http://dbpedia.org/resource/Alex_Trebek",
        "freebase": "http://rdf.freebase.com/ns/m.01tbdb",
        "geo": null,
        "geonames": null,
        "musicBrainz": null,
        "name": "Alex Trebek",
        "opencyc": null,
        "subType": [
          "Actor",
          "FilmActor",
          "TVActor"
        ],
        "umbel": null,
        "website": null,
        "yago": "http://yago-knowledge.org/resource/Alex_Trebek"
      },
      "knowledgeGraph": null,
      "quotations": null,
      "relevance": 0.33,
      "sentiment": null,
      "text": "Alex Trebek",
      "type": "Person"
    }
  ],
  "feeds": null,
  "image": null,
  "imageKeywords": null,
  "keywords": [
    {
      "totalTransactions": null,
      "language": null,
      "url": null,
      "knowledgeGraph": null,
      "relevance": 0.994805,
      "sentiment": null,
      "text": "Jeopardy television"
    },
    {
      "totalTransactions": null,
      "language": null,
      "url": null,
      "knowledgeGraph": null,
      "relevance": 0.929663,
      "sentiment": null,
      "text": "IBM Watson"
    },
    {
      "totalTransactions": null,
      "language": null,
      "url": null,
      "knowledgeGraph": null,
      "relevance": 0.854049,
      "sentiment": null,
      "text": "Alex Trebek"
    }
  ],
  "publicationDate": null,
  "relations": null,
  "sentiment": null,
  "taxonomy": [
    {
      "confident": true,
      "label": "/art and entertainment/movies and tv/television",
      "score": 0.99927
    },
    {
      "confident": false,
      "label": "/hobbies and interests/games/board games and puzzles",
      "score": 0.0122076
    },
    {
      "confident": false,
      "label": "/technology and computing/computer security/antivirus and malware",
      "score": 0.0100335
    }
  ],
  "title": null
}
```

- **PostIssueOnSupportSystemFlow**

Run the demo project and do a POST requesto to **http://localhost:8081/issue?user=[USERNAME]&description=[DESCRIPTION]**:

**Input**: POST - http://localhost:8081/issue?user=test&description=IBM Watson is a great tool for text recongnition

**Response**: The result would be a list of all the entities, keywords and the sentiment detected in the description, you can change the **Generate Response** and implement the flow **CreateNewTickectInSupportSystem** to save the response in a external system.
```javascript
{
  "description": "IBM Watson is a great tool for text recongnition",
  "sentiment": "POSITIVE",
  "user": "test",
  "keywords": [
    {
      "sentiment": {
        "mixed": null,
        "type": "POSITIVE",
        "score": 0.7915
      },
      "totalTransactions": null,
      "language": null,
      "relevance": 0.912319,
      "url": null,
      "knowledgeGraph": null,
      "text": "IBM Watson"
    },
    {
      "sentiment": {
        "mixed": null,
        "type": "POSITIVE",
        "score": 0.7915
      },
      "totalTransactions": null,
      "language": null,
      "relevance": 0.755268,
      "url": null,
      "knowledgeGraph": null,
      "text": "great tool"
    },
    {
      "sentiment": {
        "mixed": null,
        "type": "POSITIVE",
        "score": 0.7915
      },
      "totalTransactions": null,
      "language": null,
      "relevance": 0.742875,
      "url": null,
      "knowledgeGraph": null,
      "text": "text recongnition"
    }
  ],
  "entities": [
    {
      "sentiment": {
        "mixed": null,
        "type": "POSITIVE",
        "score": 0.7915
      },
      "totalTransactions": null,
      "disambiguated": null,
      "quotations": null,
      "count": 2,
      "type": "Company",
      "relevance": 0.33,
      "knowledgeGraph": null,
      "text": "IBM Watson"
    }
  ]
}
```
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

Congratulations! You have imported the Watson AlchemyLanguage Demo project and used the Watson AlchemyLanguage Connector to extract valuable data from a source using natural language. 
