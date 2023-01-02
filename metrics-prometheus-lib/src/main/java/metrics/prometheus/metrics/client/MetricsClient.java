package metrics.prometheus.metrics.client;

import metrics.prometheus.metrics.bean.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MetricsClient {
    @Autowired
    private RestTemplate restTemplate;
    private static final String URL = "http://192.168.1.103:8080/prometheus/counter";

    public double register(final Counter counter) {
        final ResponseEntity<Double> responseEntity = restTemplate.postForEntity(URL, counter, Double.class);
        return responseEntity.getBody();
    }
}
