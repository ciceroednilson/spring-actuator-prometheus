package br.com.ciceroednilson.prometheus.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class CounterRequest {

    private String metricName;
    private String description;
    private Map<String, String> tags;
}
