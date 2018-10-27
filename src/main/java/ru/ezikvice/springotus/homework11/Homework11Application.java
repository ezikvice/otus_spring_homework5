package ru.ezikvice.springotus.homework11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Homework11Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework11Application.class);
    }

//    @Bean
//    public RouterFunction<ServerResponse> monoRouterFunction() {
//        HandlerFunction<ServerResponse> hello = request ->
//                ServerResponse.ok().body(fromPublisher(Flux.range(1, 10), Integer.class));
//        return route(GET("/hello"), hello);
//    }
}
