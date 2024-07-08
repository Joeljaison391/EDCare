# EDCare

![EDCare Logo](https://via.placeholder.com/150?text=EDCare)

EDCare is an AI assistant that uses personalized storytelling to improve memory, cognitive function, and emotional
well-being in elderly individuals experiencing memory decline.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)
- [API Reference](#api-reference)
- [Acknowledgments](#acknowledgments)

## Overview

This project focuses on an AI-powered assistant designed to enhance the quality of life for elderly individuals through
personalized storytelling. The assistant aims to improve memory retention, cognitive function, and emotional well-being
by creating engaging and interactive story experiences tailored to the user's life and preferences.

## Features

### 1. Storyteller

- **Memoir Mode**: Generates stories based on the user's life experiences.
- **Interactive Mode**: Presents users with story puzzles or branching narratives.
- **Legacy Mode**: Assists users in creating a digital legacy.

### 2. Personalization Techniques

- Story Elements incorporation
- Mood Recognition and Adaptation
- Multisensory Integration

### 3. Cognitive Enhancement Features

- Gamified Storytelling
- AI-Powered Memory Exercises

### 4. Emotional Well-being Features

- Therapeutic Storytelling
- Multigenerational Storytelling

## Getting Started

### Prerequisites

- Java 21
- Maven
- MongoDB
- IBM Watson API credentials

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/edcare.git
   cd edcare
    ```

2. Install dependencies:

   ```sh
   mvn install
   ```

3. Set up MongoDB:
4. Set up IBM Watson API credentials:
5. Run the application:

   ```sh
   mvn spring-boot:run
   ```

application.properties looks like this:

```
spring.application.name=Companion
spring.data.mongodb.uri=mongodb://localhost:27017/edcare
watson.nlu.url=https://api.au-syd.natural-language-understanding.watson.cloud.ibm.com/instances/your-instance-id
watson.nlu.apikey=your-api-key
watson.cloud.apikey=your-cloud-api-key
```

### Usage

Analyze and store raw data:

```sh
curl -X POST http://localhost:8080/analyze \
-H "Content-Type: application/json" \
-d '{"userProfileId":"123","content":"Sample text to analyze"}'
```

Generate a story:

```sh
curl http://localhost:8080/story/generate/analysisResultId123
```

Create a user profile:

```sh
curl -X POST http://localhost:8080/api/userprofiles \
-H "Content-Type: application/json" \
-d '{"name":"John Doe","age":70,"interests":["gardening","reading"]}'
```

### API Reference

| Endpoint                           | Method | Description                                |
|------------------------------------|--------|--------------------------------------------|
| /analyze                           | POST   | Analyze and store raw data                 |
| /story/generate/{analysisResultId} | GET    | Generate a story based on analysis results |
| /api/userprofiles                  | POST   | Create a new user profile                  |
| /api/userprofiles                  | GET    | Get all user profiles                      |
| /api/userprofiles/{id}             | GET    | Get a user profile by ID                   |
| /api/userprofiles/{id}             | PUT    | Update a user profile                      |
| /api/userprofiles/{id}             | DELETE | Delete a user profile                      |

## Acknowledgments

IBM Watson for Natural Language Understanding ,
Spring Boot community ,
MongoDB,
Java 21

Made with ❤️ by Bits&Bytes