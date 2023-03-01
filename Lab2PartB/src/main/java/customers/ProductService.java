package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService implements IProductService {
    private IProductDAO productDAO;
    private IEmailSender emailSender;


    @Autowired
    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setEmailSender(IEmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addProduct(String productId, String productName, String email){
        Product p = new Product(productId, productName);
        productDAO.save(p);
        emailSender.sendEmail(email, "Product added : " + p.getProductName());
    }

}
