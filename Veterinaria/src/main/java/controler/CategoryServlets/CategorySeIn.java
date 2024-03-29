/*
 *  
 */
package controler.CategoryServlets;

import data.CategoryDAO;
import model.Category;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CategorySeIn", urlPatterns = {"/CategorySeIn"})

public class CategorySeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        CategoryDAO dao = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            cat = dao.select();
            rq.getSession().setAttribute("cat", cat);
            rp.sendRedirect("/Veterinaria/views/categorySe.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(CategorySeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String nom = rq.getParameter("cat");

            CategoryDAO dao = new CategoryDAO();
            Category cat = new Category(nom);

            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.insert(cat)) {
                out.println("alert('Categoria registrada con éxito.');");
            } else {
                out.println("alert('Error al registrar categoria!');");
            }
            out.println("window.location='/Veterinaria/views/categoryIn.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(CategorySeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
