package io.dodn.devgem.controller.v1.request;

import io.dodn.devgem.domain.ExampleData;

public record ExampleRequestDto(String data) {
    public ExampleData toExampleData() {
        return new ExampleData(data, data);
    }
}
