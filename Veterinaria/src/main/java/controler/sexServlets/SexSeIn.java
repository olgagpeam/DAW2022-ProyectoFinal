/*
 *  
 */
package controler.sexServlets;

import data.SexDAO;
import model.Sex;
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
@WebServlet(name = "SexSeIn", urlPatterns = {"/SexSeIn"})

public class SexSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        SexDAO dao = new SexDAO();
        ArrayList<Sex> sx;
        try {
            sx = dao.select();
            rq.getSession().setAttribute("sx", sx);
            rp.sendRedirect("/Veterinaria/views/SexConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SexSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String idd = rq.getParameter("id");
            char id = idd.charAt(0);
            String sex = rq.getParameter("sex");

            SexDAO dao = new SexDAO();
            Sex sx = new Sex(id, sex);
            dao.insert(sx);
        } catch (ParseException ex) {
            Logger.getLogger(SexSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
