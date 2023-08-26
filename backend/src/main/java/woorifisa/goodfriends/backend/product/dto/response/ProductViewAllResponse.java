package woorifisa.goodfriends.backend.product.dto.response;

import woorifisa.goodfriends.backend.product.domain.ProductStatus;

import java.util.List;

public class ProductViewAllResponse {

    private Long id;

    private int productCategoryId;

    private String title;

    private ProductStatus status;

    private int sellPrice;

    private String image;

    public ProductViewAllResponse() {
    }

    public ProductViewAllResponse(Long id, int productCategoryId, String title, ProductStatus status, int sellPrice, String image) {
        this.id = id;
        this.productCategoryId = productCategoryId;
        this.title = title;
        this.status = status;
        this.sellPrice = sellPrice;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public int getProductCategoryId() {
        return productCategoryId;
    }

    public String getTitle() {
        return title;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public String getImageUrl() {
        return image;
    }
}
