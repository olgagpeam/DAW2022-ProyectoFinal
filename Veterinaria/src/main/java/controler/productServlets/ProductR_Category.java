/*
 *  
 */

package controler.productServlets;
        
import data.CategoryDAO;
import model.Category;
import java.io.IOException;
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
@WebServlet(name = "ProductR_Category", urlPatterns = {"/ProductR_Category"})

public class ProductR_Category extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        CategoryDAO dao = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            cat = dao.select();
            rq.getSession().setAttribute("cat", cat);
            rp.sendRedirect("/Veterinaria/views/productIn.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ProductR_Category.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}