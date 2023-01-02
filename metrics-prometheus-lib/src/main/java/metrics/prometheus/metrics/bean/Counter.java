package metrics.prometheus.metrics.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Counter {

    private String metricName;
    private String description;
    private Map<String, String> tags;
}
