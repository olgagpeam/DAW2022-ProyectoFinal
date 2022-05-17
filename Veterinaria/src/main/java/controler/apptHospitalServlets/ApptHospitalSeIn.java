/*
 *  
 */
package controler.apptHospitalServlets;

import data.ApptHospitalDAO;
import model.ApptHospital;
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
@WebServlet(name = "ApptHospitalSeIn", urlPatterns = {"/ApptHospitalSeIn"})

public class ApptHospitalSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptHospitalDAO dao = new ApptHospitalDAO();
        ArrayList<ApptHospital> apptH;
        try {
            apptH = dao.select();
            rq.getSession().setAttribute("apptH", apptH);
            rp.sendRedirect("/Veterinaria/views/ApptHConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalSeIn.class.getName()).log(Level.SEVERE, null, ex);
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

            String illness = rq.getParameter("illness");
            String procedures = rq.getParameter("procedures");
            String med = rq.getParameter("med");

            ApptHospitalDAO dao = new ApptHospitalDAO();
            ApptHospital apptH = new ApptHospital(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, illness, procedures, med);
            dao.insert(apptH);
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
