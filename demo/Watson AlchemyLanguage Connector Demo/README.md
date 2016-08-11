Watson AlchemyLanguage Connector Demo
===========================

INTRODUCTION
------------
The Watson AlchemyLanguage connector demo project consists of the two flows:

* Get_Entities_Flow - Provides an example on how to extract the entities from a source (text, HTML, webpage).
* Get_Combined_Results_Flow - Provides an example on how to get combined results from several methods in just one call.

HOW TO RUN DEMO
---------------

### Prerequisites
In order to build run this demo project you'll need;

* Anypoint Studio with Mule ESB 3.5 Runtime or higher.
* Watson AlchemyLanguage Connector v1.0.0 or higher.
* Watson AlchemyLanguage api key from Bluemix.

### Test the flows

With Anypoint Studio up and running, open the Import wizard from the File menu. A pop-up wizard will offer you the chance to pick Anypoint Studio Project from External Location. On the next wizard window point Project Root to the location of the demo project and select the Server Runtime as Mule Server 3.8.0 CE or EE. Once successfully imported the studio will automatically present the Mule Flows.

From the Package Explorer view, expand the demo project and open the mule-app.properties file. Fill in the api key of Watson.

Get_Entities_Flow : Run the demo project and with in the browser hit - **http://localhost:8081/get-entities?source=[TEXT_OR_URL]**, The result would be a list of all the entities detected in the text or webpage.

Get_Combined_Results_Flow : In the browser hit - **http://localhost:8081/get-combined-results?source=[TEXT_OR_URL]**, The result would be a list of all the concepts, entities, keywords and taxonomy detected in the text or webpage.


SUMMARY
-------

Congratulations! You have imported the Watson AlchemyLanguage Demo project and used the Watson AlchemyLanguage Connector to extract valuable data from a source using natural language. 