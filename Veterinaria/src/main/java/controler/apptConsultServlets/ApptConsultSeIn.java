/*
 *  
 */
package controler.apptConsultServlets;

import data.ApptConsultDAO;
import model.ApptConsult;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "ApptConsultSeIn", urlPatterns = {"/ApptConsultSeIn"})

public class ApptConsultSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptConsultDAO dao = new ApptConsultDAO();
        ArrayList<ApptConsult> apptC;
        try {
            apptC = dao.select();
            rq.getSession().setAttribute("apptC", apptC);
            rp.sendRedirect("/Veterinaria/views/ApptCConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptConsultSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
            
            int id = Integer.parseInt(rq.getParameter("id"));
            String r_user = rq.getParameter("r_user");
            String r_owner = rq.getParameter("r_owner");
            int r_pet = Integer.parseInt(rq.getParameter("r_pet"));
            String addr = rq.getParameter("addr");
            Date dateAppt = new Date(df.parse(rq.getParameter("dateAppt")).getTime());
            Time inHour = new Time(tdf.parse(rq.getParameter("inHour")).getTime());
            String sector = rq.getParameter("sector");
            char r_sector = sector.charAt(0);
            String note = rq.getParameter("note");

            int r_consult = Integer.parseInt(rq.getParameter("r_consult"));
            String addrRef = rq.getParameter("addrRef");
            String diagnosis = rq.getParameter("diagnosis");
            String procedures = rq.getParameter("procedures");
            String med = rq.getParameter("med");

            ApptConsultDAO dao = new ApptConsultDAO();
            ApptConsult apptC = new ApptConsult(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_consult, addrRef, diagnosis, procedures, med);
            dao.insert(apptC);
        } catch (ParseException ex) {
            Logger.getLogger(ApptConsultSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
