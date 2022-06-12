/*
 *  
 */
package controler.productServlets;

import data.CategoryDAO;
import data.ProdUpdateDAO;
import data.ProductDAO;
import model.Category;
import model.Product;
import model.ProdUpdate;
import java.io.IOException;
import java.io.PrintWriter;
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

        CategoryDAO r_cat = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            prod = dao.select();
            cat = r_cat.select();
            rq.getSession().setAttribute("prod", prod);
            rq.getSession().setAttribute("cat", cat);
            rp.sendRedirect("/Veterinaria/views/productSe.jsp");
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
            int inStock = ("".equals(rq.getParameter("inStock"))) ? 0 : Integer.parseInt(rq.getParameter("inStock"));
            int minStock = ("".equals(rq.getParameter("minStock"))) ? 0 : Integer.parseInt(rq.getParameter("minStock"));
            float priceIn = ("".equals(rq.getParameter("priceIn"))) ? -1 : Float.parseFloat(rq.getParameter("priceIn"));
            float priceOut = ("".equals(rq.getParameter("priceOut"))) ? -1 : Float.parseFloat(rq.getParameter("priceOut"));
            int r_category = ("".equals(rq.getParameter("r_category"))) ? 0 : Integer.parseInt(rq.getParameter("r_category"));
            Timestamp createdAt = new Timestamp(System.currentTimeMillis());
            //Date date = new Date();
            //Timestamp createdAt = new Timestamp(date.getTime());
            Timestamp updatedAt = createdAt;
            boolean isActive = true;

            ProductDAO dao = new ProductDAO();
            Product prod = new Product(id, name, description, inStock, minStock, priceIn, priceOut, r_category, createdAt, updatedAt, isActive);
           
            ProdUpdateDAO daoUp = new ProdUpdateDAO();
            String r_user = "USER";
            ProdUpdate prodUp = new ProdUpdate(id, updatedAt, r_user, "Se registró el producto");
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.insert(prod)) {
                daoUp.insert(prodUp);
                out.println("alert('Producto registrado con éxito.');");
            } else {
                out.println("alert('Error al registrar producto!');");
            }
            out.println("window.location='/Veterinaria/ProductR_Category'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");

        } catch (ParseException ex) {
            Logger.getLogger(ProductSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
