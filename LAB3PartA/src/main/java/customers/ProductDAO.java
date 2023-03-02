package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void clearDB(){
        Map<String, Object>  namedParameters = new HashMap<>();
        jdbcTemplate.update("DELETE from product", namedParameters);
        jdbcTemplate.update("DELETE from supplier", namedParameters);

    }

    public void save(Product product){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("productName", product.getProductName());
        jdbcTemplate.update("INSERT INTO product VALUES (:productNumber, :productName)", namedParameters);

        //save supplier
        Map<String, Object> namedSupplierParameters = new HashMap<>();
        namedSupplierParameters.put("supplierNumber",product.getSupplier().getSupplierNumber());
        namedSupplierParameters.put("name", product.getSupplier().getName());
        namedSupplierParameters.put("phone", product.getSupplier().getPhone());
        namedSupplierParameters.put("productNumber", product.getProductNumber());
        System.out.println(product);
        jdbcTemplate.update("INSERT INTO supplier VALUES (:supplierNumber, :name, :phone, :productNumber)", namedSupplierParameters);

    }

    public Product findByProductNumber(int productNumber){
        Map<String, Object> namedParameters = new HashMap();
        namedParameters.put("productNumber", productNumber);
        Product product = jdbcTemplate.queryForObject("SELECT *" +
                " FROM product " +
                " WHERE productNumber = :productNumber",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("productName")));
        Supplier supplier = getSupplierForProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;
    }



    public List<Product> getAllProducts(){
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                new HashMap<String, Customer>(),
                (rs, rowNum) -> new Product(rs.getInt("productNumber"),
                        rs.getString("productName")));
        for (Product product: products){
            Supplier supplier = getSupplierForProduct(product.getProductNumber());
            product.setSupplier(supplier);
        }
        return products;
    }

    public Product findByProductName(String productName){
        Map<String, Object> namedParameters = new HashMap();
        namedParameters.put("productName", productName);
        Product product = jdbcTemplate.queryForObject("SELECT *" +
                        " FROM product " +
                        " WHERE productName = :productName",
                namedParameters,
                (rs, rowNum) -> new Product( rs.getInt("productNumber"),
                        rs.getString("productName")));
        Supplier supplier = getSupplierForProduct(product.getProductNumber());
        product.setSupplier(supplier);
        return product;
    }

    public void removeProduct(int productNumber){
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        jdbcTemplate.update("DELETE from product where productNumber =:productNumber", namedParameters);
        jdbcTemplate.update("DELETE from supplier where productNumber =:productNumber", namedParameters);

    }

    private Supplier getSupplierForProduct(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("productNumber", productNumber);
        Supplier supplier = jdbcTemplate.queryForObject("SELECT * from supplier WHERE productNumber = :productNumber",
                namedParameters,
                (rs, rowNum) -> new Supplier(
                        rs.getInt("supplierNumber"),
                        rs.getString("name"),
                        rs.getString("phone"))
        );
        return supplier;
    }
}
