package br.com.apache_camel.Demo.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class LogRoute extends RouteBuilder {

    public final static String LOG_IN = "direct:log-in";
    public final static String LOG_OUT = "direct:log-out";


    @Override
    public void configure() {
        from(LOG_IN)
                .routeId(LOG_IN)
                .step("teste")
                .wireTap(LOG_OUT);

        from(LOG_OUT)
                .routeId(LOG_OUT)
                .step(LOG_OUT)
                .log(LoggingLevel.INFO, "Hello ${body}");


    }
}
