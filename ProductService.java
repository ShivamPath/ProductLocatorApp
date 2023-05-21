import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List <Product> products= new ArrayList<>();

//    Write operation
    public void addProduct(Product product){
        products.add(product);
    }

    //Read operation
    public List<Product> getAllProducts() {
        return products;
        }

    //Search operation
    public Product getproduct(String givenName) {
        String givenNameLowerCase= givenName.toLowerCase();
        for (Product product : products) {
            String productNameLowerCase = product.getName().toLowerCase();
            if (productNameLowerCase.equals(givenNameLowerCase))
                return product;
        }
        return new Product();
    }

    //Searching Products with keywords
    public List<Product> getProductsWithKeywords(String givenKeyword) {
        String givenKeywordLowerCasekeys=givenKeyword.toLowerCase();
        List<Product> newList = new ArrayList<>();
        for (Product p : products) {
            String name=p.getName().toLowerCase();
            String type=p.getType().toLowerCase();
            String location=p.getLocation().toLowerCase();
            if ( name.contains(givenKeywordLowerCasekeys) || type.contains(givenKeywordLowerCasekeys) ||location.contains(givenKeywordLowerCasekeys) ) {
                newList.add(p);
            }
        }
        return newList;
    }

    //Searching by Location
    public List<Product> getProductsByLocation(String givenLocation){
        String givenLocationLowerCase =givenLocation.toLowerCase();
        List<Product>  productListTempt= new ArrayList<>();
        for(Product product: products){
            String productLocationLowerCase=product.getLocation().toLowerCase();
            if(productLocationLowerCase.equals(givenLocationLowerCase)){
                productListTempt.add(product);
            }
        }
       return productListTempt;
    }

    //Searching all expired products
    public List<Product> getExpiredWarrantyProducts() {
        List<Product> expiredProducts = new ArrayList<>();
        for(Product product: products){
            if(product.getWarranty()<2023){
                expiredProducts.add(product);
            }
        }
        return expiredProducts;
    }
}
