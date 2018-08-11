# mongoDBJava

(C) 2018 by [Damir Cavar](http://damir.cavar.me/)

This is a simple example of connecting to MongoDB and querying some data from some 
database.

This is tested with Java 10, the latest MongoDB release, etc.

Set up the database name, collection, and column label, compile and run.

To build:

    mvn compile package

To run the jar-file in the target folder with some command line parameters (strings 
to query in the MongoDB database):

    java -jar target/mongoDBQuery-1.0-SNAPSHOT.jar cats dogs

I use this to query word embeddings (word2vec vectors), keywords from knowledge graphs 
or ontologies, and so on.

The MongoDB library kept on changing in the past. This code should work with the latest release.
