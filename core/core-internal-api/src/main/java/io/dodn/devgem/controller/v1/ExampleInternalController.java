package io.dodn.devgem.controller.v1;

import io.dodn.devgem.controller.v1.request.ExampleRequestDto;
import io.dodn.devgem.controller.v1.response.ExampleResponseDto;
import io.dodn.devgem.domain.ExampleData;
import io.dodn.devgem.domain.ExampleInternalService;
import io.dodn.devgem.domain.ExampleResult;
import io.dodn.devgem.support.response.InternalApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleInternalController {
    private final ExampleInternalService exampleExampleInternalService;

    public ExampleInternalController(ExampleInternalService exampleExampleInternalService) {
        this.exampleExampleInternalService = exampleExampleInternalService;
    }

    @GetMapping("/internal/get/{exampleValue}")
    public InternalApiResponse<ExampleResponseDto> exampleGet(
            @PathVariable String exampleValue, @RequestParam String exampleParam) {
        ExampleResult result =
                exampleExampleInternalService.processExample(
                        new ExampleData(exampleValue, exampleParam));
        return InternalApiResponse.success(new ExampleResponseDto(result.data()));
    }

    @PostMapping("/internal/post")
    public InternalApiResponse<ExampleResponseDto> examplePost(
            @RequestBody ExampleRequestDto request) {
        ExampleResult result =
                exampleExampleInternalService.processExample(request.toExampleData());
        return InternalApiResponse.success(new ExampleResponseDto(result.data()));
    }
}
