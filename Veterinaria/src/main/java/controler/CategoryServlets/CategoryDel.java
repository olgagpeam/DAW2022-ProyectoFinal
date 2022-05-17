/*
 *  
 */
package controler.CategoryServlets;

import data.CategoryDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "CategoryDel", urlPatterns = {"/CategoryDel"})

public class CategoryDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        CategoryDAO dao = new CategoryDAO();
        dao.delete(id);
    }
}
