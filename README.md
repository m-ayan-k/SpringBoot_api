# Cargo Management API

## Overview

This project implements a Cargo Management API using Spring Boot. The API provides endpoints for managing cargo loads, including retrieving, adding, updating, and deleting cargo information.

## API Endpoints

### 1. Get All Loads

**Endpoint:** `GET /loads`

**Description:** Retrieve a list of all cargo loads.

### 2. Get Load by Shipper ID

**Endpoint:** `GET /load`

**Parameters:**
- `shipperId` (String): Shipper ID for filtering cargo loads.

**Description:** Retrieve a list of cargo loads based on the provided Shipper ID.

### 3. Get Load by Load ID

**Endpoint:** `GET /load/{loadId}`

**Parameters:**
- `loadId` (String): Unique identifier for the cargo load.

**Description:** Retrieve detailed information about a cargo load using its unique Load ID.

### 4. Add Load

**Endpoint:** `POST /load`

**Request Body:** Cargo object in JSON format.

**Description:** Add a new cargo load to the system.

### 5. Delete Load

**Endpoint:** `DELETE /load/{loadId}`

**Parameters:**
- `loadId` (String): Unique identifier for the cargo load.

**Description:** Delete a cargo load based on its unique Load ID.

### 6. Update Load

**Endpoint:** `PUT /load/{loadId}`

**Parameters:**
- `loadId` (String): Unique identifier for the cargo load.
- Request Body: Updated Cargo object in JSON format.

**Description:** Update an existing cargo load with new information.

## Usage

To use this API, you can make HTTP requests to the specified endpoints using tools like `curl` or through your preferred programming language.

### Example

#### Get All Loads

```bash
curl -X GET http://localhost:8080/loads
```
## Run Locally on Windows

To run the Cargo Management API locally on a Windows environment, follow these steps:

### Prerequisites

1. **Java Development Kit (JDK):**
   - Ensure that you have Java Development Kit (JDK) installed on your machine. You can download it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html).

2. **Maven:**
   - Make sure you have Maven installed. You can download Maven from [the official Apache Maven website](https://maven.apache.org/download.cgi).

### Build and Run

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/m-ayan-k/SpringBoot_api.git
   ```
2. **Navigate to the Project Directory:**
   ```bash
   cd SpringBoot_api
   ```
3. **Build the Project:**
   ```bash
   mvn clean install
   ```
4. **Run the Application:**
   ```bash
   java -jar target/cargo-management-api.jar
   ```
The API will be accessible at http://localhost:8080.
