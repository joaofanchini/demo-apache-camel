package br.com.apache_camel.Demo.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LogOutRoute extends RouteBuilder {

    public final static String LOG_OUT = "direct:log-out";

    @Override
    public void configure() throws Exception {
        from(LOG_OUT)
                .routeId(LOG_OUT)
                .step(LOG_OUT)
                .log(LoggingLevel.INFO, "Hello ${body}");
    }
}
