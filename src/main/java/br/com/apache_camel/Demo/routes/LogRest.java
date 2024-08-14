package br.com.apache_camel.Demo.routes;

import br.com.apache_camel.Demo.request.LogRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class LogRest extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .contextPath("/rest")
                .bindingMode(RestBindingMode.auto)
                .port(8081);

        rest("/log")
                .post()
                .routeId("rest-log")
                .type(LogRequest.class)
                .consumes("application/json")
                .to(LogRoute.LOG_IN);
    }
}
