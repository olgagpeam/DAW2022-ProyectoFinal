/*
 *  
 */
package controler.apptSalonServlets;

import data.ApptSalonDAO;
import model.ApptSalon;
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

public class ApptSalonSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptSalonDAO dao = new ApptSalonDAO();
        ArrayList<ApptSalon> apptS;
        try {
            apptS = dao.select();
            rq.getSession().setAttribute("apptS", apptS);
            rp.sendRedirect("/Veterinaria/views/ApptSConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonSeIn.class.getName()).log(Level.SEVERE, null, ex);
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

            int r_service = Integer.parseInt(rq.getParameter("r_service"));
            Time outHour = new Time(tdf.parse(rq.getParameter("outHour")).getTime());
            String products = rq.getParameter("products");

            ApptSalonDAO dao = new ApptSalonDAO();
            ApptSalon apptS = new ApptSalon(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_service , outHour, products);
            dao.insert(apptS);
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
