**Overview**

This application is a web service that provides endpoints for the Charge Detail Records.




**Application**
Port-Adapter

The application was developed with Spring Boot. It consists of only one Java project that is run by Maven.

To ease the development of clients and manual testing, [Swagger](https://swagger.io/) was included:
http://localhost:8080/swagger-ui/



*Hexagonal architecture*

The application uses the [hexagon design pattern](https://en.wikipedia.org/wiki/Hexagonal_architecture_(software)).

"The hexagonal architecture divides a system into several loosely-coupled interchangeable components, such as the application core, the database, the user interface, test scripts and interfaces with other systems. This approach is an alternative to the traditional layered architecture."




**Database**

The are stored currently in an in-memory database ([H2](https://www.h2database.com/)). The database is started with the application.




**Test**

Integration tests for all endpoints are provided.

A few unit tests were created (for the sake of time other unit tests were omitted).




*Test Coverage*

| Package     | Class %    | Method %     | Line %       |

| ----------- | ---------- | ------------ | ------------ |

| config      | 100% (1/1) | 100%  (4/4)  | 100% (27/27) |

| controller  | 100% (1/1) | 100%  (4/4)  | 100% (13/13) |

| domain      | 100% (2/2) |  92% (12/13) |  92% (12/13) |

| dto         |  50% (1/2) |  63%  (7/11) |  63%  (7/11) |

| mapping     | 100% (1/1) | 100%  (3/3)  | 100% (18/18) |

| port        | 100% (0/0) | 100%  (0/0)  | 100%  (0/0)  |

| service     | 100% (4/4) |  93% (14/15) |  64% (32/50) |

| validation  | 100% (3/3) | 100%  (7/7)  |  85% (17/20) |




**Documentation**

Some classes are documented using Java doc comments.




**Bugs and open issues**

No bugs are known.

No issues are still open.

