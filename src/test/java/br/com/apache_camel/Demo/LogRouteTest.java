package br.com.apache_camel.Demo;

import br.com.apache_camel.Demo.routes.LogOutRoute;
import br.com.apache_camel.Demo.routes.LogRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.AdviceWith;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener;

@CamelSpringBootTest
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LogRouteTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject("mock:result")
    private MockEndpoint mockResult;

    @BeforeEach
    public void setUp() throws Exception {
        MockEndpoint.resetMocks(camelContext);
    }

    @Test
    public void testLogRoute() throws Exception {
        AdviceWith.adviceWith(camelContext, LogOutRoute.LOG_OUT, c->c.weaveAddFirst().to(mockResult));

        // Configurar o MockEndpoint
        mockResult.expectedMessageCount(1);
        mockResult.expectedBodiesReceived("Test Message");

        // Enviar uma mensagem para a rota LOG_IN
        camelContext.createFluentProducerTemplate().to(LogRoute.LOG_IN)
                .withBody("Test Message")
                .send();

        // Validar se a mensagem foi recebida corretamente
        mockResult.assertIsSatisfied();
    }

    @Test
    public void testLogRoute2() throws Exception {
        AdviceWith.adviceWith(camelContext, LogOutRoute.LOG_OUT, c->c.weaveAddFirst().to(mockResult));

        // Configurar o MockEndpoint
        mockResult.expectedMessageCount(1);
        mockResult.expectedBodiesReceived("Test Message 2");

        // Enviar uma mensagem para a rota LOG_IN
        camelContext.createFluentProducerTemplate().to(LogRoute.LOG_IN)
                .withBody("Test Message 2")
                .send();

        // Validar se a mensagem foi recebida corretamente
        mockResult.assertIsSatisfied();
    }
}
