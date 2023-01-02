package br.com.ciceroednilson.prometheus.service;

import br.com.ciceroednilson.prometheus.request.CounterRequest;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PrometheusService {
    @Autowired
    private MeterRegistry meterRegistry;

    public double counter(final CounterRequest request) {
        final List<Tag> listTags = buildTags(request.getTags());
        final Counter counter = counterBuild(request, listTags);
        counter.increment();
        return counter.count();
    }
    private List<Tag> buildTags(Map<String, String> tags) {
        final List<Tag> listTags = new ArrayList<>();
        tags.entrySet().forEach(tag -> {
            listTags.add(Tag.of(tag.getKey(), tag.getValue()));
        });
        return listTags;
    }
    private Counter counterBuild(final CounterRequest request, final List<Tag> listTags) {
        return Counter
                .builder(request.getMetricName())
                .description(request.getDescription())
                .tags(listTags)
                .register(this.meterRegistry);
    }
}
