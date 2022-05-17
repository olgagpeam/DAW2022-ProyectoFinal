/*
 *  
 */
package controler.apptConsultServlets;

import data.ApptConsultDAO;
import model.ApptConsult;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptConsultUp", urlPatterns = {"/ApptConsultUp"})

public class ApptConsultUp extends HttpServlet {
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
    
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
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
            ApptConsult apptC = new ApptConsult(r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_consult, addrRef, diagnosis, procedures, med);
            dao.update(apptC, id);
        } catch (ParseException ex) {
            Logger.getLogger(ApptConsultUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
