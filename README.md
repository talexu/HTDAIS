HTCAIS
======

Hot Topic Data Analysis and Identification System

Introduction
=
The project is a hot topic capture system which can crawl the topics from news website and social network from time to time and find the hottest topics for the user.

Architecture
=
The system consists of three components, a vertical search engine for crawling data, a data mining component for finding the hot topics and a website for user interaction respectively.

The mechanism of the system is that the vertical search engine crawl and push the data to the data mining component from time to time, the data mining component find the hot topics when it receives new data from search engine. Eventually, the user can get the hot topics (the result of data mining) via a website.

Implementation
=
Some open source projects are very useful for implementing the three components mentioned above (vertical search engine, data mining component, and website).

Vertical search engine

Nutch is an effort to build an open source web search engine based on Lucene and Java for the search and index component. Here is a video of a brief introduction and deployment of Nutch.

Stream data mining

MOA (Massive Online Analysis) is a free open-source software specific for mining data streams with concept drift. Here is a video about stream clustering.

Website

AngularJS is an open-source JavaScript framework, maintained by Google, that assists with running single-page applications. Its goal is to augment browser-based applications with model–view– controller (MVC) capability, in an effort to make both development and testing easier.
