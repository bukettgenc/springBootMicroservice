package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buket.springbootmicroservice1product.model.Product;
import com.buket.springbootmicroservice1product.service.IProductService;

@RestController
@RequestMapping("api/product")
public class ProductController {

	private final IProductService iProductService;

	public ProductController(IProductService iProductService) {
		super();
		this.iProductService = iProductService;
	}

	@PostMapping
	public ResponseEntity<?> saveProduct(@RequestBody Product product) {
		return new ResponseEntity<>(iProductService.saveProduct(product), HttpStatus.CREATED);
	}

	@DeleteMapping("{productId}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
		iProductService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("{productId}")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok(iProductService.findAllProducts());
	}

}
