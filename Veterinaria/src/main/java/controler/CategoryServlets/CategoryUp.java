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
@WebServlet(name = "CategoryUp", urlPatterns = {"/CategoryUp"})

public class CategoryUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        CategoryDAO dao = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            cat = dao.select();
            String[] result = {"", ""};

            PrintWriter out = rp.getWriter();
            for (Category ct : cat) {
                if (ct.getId() == id) {
                    result[0] = String.valueOf(ct.getId());
                    result[1] = ct.getCategory();
                    rq.getSession().setAttribute("result", result);
                    rp.sendRedirect("/Veterinaria/views/categorySearch.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Categoria no encontrada/ID equivocado!');");
                    out.println("window.location='/Veterinaria/views/categoryUp.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(CategoryUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        String nom = rq.getParameter("cat");

        CategoryDAO dao = new CategoryDAO();
        Category cat = new Category(nom);

        PrintWriter out = rp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<script>");
        if (dao.update(cat, id)) {
            out.println("alert('Categoria actualizada con éxito.');");
        } else {
            out.println("alert('Error al actualizar categoria!');");
        }
        out.println("window.location='/Veterinaria/views/categoryUp.jsp'");
        out.println("</script>");
        out.println("</head>");
        out.println("</html>");
    }
}
