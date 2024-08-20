package br.com.apache_camel.Demo.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServiceRoute extends RouteBuilder {


    public static final String SERVICE = "direct:service";

    @Override
    public void configure() throws Exception {
        interceptSendToEndpoint("http*")
                .to(LogRoute.LOG_IN)
                .afterUri(LogRoute.LOG_OUT);

        from(SERVICE)
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .to("https://httpbin.org/get" + "?bridgeEndpoint=true");
    }
}
