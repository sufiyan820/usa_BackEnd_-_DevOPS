package com.NextLevel.USA.SERVICESimpl;

import com.NextLevel.USA.DTO0.request.o.product.ProductCreateDTO;
import com.NextLevel.USA.DTO0.request.o.product.ProductUpdateDTO;
import com.NextLevel.USA.DTO0.Response.ProductResponseDTO;
import com.NextLevel.USA.ENTITIES.ProdctImages;
import com.NextLevel.USA.ENTITIES.Products;
import com.NextLevel.USA.Enum.ProductStatus;
import com.NextLevel.USA.Mapper.ProductMapper;
import com.NextLevel.USA.Services.ProductService;
import com.NextLevel.USA.jpAREPOSITORIES.ProductImagesRepo;
import com.NextLevel.USA.jpAREPOSITORIES.Productrepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceIMPL implements ProductService {

    private final Productrepo productRepository;
    private final ProductImagesRepo productImagesRepo;


    public ProductServiceIMPL(Productrepo productRepository, ProductImagesRepo productImagesRepo) {
        this.productRepository = productRepository;
        this.productImagesRepo = productImagesRepo;
    }



    @Override
    public ProductResponseDTO updateProduct(Long id, ProductUpdateDTO dto) {

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductMapper.updateEntity(product, dto);

        productRepository.save(product);

        return ProductMapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductMapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductCreateDTO dto) {
       Products product = ProductMapper.toEntity(dto);

       Products saveProduct = productRepository.save(product);

       if (dto.getImageUrls() != null && !dto.getImageUrls().isEmpty()) {
           for (String imageUrl : dto.getImageUrls()) {
               ProdctImages img = new ProdctImages();
               img.setImageUrl(imageUrl);
               img.setProducts(saveProduct);

               productImagesRepo.save(img);
           }
       }
       return  ProductMapper.toDTO(saveProduct);

    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .toList();
    }

    @Override
    public void deleteProduct(Long id) {

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productRepository.delete(product);
    }


}
