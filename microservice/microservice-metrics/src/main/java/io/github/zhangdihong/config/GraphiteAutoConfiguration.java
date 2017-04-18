package io.github.zhangdihong.config;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.TimeUnit;

/**
 * <p>Project: io.github.zhangdihong.config</p>
 * <p>Title: GraphiteAutoConfiguration.java</p>
 * <p/>
 * <p>Description: GraphiteAutoConfiguration </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/8
 */
@Configuration
@AutoConfigureAfter(MetricRepositoryAutoConfiguration.class)
@ConditionalOnProperty(prefix = "graphite", name = "enabled", matchIfMissing = true)
//@EnableConfigurationProperties(GraphiteProperties.class)
@EnableScheduling
@EnableMetrics
public class GraphiteAutoConfiguration {

    @Bean
    public MetricsConfigurerAdapter metricsConfigurerAdapter() {
        return new GraphiteReportingManager();
    }

    /**
     * https://qbgbook.gitbooks.io/spring-boot-reference-guide-zh/content/IV.%20Spring%20Boot%20features/36.3.3.%20Property%20conditions.html
     * @param
     * @param metricRegistry
     * @return
     */
    @Bean
    @ConditionalOnProperty(value = "graphite.host",matchIfMissing = true)
    public ConsoleReporter consoleReporter(MetricRegistry metricRegistry) {
        ConsoleReporter.Builder builder = ConsoleReporter.forRegistry(metricRegistry);
        ConsoleReporter reporter = builder.build();
        reporter.start(5000L, TimeUnit.MILLISECONDS);
        return reporter;
    }
}
