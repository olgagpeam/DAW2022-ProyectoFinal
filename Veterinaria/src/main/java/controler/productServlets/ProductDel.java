/*
 *  
 */

package controler.productServlets;

import data.ProductDAO;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "ProductDel", urlPatterns = {"/ProductDel"})

public class ProductDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String id = rq.getParameter("id");

        ProductDAO dao = new ProductDAO();
        dao.delete(id);
    }
}