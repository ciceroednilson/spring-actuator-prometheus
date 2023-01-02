package br.com.ciceroednilson.prometheus.controller;

import br.com.ciceroednilson.prometheus.request.CounterRequest;
import br.com.ciceroednilson.prometheus.service.PrometheusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/prometheus")
@RestController
public class PrometheusController {
    @Autowired
    private PrometheusService prometheusService;

    @PostMapping("/counter")
    public @ResponseBody ResponseEntity<Double> counter(@RequestBody CounterRequest request) {
        final double count = prometheusService.counter(request);
        return new ResponseEntity(count, HttpStatus.CREATED);
    }
}
