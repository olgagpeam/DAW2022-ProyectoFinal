/*
 *  
 */
package controler.apptConsultServlets;

import data.ApptConsultDAO;
import data.MedUpdateDAO;
import data.OwnerDAO;
import data.PetDAO;
import data.UserDAO;
import model.ApptConsult;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.MedUpdate;
import model.Owner;
import model.Pet;
import model.User;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptConsultUp", urlPatterns = {"/ApptConsultUp"})

public class ApptConsultUp extends HttpServlet {

    SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptConsultDAO dao = new ApptConsultDAO();
        ArrayList<ApptConsult> cons;

        OwnerDAO r_owner = new OwnerDAO();
        ArrayList<Owner> ownr;

        PetDAO r_pet = new PetDAO();
        ArrayList<Pet> pet;

        UserDAO r_user = new UserDAO();
        ArrayList<User> usr;

        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            cons = dao.select();
            ownr = r_owner.select();
            pet = r_pet.select();
            usr = r_user.select();
            String[] apptCRes = {"", "", "", "", "", "", "", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (ApptConsult cns : cons) {
                if (cns.getId() == id) {
                    apptCRes[0] = String.valueOf(id);
                    apptCRes[1] = cns.getR_user();
                    apptCRes[2] = cns.getR_owner();
                    apptCRes[3] = String.valueOf(cns.getR_pet());
                    apptCRes[4] =  cns.getAddr();
                    Date date = null;
                    apptCRes[5] = null;
                    if (cns.getDateAppt()!= null) {
                        date = new Date(df.parse(cns.getDateAppt().toString()).getTime());
                        apptCRes[5] = date.toString();
                    }
                    Time hour = null;
                    apptCRes[6] = null;
                    if (cns.getInHour()!= null) {
                        hour = new Time(tdf.parse(cns.getInHour().toString()).getTime());
                        apptCRes[6] = hour.toString();
                    }
                    apptCRes[7] = cns.getNote();
                    
                    apptCRes[8] = cns.getR_consult();
                    apptCRes[9] = cns.getAddrRef();
                    apptCRes[10] = cns.getDiagnosis();
                    apptCRes[11] = cns.getProcedures();
                    apptCRes[12] = cns.getMed();

                    rq.getSession().setAttribute("apptCRes", apptCRes);
                    rq.getSession().setAttribute("owner", ownr);
                    rq.getSession().setAttribute("pet", pet);
                    rq.getSession().setAttribute("user", usr);
                    rp.sendRedirect("/Veterinaria/views/apptSearchC.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Cita no encontrada/ID equivocado!');");
                    out.println("window.location='/Veterinaria/views/apptUpC.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ApptConsultUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            String r_user = rq.getParameter("r_user");
            //String r_owner = rq.getParameter("r_owner");
            //int r_pet = Integer.parseInt(rq.getParameter("r_pet"));
            String addr = rq.getParameter("addr");
            Date dateAppt = new Date(df.parse(rq.getParameter("dateAppt")).getTime());
            String hh = rq.getParameter("hh") + ":" + rq.getParameter("mm") + ":00";
            Time inHour = new Time(tdf.parse(hh).getTime());
            //String sector = rq.getParameter("sector");
            //char r_sector = sector.charAt(0);
            String note = rq.getParameter("note");

            String r_consult = rq.getParameter("r_consult");
            String addrRef = rq.getParameter("addrRef");
            String diagnosis = rq.getParameter("diagnosis");
            String procedures = rq.getParameter("procedures");
            String med = rq.getParameter("med");

            ApptConsultDAO dao = new ApptConsultDAO();
            ApptConsult apptC = new ApptConsult(r_user, addr, dateAppt, inHour, note, r_consult, addrRef, diagnosis, procedures, med);
            
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            MedUpdateDAO daoUp = new MedUpdateDAO();
            MedUpdate medUp = new MedUpdate(id, updatedAt, r_user, ("Observaciones:" + note));
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(apptC, id)) {
                daoUp.insert(medUp);
                out.println("alert('Cita actualizada con éxito.');");
            } else {
                out.println("alert('Error al actualizar Cita!');");
            }
            out.println("window.location='/Veterinaria/views/apptUpC.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptConsultUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
