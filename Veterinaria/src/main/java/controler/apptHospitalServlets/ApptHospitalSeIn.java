/*
 *  
 */
package controler.apptHospitalServlets;

import data.ApptHospitalDAO;
import model.ApptHospital;
import java.io.IOException;
import java.io.PrintWriter;
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
            rp.sendRedirect("/Veterinaria/views/apptSeH.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
            
            String r_user = rq.getParameter("r_user");
            String pet = rq.getParameter("r_pet");
            int r_pet = Integer.parseInt(pet.substring(0, pet.indexOf(".")));
            String r_owner = pet.substring(pet.indexOf(".")+1, pet.length());
            String addr = rq.getParameter("addr");
            Date dateAppt = new Date(df.parse(rq.getParameter("dateAppt")).getTime());
            String hh = rq.getParameter("hh")+":"+ rq.getParameter("mm") +":00";
            Time inHour = new Time(tdf.parse(hh).getTime());
            char r_sector = 'H';
            String note = rq.getParameter("note");

            String illness = rq.getParameter("illness");
            String procedures = rq.getParameter("procedures");
            String med = rq.getParameter("med");

            ApptHospitalDAO dao = new ApptHospitalDAO();
            ApptHospital apptH = new ApptHospital(r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, illness, procedures, med);
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.insert(apptH)) {
                out.println("alert('Cita agendada con éxito.');");
            } else {
                out.println("alert('Error al agendar cita!.');");
            }
            out.println("window.location='/Veterinaria/ApptHospR'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
