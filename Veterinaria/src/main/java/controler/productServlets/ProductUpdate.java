/*
 *  
 */
package controler.productServlets;

import data.ProdUpdateDAO;
import data.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ProdUpdate;
import model.Product;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ProductUpdate", urlPatterns = {"/ProductUpdate"})
public class ProductUpdate extends HttpServlet {
String[] result = null;
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String id = rq.getParameter("id");
            int inStock = (rq.getParameter("inStock").equals("")) ? 0 : Integer.valueOf(rq.getParameter("inStock"));
            PrintWriter out = rp.getWriter();
            ProdUpdateDAO daoUp = new ProdUpdateDAO();
            String name = rq.getParameter("name");
            String description = rq.getParameter("description");
            int minStock = ("".equals(rq.getParameter("minStock"))) ? 0 : Integer.parseInt(rq.getParameter("minStock"));
            float priceIn = ("".equals(rq.getParameter("priceIn"))) ? -1 : Float.parseFloat(rq.getParameter("priceIn"));
            float priceOut = ("".equals(rq.getParameter("priceOut"))) ? -1 : Float.parseFloat(rq.getParameter("priceOut"));
            int r_category = ("".equals(rq.getParameter("r_category"))) ? 0 : Integer.parseInt(rq.getParameter("r_category"));
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            boolean isActive = ((rq.getParameter("isActive")).equals("si"));
            ProductDAO dao = new ProductDAO();
            Product prod = new Product(name, description, inStock, minStock, priceIn, priceOut, r_category, updatedAt, isActive);
            ProdUpdate prodUp = new ProdUpdate(id, updatedAt, "USER", "Se editó la informacion del producto");
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(prod, id)) {

                daoUp.insert(prodUp);

                out.println("alert('Producto actualizado con éxito.');");
            } else {
                out.println("alert('Error al actualizar producto!');");
            }
            out.println("window.location='/Veterinaria/views/productUp.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ProductUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
