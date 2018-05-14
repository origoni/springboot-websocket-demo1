# springboot-websocket-demo1 [![Build Status](https://travis-ci.org/origoni/springboot-websocket-demo1.svg?branch=master)](https://travis-ci.org/origoni/springboot-websocket-demo1)

springboot websocket demo1


Tested
- STS(Eclipse) 3.8.4
- IntelliJ IDEA 2018.1.3

```
//@formatter:off & //@formatter:on
eclipse : Preferences -> Java -> Code style -> Formatter -> Edit... (or New...) > Off/On Tags
intellij : Preferences -> Editor -> Code Style > Formatter Control > Enable formatter markers in comments
```

## Quick Start

- JDK 1.8
- Maven 3.5
- Git

```
git clone https://github.com/origoni/springboot-websocket-demo1.git
cd springboot-websocket-demo1
mvn spring-boot:run
```


## Test

### echo
- http://localhost:8080/echo.html
- http://localhost:8080/echo-sockjs.html

### chatting
- http://localhost:8080/chat.html
- http://localhost:8080/chat-sockjs.html


## Dependency

### Spring Boot 2.0.2.RELEASE
- spring-boot-starter-web
- spring-boot-starter-websocket

- org.webjars.jquery
- org.webjars.popper.js
- org.webjars.bootstrap
- org.webjars.sockjs-client
