# OakLand-v1-be
The backend api for an online store for furnitures

`Built with Spring Boot, secured with Spring Security (JWT), documented with Swagger (API),
containerized with Docker, deployed on Heroku.`

## Technology ##
Following tools and libraries were used during the development of the API :
- **Java 11**
- **Spring Boot**
- **Build Tool: Maven**
- **PostgreSQL**
- **Swagger**
- **JWT**
- **Docker**

## Database Schema ##
<img src="/Users/decagon/Documents/Decagon Directory/Live Project/OakLand-v1-be/src/main/resources/OakLand-v1-be ER Diagram.png"/>


## Running the server locally ##
* **Clone the repository:** git clone https://github.com/musty-codified/Oakland-v1-be.git
* **Build the project using maven:** mvn clean install
* **Run the application:** mvn spring-boot:run


## Running the server in a Docker Container ##
* Simply download the [Docker compose file](https://github.com/musty-codified/Oakland-v1-be/blob/main/docker-compose.yml)
* You can edit the file to your custom configurations
* Then navigate to where the file is located on your terminal and run 'docker compose up'
* Voilà! once the image downloads are completed and the application is running, you can then visit http://localhost:8080/swagger-ui/index.html to access the end points


### Support
For any issues or queries, please raise a ticket on the GitHub repository or email me on ilemonamustapha@@gmail.com.









