/*
 *  
 */
package controler.apptSalonServlets;

import data.ApptConsultDAO;
import data.ApptHospitalDAO;
import data.ApptSalonDAO;
import model.ApptSalon;
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
import model.ApptConsult;
import model.ApptHospital;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptSalonSeIn", urlPatterns = {"/ApptSalonSeIn"})

public class ApptSalonSeIn extends HttpServlet {

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
            Logger.getLogger(ApptSalonSeIn.class.getName()).log(Level.SEVERE, null, ex);
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
            char r_sector = 'S';
            String note = rq.getParameter("note");

            int r_service = Integer.parseInt(rq.getParameter("r_service"));
            //Time outHour = new Time(tdf.parse(rq.getParameter("outHour")).getTime());
            //String products = rq.getParameter("products");
            Time outHour = null;
            String products = null;

            ApptSalonDAO dao = new ApptSalonDAO();
            ApptSalon apptS = new ApptSalon(r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_service , outHour, products);
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.insert(apptS)) {
                out.println("alert('Cita agendada con éxito.');");
            } else {
                out.println("alert('Error al agendar cita!.');");
            }
            out.println("window.location='/Veterinaria/ApptSalonR'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
