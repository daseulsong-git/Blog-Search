# Blog Search Service

This is a Search Service for blog. It is used with Kakao Open API.

플젝 관련 정리 내용 (https://www.notion.so/ing-8a52b2e780fe41d7a223876af46b285d)
.. 추후 README 추가 예정

## Features
1) Search blogs with sorting(accuracy, recency). It shows 20 rows in one page.
2) View top 10 of keywords that you seasrched.

## Prerequisites and Execution

To run the Spring Boot Project, follow these steps :

### Prerequisites
- spring boot 2.4.1
- Java 11
- Redis 2.4.3
- lombok (compileOnly)
- gradle 7.6

### Build and Run
1. Clone the repository: ```bash git clone https://github.com/daseulsong-git/Blog-Search.git```
2. Navigate to the Project Directory : ```cd Blog-Search``` 
3. Build the project using Gradle: ```./gradlew build ```
4. Run the Application : ```./gradlew bootRun```

▶ Execution using JAR file
1. Download   [Blog-Search-0.0.1-SNAPSHOT.jar](https://github.com/daseulsong-git/Blog-Search/blob/master/Blog-Search-0.0.1-SNAPSHOT.jar)
2. Execute the JAR File : ``java -jar Blog-Search-0.0.1-SNAPSHOT.jar```

## Technologies Used

 - Gradle 7.6, Spring Boot 2.4.1, JPA, H2(Embedded), Redis 2.4.3, lombok, Thymleaf ...

## Issues

## Execution
