# Trivia Question API

## Overview
A Trivia Question API that retrieves questions from https://opentdb.com/. 
It uses Java 21, Spring Boot 3.4.1, and integrates with [any other tools you're using, like Kafka, Docker, etc.].


## Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/markwaynedeclaro/question-api.git

2. Make sure you have installed/run docker on your machine.
####
3. Build the docker image:
   ```bash
   docker build -t question-api .

4. Run the docker container:
   ```bash
   docker run -d --name question-api-container -p 80:80 question-api 
   
5. Access http://localhost/v1/questions?amount=50&category=General%20Knowledge to test
####
6. Open http://localhost/swagger-ui/index.html to view the swagger page
####   



http://localhost/v1/questions?amount=50&category=General%20Knowledge will call
https://opentdb.com/api.php?amount=50&category=12&type=multiple