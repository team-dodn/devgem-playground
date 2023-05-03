package io.dodn.devgem.controller.internal;

import io.dodn.devgem.controller.v1.request.ExampleRequestDto;
import io.dodn.devgem.controller.v1.response.ExampleResponseDto;
import io.dodn.devgem.domain.ExampleData;
import io.dodn.devgem.domain.ExampleResult;
import io.dodn.devgem.domain.ExampleService;
import io.dodn.devgem.support.response.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExampleInternalController {
    private final ExampleService exampleExampleService;

    public ExampleInternalController(ExampleService exampleExampleService) {
        this.exampleExampleService = exampleExampleService;
    }

    @GetMapping("/get/{exampleValue}")
    public ApiResponse<ExampleResponseDto> exampleGet(
            @PathVariable String exampleValue, @RequestParam String exampleParam) {
        ExampleResult result =
                exampleExampleService.processExample(new ExampleData(exampleValue, exampleParam));
        return ApiResponse.success(new ExampleResponseDto(result.data()));
    }

    @PostMapping("/post")
    public ApiResponse<ExampleResponseDto> examplePost(@RequestBody ExampleRequestDto request) {
        ExampleResult result = exampleExampleService.processExample(request.toExampleData());
        return ApiResponse.success(new ExampleResponseDto(result.data()));
    }
}
