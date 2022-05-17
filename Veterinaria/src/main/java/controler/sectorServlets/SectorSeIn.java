/*
 *  
 */
package controler.sectorServlets;

import data.SectorDAO;
import model.Sector;
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
@WebServlet(name = "SectorSeIn", urlPatterns = {"/SectorSeIn"})

public class SectorSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        SectorDAO dao = new SectorDAO();
        ArrayList<Sector> sec;
        try {
            sec = dao.select();
            rq.getSession().setAttribute("sec", sec);
            rp.sendRedirect("/Veterinaria/views/SectorConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(SectorSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String idd = rq.getParameter("id");
            char id = idd.charAt(0);
            String sex = rq.getParameter("sex");

            SectorDAO dao = new SectorDAO();
            Sector sec = new Sector(id, sex);
            dao.insert(sec);
        } catch (ParseException ex) {
            Logger.getLogger(SectorSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
