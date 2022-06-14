/*
 *  
 */

package controler.medUpdateServlets;

import data.MedUpdateDAO;
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
@WebServlet (name = "MedUpdateDel", urlPatterns = {"/MedUpdateDel"})

public class MedUpdateDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        MedUpdateDAO dao = new MedUpdateDAO();
        PrintWriter out = rp.getWriter();
        try {
            if (dao.delete(id) == 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Registro eliminado con éxito.');");
                out.println("window.location='/Veterinaria/views/medUpDel.jsp'");
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
                    out.println("alert('Error al eliminar registro!');");
                }
                out.println("window.location='/Veterinaria/views/medUpDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(MedUpdateDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
