Hyperjaxb
==================

I used Hyperjaxb to create java objects of the persistence layer. 

Firstly export the schema of mysql database via xmlspy. Then I used Hyperjaxb to automatically generate hyperjaxb objects based on the schema. Besides the schema's aunotation, hyperjaxb objects also has jpa's anotaion so that it can be used as the persistence objects, which can be used by hibernate.

So SOAP receiver will be easier and more extensible to return XML-fomatted document with the resulting data. 

==================



