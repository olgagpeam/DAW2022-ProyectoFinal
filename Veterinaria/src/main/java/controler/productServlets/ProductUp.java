/*
 *  
 */
package controler.productServlets;

import data.CategoryDAO;
import data.ProductDAO;
import model.Category;
import model.Product;
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
@WebServlet(name = "ProductUp", urlPatterns = {"/ProductUp"})

public class ProductUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ProductDAO dao = new ProductDAO();
        CategoryDAO r_category = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            String[] result = null;
            String id = rq.getParameter("id");
            result = dao.selectOnly(id);
            cat = r_category.select();

            PrintWriter out = rp.getWriter();
            if (result[0].equals("404NotFound")) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Producto no encontrado/ID equivocado!');");
                out.println("window.location='/Veterinaria/views/productUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else if (result != null || result.length > 0) {
                rq.getSession().setAttribute("result", result);
                rq.getSession().setAttribute("cat", cat);
                rp.sendRedirect("/Veterinaria/views/productSearch.jsp");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al buscar producto!');");
                out.println("window.location='/Veterinaria/views/productUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProductUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");
        String name = rq.getParameter("name");
        String description = rq.getParameter("description");
        int inStock = ("".equals(rq.getParameter("inStock"))) ? -1 : Integer.parseInt(rq.getParameter("inStock"));
        int minStock = ("".equals(rq.getParameter("minStock"))) ? -1 : Integer.parseInt(rq.getParameter("minStock"));
        float priceIn = ("".equals(rq.getParameter("priceIn"))) ? -1 : Float.parseFloat(rq.getParameter("priceIn"));
        float priceOut = ("".equals(rq.getParameter("priceOut"))) ? -1 : Float.parseFloat(rq.getParameter("priceOut"));
        int r_category = ("".equals(rq.getParameter("r_category"))) ? -1 : Integer.parseInt(rq.getParameter("r_category"));
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        boolean isActive = ((rq.getParameter("isActive")).equals("si"));
        ProductDAO dao = new ProductDAO();
        Product prod = new Product(name, description, inStock, minStock, priceIn, priceOut, r_category, updatedAt, isActive);
        
        PrintWriter out = rp.getWriter();
            if (dao.update(prod, id)) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Producto actualizado con éxito.');");
                out.println("window.location='/Veterinaria/views/petUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al actualizar producto!');");
                out.println("window.location='/Veterinaria/views/petUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
    }
}
