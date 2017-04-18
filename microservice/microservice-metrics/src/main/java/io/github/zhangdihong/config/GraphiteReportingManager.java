package io.github.zhangdihong.config;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.*;
import com.codahale.metrics.jvm.GarbageCollectorMetricSet;
import com.codahale.metrics.jvm.MemoryUsageGaugeSet;
import com.codahale.metrics.jvm.ThreadStatesGaugeSet;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

import java.util.concurrent.TimeUnit;

/**
 * <p>Project: io.github.zhangdihong.config</p>
 * <p>Title: GraphiteReportingManager.java</p>
 * <p/>
 * <p>Description: GraphiteReportingManager </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/8
 */
public class GraphiteReportingManager extends MetricsConfigurerAdapter implements DisposableBean {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void configureReporters(MetricRegistry metricRegistry) {
        //gc的metrics,目前看来每秒发送一次貌似太频繁,可以另起一个reporter进行
        metricRegistry.register("jvm.gc", new GarbageCollectorMetricSet());
        metricRegistry.register("jvm.mem", new MemoryUsageGaugeSet());
        metricRegistry.register("jvm.thread-states", new ThreadStatesGaugeSet());

        logger.info("graphite host:{},port:{}","192.168.1.105", 8300);
        GraphiteReporter reporter = GraphiteReporter.forRegistry(metricRegistry)
                .prefixedWith("")
//                        .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(createSender("udp"));
        registerReporter(reporter);
        reporter.start(1L, TimeUnit.SECONDS);
    }

    @Override
    public void destroy() throws Exception {
        super.destroy();
    }

    private GraphiteSender createSender(String type) {
        switch (type) {
            case "udp":
                return new GraphiteUDP("192.168.1.105", 8300);
            case "tcp":
                return new Graphite("192.168.1.105", 8300);
            case "pickled":
                return new PickledGraphite("192.168.1.105", 8300);
            default:
                return new GraphiteUDP("192.168.1.105", 8300);
        }
    }
}
