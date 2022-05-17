/*
 *  
 */

package controler.productServlets;

import data.ProductDAO;
import model.Product;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "ProductUp", urlPatterns = {"/ProductUp"})

public class ProductUp extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");
        String name = rq.getParameter("name");
        String description = rq.getParameter("description");
        int inStock = Integer.parseInt(rq.getParameter("inStock"));
        int minStock = Integer.parseInt(rq.getParameter("minStock"));
        float priceIn = Float.parseFloat(rq.getParameter("priceIn"));
        float priceOut = Float.parseFloat(rq.getParameter("priceOut"));
        int r_category = Integer.parseInt(rq.getParameter("r_category"));
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        //Date date = new Date();
        //Timestamp updatedAt = new Timestamp(date.getTime());
        boolean isActive = ((rq.getParameter("isActive")).equals("si") ? true : false);
        ProductDAO dao = new ProductDAO();
        Product prod = new Product(name, description, inStock, minStock, priceIn, priceOut, r_category, updatedAt, isActive);
        dao.update(prod, id);
    }
}
