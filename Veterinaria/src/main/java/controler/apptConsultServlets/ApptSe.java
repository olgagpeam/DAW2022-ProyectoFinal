/*
 *  
 */
package controler.apptConsultServlets;

import data.ApptConsultDAO;
import data.ApptHospitalDAO;
import data.ApptSalonDAO;
import model.ApptConsult;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ApptHospital;
import model.ApptSalon;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptSe", urlPatterns = {"/ApptSe"})
public class ApptSe extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptConsultDAO daoC = new ApptConsultDAO();
        ArrayList<ApptConsult> apptC;

        ApptHospitalDAO daoH = new ApptHospitalDAO();
        ArrayList<ApptHospital> apptH;

        ApptSalonDAO daoS = new ApptSalonDAO();
        ArrayList<ApptSalon> apptS;
        try {
            apptC = daoC.select();
            apptH = daoH.select();
            apptS = daoS.select();

            rq.getSession().setAttribute("apptC", apptC);
            rq.getSession().setAttribute("apptH", apptH);
            rq.getSession().setAttribute("apptS", apptS);
            rp.sendRedirect("/Veterinaria/views/apptSe.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptSe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
