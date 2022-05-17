/*
 *  
 */
package controler.productServlets;

import data.ProductDAO;
import model.Product;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ProductSeIn", urlPatterns = {"/ProductSeIn"})

public class ProductSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> prod;
        try {
            prod = dao.select();
            rq.getSession().setAttribute("prod", prod);
            rp.sendRedirect("/Veterinaria/views/ProductConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ProductSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String id = rq.getParameter("id");
            String name = rq.getParameter("name");
            String description = rq.getParameter("description");
            int inStock = Integer.parseInt(rq.getParameter("inStock"));
            int minStock = Integer.parseInt(rq.getParameter("minStock"));
            float priceIn = Float.parseFloat(rq.getParameter("priceIn"));
            float priceOut = Float.parseFloat(rq.getParameter("priceOut"));
            int r_category = Integer.parseInt(rq.getParameter("r_category"));
            
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            //Date date = new Date();
            //Timestamp createdAt = new Timestamp(date.getTime());
            Timestamp updatedAt = createdAt;
            boolean isActive = true;

            ProductDAO dao = new ProductDAO();
            Product prod = new Product(id, name, description, inStock, minStock, priceIn, priceOut, r_category, createdAt, updatedAt, isActive);
            dao.insert(prod);
        } catch (ParseException ex) {
            Logger.getLogger(ProductSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
