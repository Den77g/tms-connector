# TMS Connector

TMS Connector is an integration adapter written in Java that facilitates communication with external Transportation Management Systems (TMS). It allows you to create, send, and manage orders in a TMS environment, providing an easy and automated way to integrate transportation logistics with your existing systems.

## Features

- Create and manage transportation orders.
- Communicate with external TMS APIs using RESTful endpoints.
- Customizable scheduling for automatic order processing.
- Integration with various data sources to support order management.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA (Hibernate)
- Lombok
- SLF4J (Logging)
- REST APIs

## Prerequisites

- **Java 11** or higher
- **Maven** for dependency management and build
- **MySQL** or any compatible relational database

## Getting Started

1. **Clone the Repository**

   ```sh
   git clone https://github.com/Den77g/tms-connector.git
   cd tms-connector
   ```

2. **Configure the Database**

   Update the `application.properties` or `application.yml` file to include your database connection details:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tms_connector
   spring.datasource.username=your_database_user
   spring.datasource.password=your_database_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the Project**

   Use Maven to build the project:

   ```sh
   mvn clean install
   ```

4. **Run the Application**

   After successfully building the project, run the Spring Boot application:

   ```sh
   mvn spring-boot:run
   ```

5. **API Endpoints**

   - `POST /api/post-order`: Accepts an order and sends it to the external TMS.

   Example Request:
   ```json
   {
     "number": "123456",
     "status": "N",
     "transportType": "TENT",
     "carrier": "self-pickup",
     "market": "Domestic"
   }
   ```

## Scheduled Task

The application includes a scheduled task that checks the database every 5 minutes for new orders and sends them to the external TMS. You can modify the interval by changing the `@Scheduled` annotation in `ApiClientApplication`.

```java
@Scheduled(fixedRate = 300000) // Runs every 5 minutes
public void checkForOrders() {
    // Task logic here
}
```

## Logging

The application uses Lombok's `@Slf4j` annotation to add logging. Logs can be found in the console or configured to be saved in a file using Logback.

## Troubleshooting

- **Cannot Resolve Table 'entry_order'**: Ensure that the database is configured correctly, and the `entry_order` table exists. You can set `spring.jpa.hibernate.ddl-auto=update` to let Hibernate create the table automatically.

- **Database Connectivity Issues**: Verify that your database is running and that the credentials in `application.properties` are correct.

## Contributing

Feel free to submit issues or pull requests if you find bugs or want to add features. Contributions are welcome!

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact

For any questions or issues, please contact the repository owner at [your_email@example.com].

