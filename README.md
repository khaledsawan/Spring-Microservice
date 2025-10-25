# Spring Microservices Architecture

A comprehensive Spring Boot microservices project implementing a complete business ecosystem with API Gateway, Service Registry, and multiple domain-specific services.

## 🏗️ Architecture Overview

This project demonstrates a modern microservices architecture using Spring Boot 3.0.2 and Spring Cloud, featuring:

- **API Gateway** with circuit breaker patterns
- **Service Registry** using Netflix Eureka
- **Multiple Business Services** with MySQL integration
- **Inter-service Communication** with RestTemplate
- **Resilience Patterns** for fault tolerance

## 🚀 Services

### Core Infrastructure

- **`service-registry`** - Netflix Eureka Server for service discovery
- **`cloud-gateway`** - Spring Cloud Gateway with circuit breaker patterns

### Business Services

- **`company-service`** - Company management (CRUD operations)
- **`customer-service`** - Customer management with external API integration
- **`transaction-service`** - Transaction processing with customer service integration
- **`sale-service`** - Sales management and tracking
- **`listing-service`** - Product/service listing management
- **`submission-service`** - Submission handling and processing

## 🛠️ Technology Stack

- **Java 17**
- **Spring Boot 3.0.2**
- **Spring Cloud 2022.0.1**
- **Spring Cloud Gateway**
- **Netflix Eureka**
- **Spring Data JPA**
- **MySQL Database**
- **Lombok**
- **Maven**

## 📋 Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL Database
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd Spring-Microservice
```

### 2. Database Setup

Create a MySQL database and update the connection properties in each service's `application.properties` file.

### 3. Start Services (in order)

#### Start Service Registry

```bash
cd service-registry
./mvnw spring-boot:run
```

Service Registry will be available at: `http://localhost:8761`

#### Start Business Services

```bash
# Company Service
cd company-service
./mvnw spring-boot:run

# Customer Service
cd customer-service
./mvnw spring-boot:run

# Transaction Service
cd transaction-service
./mvnw spring-boot:run

# Sale Service
cd sale-service
./mvnw spring-boot:run

# Listing Service
cd listing-service
./mvnw spring-boot:run

# Submission Service
cd submission-service
./mvnw spring-boot:run
```

#### Start API Gateway

```bash
cd cloud-gateway
./mvnw spring-boot:run
```

API Gateway will be available at: `http://localhost:8080`

## 📡 API Endpoints

All services are accessible through the API Gateway at `http://localhost:8080`:

### Company Service

- `GET /company` - Get all companies
- `GET /company/{id}` - Get company by ID
- `POST /company` - Create new company

### Customer Service

- `GET /customer` - Get all customers
- `GET /customer/{id}` - Get customer by ID
- `POST /customer` - Create new customer

### Transaction Service

- `GET /transaction` - Get all transactions
- `GET /transaction/{id}` - Get transaction by ID
- `GET /transaction/seller/{sellerId}` - Get transactions by seller
- `GET /transaction/customer/{customerId}` - Get customer details
- `POST /transaction` - Create new transaction

### Sale Service

- `GET /sale` - Get all sales
- `GET /sale/{id}` - Get sale by ID
- `GET /sale/company/{companyId}` - Get sales by company
- `GET /sale/consumer/{consumerId}` - Get sales by consumer
- `POST /sale` - Create new sale

### Listing Service

- `GET /listing` - Get all listings
- `GET /listing/{id}` - Get listing by ID
- `GET /listing/seller/{sellerId}` - Get listings by seller
- `GET /listing/buyer/{buyerId}` - Get listings by buyer
- `POST /listing` - Create new listing

### Submission Service

- `GET /submission` - Get all submissions
- `GET /submission/{id}` - Get submission by ID
- `GET /submission/seller/{sellerId}` - Get submissions by seller
- `GET /submission/buyer/{buyerId}` - Get submissions by buyer
- `POST /submission` - Create new submission

## 🔧 Configuration

### Service Ports

- Service Registry: `8761`
- API Gateway: `8080`
- Company Service: `8081`
- Customer Service: `8082`
- Transaction Service: `8083`
- Sale Service: `8084`
- Listing Service: `8085`
- Submission Service: `8086`

### Circuit Breaker Configuration

The API Gateway implements circuit breaker patterns for all services with fallback mechanisms to handle service failures gracefully.

## 📊 Monitoring

- **Eureka Dashboard**: `http://localhost:8761` - View registered services
- **API Gateway**: `http://localhost:8080` - Centralized API access point

## 🧪 Testing

Each service includes comprehensive test suites. Run tests using:

```bash
cd <service-name>
./mvnw test
```

## 📁 Project Structure

```
Spring-Microservice/
├── cloud-gateway/          # API Gateway with routing and circuit breakers
├── company-service/        # Company management service
├── customer-service/       # Customer management service
├── listing-service/        # Listing management service
├── sale-service/          # Sales management service
├── service-registry/       # Eureka service registry
├── submission-service/     # Submission handling service
├── transaction-service/    # Transaction processing service
├── MicroService.postman_collection.json  # API testing collection
└── README.md
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🎯 Features

- ✅ Microservices Architecture
- ✅ Service Discovery with Eureka
- ✅ API Gateway with Load Balancing
- ✅ Circuit Breaker Patterns
- ✅ Database Integration (MySQL)
- ✅ RESTful APIs
- ✅ CORS Support
- ✅ Comprehensive Error Handling
- ✅ Postman Collection for Testing
