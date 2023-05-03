package io.dodn.devgem.client.example;

import io.dodn.devgem.client.example.model.ExampleClientResult;

record ExampleResponseDto(String exampleResponseValue) {
    ExampleClientResult toResult() {
        return new ExampleClientResult(exampleResponseValue);
    }
}
