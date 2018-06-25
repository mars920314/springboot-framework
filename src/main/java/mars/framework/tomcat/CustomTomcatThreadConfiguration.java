package mars.framework.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ningchunlei on 2015/1/27.
 */
@Configuration
public class CustomTomcatThreadConfiguration {

    @Value("${tomcat.maxThreads:300}")
    int maxThreads;

    @Value("${tomcat.minSpareThreads:20}")
    int minSpareThreads;

    @Value("${tomcat.backlog:1000}")
    int backlog;

    @Value("${tomcat.keepAliveTimeout:60000}")
    int keepAliveTimeout;

    @Value("${tomcat.maxKeepAliveRequests:500}")
    int maxKeepAliveRequests;

    @Bean
    EmbeddedServletContainerCustomizer embeddedServletContainerCustomizerThreadConfig() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer factory) {
                if (factory instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory tomcatFactory = (TomcatEmbeddedServletContainerFactory)
                                                                                  factory;
                    tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
                        @Override
                        public void customize(Connector connector) {
                            ((Http11NioProtocol) connector.getProtocolHandler()).setMaxThreads(maxThreads);
                            ((Http11NioProtocol) connector.getProtocolHandler()).setMinSpareThreads(maxThreads);
                            ((Http11NioProtocol) connector.getProtocolHandler()).setBacklog(backlog);
                            ((Http11NioProtocol) connector.getProtocolHandler()).setKeepAliveTimeout(keepAliveTimeout);
                            ((Http11NioProtocol) connector.getProtocolHandler())
                                    .setMaxKeepAliveRequests(maxKeepAliveRequests);
                        }
                    });
                }
            }
        };
    }

}
