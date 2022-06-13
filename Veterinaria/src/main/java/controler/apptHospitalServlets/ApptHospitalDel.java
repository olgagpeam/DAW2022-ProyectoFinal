/*
 *  
 */
package controler.apptHospitalServlets;

import data.ApptHospitalDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptHospitalDel", urlPatterns = {"/ApptHospitalDel"})

public class ApptHospitalDel extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));

        ApptHospitalDAO dao = new ApptHospitalDAO();

        PrintWriter out = rp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<script>");
        try {
            if (dao.delete(id) == 0) {
                out.println("alert('Cita eliminada con éxito.');");
            } else {
                if (dao.delete(id) == 1) {
                    out.println("alert('El ID ingresado no existe');");
                }
                if (dao.delete(id) == 2) {
                    out.println("alert('Error al eliminar cita!');");
                }
            }
            out.println("window.location='/Veterinaria/views/apptDelH.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalDel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
