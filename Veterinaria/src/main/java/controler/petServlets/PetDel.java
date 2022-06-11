/*
 *  
 */

package controler.petServlets;

import data.PetDAO;
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
@WebServlet (name = "PetDel", urlPatterns = {"/PetDel"})

public class PetDel extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        PetDAO dao = new PetDAO();
       
        PrintWriter out = rp.getWriter();
        try {
            if (dao.delete(id) == 0) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Mascota eliminada con éxito.');");
                out.println("window.location='/Veterinaria/views/petDel.jsp'");
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
                    out.println("alert('Error al eliminar Mascota!');");
                }
                out.println("window.location='/Veterinaria/views/petDel.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(PetDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
