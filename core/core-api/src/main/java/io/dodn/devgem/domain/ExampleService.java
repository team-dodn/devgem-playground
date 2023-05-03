package io.dodn.devgem.domain;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    public ExampleResult processExample(ExampleData exampleData) {
        return new ExampleResult(exampleData.value());
    }
}
