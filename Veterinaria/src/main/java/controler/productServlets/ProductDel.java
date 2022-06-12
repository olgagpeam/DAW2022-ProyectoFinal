/*
 *  
 */
package controler.productServlets;

import controler.ownerServlets.OwnerDel;
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

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ProductDel", urlPatterns = {"/ProductDel"})

public class ProductDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());

        ProductDAO dao = new ProductDAO();

        ProdUpdateDAO daoUp = new ProdUpdateDAO();
        ProdUpdate prodUp = new ProdUpdate(id, updatedAt, "USER", "Se eliminó");
        PrintWriter out = rp.getWriter();
        try {
            if (dao.delete(id) == 0) {
                daoUp.insert(prodUp);
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Producto eliminado con éxito.');");
                out.println("window.location='/Veterinaria/views/productDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                if (dao.delete(id) == 1) {
                    out.println("alert('El ID ingresado no existe');");
                }
                if (dao.delete(id) == 2) {
                    out.println("alert('Error al eliminar producto!');");
                }
                out.println("window.location='/Veterinaria/views/productDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(OwnerDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
