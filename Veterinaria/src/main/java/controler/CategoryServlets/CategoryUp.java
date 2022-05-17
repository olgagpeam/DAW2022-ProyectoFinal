/*
 *  
 */
package controler.CategoryServlets;

import data.CategoryDAO;
import model.Category;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "CategoryUp", urlPatterns = {"/CategoryUp"})

public class CategoryUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        String nom = rq.getParameter("cat");

        CategoryDAO dao = new CategoryDAO();
        Category cat = new Category(nom);
        dao.update(cat, id);
    }
}
