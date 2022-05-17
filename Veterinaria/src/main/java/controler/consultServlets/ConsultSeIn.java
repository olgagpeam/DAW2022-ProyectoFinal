/*
 *  
 */
package controler.consultServlets;

import data.ConsultDAO;
import model.Consult;
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
@WebServlet(name = "ConsultSeIn", urlPatterns = {"/ConsultSeIn"})

public class ConsultSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ConsultDAO dao = new ConsultDAO();
        ArrayList<Consult> cons;
        try {
            cons = dao.select();
            rq.getSession().setAttribute("cons", cons);
            rp.sendRedirect("/Veterinaria/views/ConsultConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ConsultSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String nom = rq.getParameter("cons");

            ConsultDAO dao = new ConsultDAO();
            Consult cons = new Consult(nom);
            dao.insert(cons);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
