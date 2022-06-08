/*
 *  
 */
package controler.ownerServlets;

import data.OwnerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
@WebServlet(name = "OwnerDel", urlPatterns = {"/OwnerDel"})

public class OwnerDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        String ine = rq.getParameter("ine");

        OwnerDAO dao = new OwnerDAO();

        PrintWriter out = rp.getWriter();
        try {
            if (dao.delete(ine)) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Dueño eliminado con éxito.');");
                out.println("window.location='/Veterinaria/views/ownerDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al eliminar dueño!/ INE equivocado');");
                out.println("window.location='/Veterinaria/views/ownerDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(OwnerDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
