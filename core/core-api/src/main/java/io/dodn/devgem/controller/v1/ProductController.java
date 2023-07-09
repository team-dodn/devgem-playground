package io.dodn.devgem.controller.v1;

import io.dodn.devgem.controller.v1.response.ProductListResponse;
import io.dodn.devgem.domain.Product;
import io.dodn.devgem.domain.ProductService;
import io.dodn.devgem.support.SearchRange;
import io.dodn.devgem.support.response.ApiResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/v1/products")
    public ApiResponse<ProductListResponse> findProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        List<Product> products = productService.findProducts(new SearchRange(page, size));
        return ApiResponse.success(new ProductListResponse(products));
    }
}
