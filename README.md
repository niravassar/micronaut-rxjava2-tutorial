# micronaut-rxjava2-tutorial

## Summary 

This tutorial was created for developers who are interested in gaining a basic and fundamental understanding of RxJava 2.
Micronaut is built with RxJava 2 and is designed to support reactive APIs and streams. These concepts were largely unfamiliar to me. 
Whenever I ran into it, I mainly fumbled through with the limited knowledge I had, only armed with some predefined concepts. 
In the cases where some piece of code made no sense at all, I would quickly google examples and hack my way through the syntax, not really taking the time to 
understand the underlying concepts.  I realize this approach could only take me so far. Maybe other java developers have experienced the same situation.

What helped me is that I took a few days to buckle down and study Reactive and RxJava concepts form the ground up. This has given me a solid fundamental
understanding of why and how reactive programming is used. 

I used the following approach:

    - read articles
    - digest the content while taking notes
    - after a particular article, code the examples myself without looking at the code, but referring to the article concepts.
    - watch a few tutorial videos
    - when encountering a code example, watch it thoroughly all the way through without coding. After the example is done, pause
    and code it myself as best as possible. Only refer back to the video if totally lost. 
    - finally, I found a udemy.com free course, from which I applied the described approach above.
    
## Tutorial Approach

The approach taken in this tutorial is to identify some good references I found while researching. Subsequently, then use this micronaut
project as a sandlot area for coding examples. 

As a reference I included my own sandlot examples. I created a package under the `/test` folder in a package named `nirav.rxjava2.examples`. 
In this area, I just place whatever code snippets I tried out along the way. I found it easy to execute in a spock environment
with all the packaged up dependencies of micronaut included. Coding in a micronaut application also offers a fast track path to 
apply other micronaut features. 

I have structured this tutorial to begin with understanding concepts and terms. For each section I recommend taking notes and coding samples.

# RxJava Tutorial

## Concept Videos

Watch these videos to grasp `Observer` and `Observable` concepts

- https://www.youtube.com/watch?v=hSvFU74ZG7M
- https://www.youtube.com/watch?v=hzaq64zh0K4
- take notes and repeat any coding examples

## Essential Articles

- Vogella RxJava2
    - Read all the way through and stop at section 7
    - Take notes and repeat the coding examples
    - https://www.vogella.com/tutorials/RxJava/article.html
    
- Baeldung RxJava
    - Read all the way through in its entirety
    - Take notes and repeat the coding examples
    - https://www.baeldung.com/rx-java
    
## Udemy Course

- Registration is free
- Go through the course 
- Essential sections on Section 1 to 6
- Take notes and after each section do the coding examples on your own
- https://www.udemy.com/course/rxjava_2/

## Micronaut and RxJava

- Read the article and attempt to incorporate reactive programming into client calls from controllers
- https://piotrminkowski.com/2019/11/12/micronaut-tutorial-reactive/
