package com.wipro.cloud.productservice.controller;

import com.wipro.cloud.productservice.entity.Product;
import com.wipro.cloud.productservice.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Osnir Cunha on 28-May-18.
 */
@RestController
@RequestMapping("/products")
@Api(value = "products", description = "Data service operations on products", tags = ("products"))
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(params = {"page", "size"}, method = RequestMethod.GET)
    @ApiOperation(value = "Get All Products Paging", notes = "Gets all products in the system by paging results", nickname = "getProductsPaging")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Product> findAll(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (page == null || size == null) {
            return this.productRepository.findAll();
        }

        Page<Product> pageResult = this.productRepository.findAll(new PageRequest(page, size));
        return pageResult.getContent();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get All Products", notes = "Gets all products in the system", nickname = "getAllProducts")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @RequestMapping(params = {"query"}, method = RequestMethod.GET)
    @ApiOperation(value = "Find products by name", notes = "Find products in the system by product name", nickname = "findProduct")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Product> findByName(@RequestParam(value = "query", required = false) String name) {
        return this.productRepository.findByNameContainingIgnoreCase(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get a product", notes = "Gets a product in the system", nickname = "getProduct")
    @ResponseStatus(value = HttpStatus.OK)
    public Product findById(@PathVariable("id") Long id) {
        return this.productRepository.findOne(id);
    }

}
