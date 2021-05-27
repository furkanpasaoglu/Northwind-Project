package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo,int pageSize){
        return this.productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam("productName") String productName){
        return this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategory_CategoryId")
    public DataResult<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByProductNameOrCategory_CategoryId")
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getByCategoryIdIn")
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories){
        return this.productService.getByCategoryIdIn(categories);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam("productName") String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("/getByProductNameStartsWith")
    public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam("productName") String productName){
        return this.productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getByNameAndCategory_CategoryId")
    public DataResult<List<Product>> getByNameAndCategory_CategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByNameAndCategory_CategoryId(productName,categoryId);
    }
}