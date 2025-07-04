# Transfers Service

This project contains a Spring Boot microservice that handles money transfers. It is part of a larger microservices-based application and communicates with other services asynchronously using Apache Kafka.

## Description

The Transfers Service exposes a REST API to initiate a money transfer between two accounts. When a transfer request is received, it publishes two events to Kafka topics: one for withdrawing money from the sender's account and another for depositing money into the recipient's account. The service uses Kafka's transactional capabilities to ensure that both events are published atomically, maintaining data consistency across the system.

## Features

*   **RESTful API:** A simple and intuitive API for initiating money transfers.
*   **Asynchronous Communication:** Uses Apache Kafka to communicate with other microservices, improving decoupling and resilience.
*   **Transactional Outbox Pattern:** Implements the transactional outbox pattern with Kafka to ensure reliable messaging.
*   **Idempotent Producer:** Configured as an idempotent producer to avoid message duplication.
*   **Service Discovery:** Can be integrated with a service discovery mechanism like Eureka (not included in this module).

## Technologies Used

*   **Java 17**
*   **Spring Boot 3.2.3**
*   **Spring Web**
*   **Spring for Apache Kafka**
*   **Maven**

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

*   Java 17 or higher
*   Maven 3.2+
*   Apache Kafka instance running on `localhost:9092`
*   Git

### Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/kafka_microservice_application.git
    cd kafka_microservice_application/TransferService
    ```

2.  **Build the project:**
    ```bash
    mvn clean install
    ```

## API Endpoints

The service exposes the following REST endpoint:

*   **POST /transfers**

    Initiates a money transfer.

    **Request Body:**

    ```json
    {
        "senderId": "e9d8c7b0-a6b3-4b0f-8b5d-3c1e8a6f9b2a",
        "recepientId": "f8a7b6c5-d4e3-2b1a-0f9e-8d7c6b5a4f3e",
        "amount": 100.00
    }
    ```

    **Response:**

    Returns `true` if the transfer events were successfully published to Kafka, `false` or an error response otherwise.

## Configuration

The main configuration is located in the `src/main/resources/application.properties` file.

| Property                                       | Description                                                              | Default Value                  |
| ---------------------------------------------- | ------------------------------------------------------------------------ | ------------------------------ |
| `server.port`                                  | Server port (0 means a random available port)                            | `0`                            |
| `spring.kafka.producer.bootstrap-servers`      | Comma-separated list of Kafka broker addresses                           | `localhost:9092`               |
| `spring.kafka.producer.key-serializer`         | Serializer class for the key                                             | `StringSerializer`             |
| `spring.kafka.producer.value-serializer`       | Serializer class for the value                                           | `JsonSerializer`               |
| `spring.kafka.producer.acks`                   | The number of acknowledgments the producer requires                      | `all`                          |
| `spring.kafka.producer.properties.enable.idempotence` | When set to `true`, the producer will ensure that messages are not duplicated. | `true`                         |
| `withdraw-money-topic`                         | The name of the topic for withdrawal events                              | `withdraw-money-topic`         |
| `deposit-money-topic`                          | The name of the topic for deposit events                                 | `deposit-money-topic`          |

## Running the application

You can run the application using the following Maven command:

```bash
mvn spring-boot:run
```

## How to run tests

To run the automated tests for this project, use the following command:

```bash
mvn test
```