/*
 *  
 */
package controler.apptHospitalServlets;

import data.ApptHospitalDAO;
import data.MedUpdateDAO;
import data.OwnerDAO;
import data.PetDAO;
import data.UserDAO;
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
import model.ApptHospital;
import model.MedUpdate;
import model.Owner;
import model.Pet;
import model.User;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptHospitalUp", urlPatterns = {"/ApptHospitalUp"})

public class ApptHospitalUp extends HttpServlet {

    SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptHospitalDAO dao = new ApptHospitalDAO();
        ArrayList<ApptHospital> hos;

        OwnerDAO r_owner = new OwnerDAO();
        ArrayList<Owner> ownr;

        PetDAO r_pet = new PetDAO();
        ArrayList<Pet> pet;

        UserDAO r_user = new UserDAO();
        ArrayList<User> usr;

        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            hos = dao.select();
            ownr = r_owner.select();
            pet = r_pet.select();
            usr = r_user.select();
            String[] apptHRes = {"", "", "", "", "", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (ApptHospital hs : hos) {
                if (hs.getId() == id) {
                    apptHRes[0] = String.valueOf(id);
                    apptHRes[1] = hs.getR_user();
                    apptHRes[2] = hs.getR_owner();
                    apptHRes[3] = String.valueOf(hs.getR_pet());
                    apptHRes[4] =  hs.getAddr();
                    Date date = null;
                    apptHRes[5] = null;
                    if (hs.getDateAppt()!= null) {
                        date = new Date(df.parse(hs.getDateAppt().toString()).getTime());
                        apptHRes[5] = date.toString();
                    }
                    Time hour = null;
                    apptHRes[6] = null;
                    if (hs.getInHour()!= null) {
                        hour = new Time(tdf.parse(hs.getInHour().toString()).getTime());
                        apptHRes[6] = hour.toString();
                    }
                    apptHRes[7] = hs.getNote();
                    
                    apptHRes[8] = hs.getIllness();
                    apptHRes[9] = hs.getProcedures();
                    apptHRes[10] = hs.getMed();

                    rq.getSession().setAttribute("apptHRes", apptHRes);
                    rq.getSession().setAttribute("owner", ownr);
                    rq.getSession().setAttribute("pet", pet);
                    rq.getSession().setAttribute("user", usr);
                    rp.sendRedirect("/Veterinaria/views/apptSearchH.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Cita no encontrada/ID equivocado!');");
                    out.println("window.location='/Veterinaria/views/apptUpH.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            String r_user = rq.getParameter("r_user");
            //String r_owner = rq.getParameter("r_owner");
           // int r_pet = Integer.parseInt(rq.getParameter("r_pet"));
            String addr = rq.getParameter("addr");
            Date dateAppt = new Date(df.parse(rq.getParameter("dateAppt")).getTime());
            String hh = rq.getParameter("hh") + ":" + rq.getParameter("mm") + ":00";
            Time inHour = new Time(tdf.parse(hh).getTime());
            //String sector = rq.getParameter("sector");
            //char r_sector = sector.charAt(0);
            String note = rq.getParameter("note");

            String illness = rq.getParameter("illness");
            String procedures = rq.getParameter("procedures");
            String med = rq.getParameter("med");

            ApptHospitalDAO dao = new ApptHospitalDAO();
            ApptHospital apptH = new ApptHospital(r_user, addr, dateAppt, inHour, note, illness, procedures, med);
            
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            MedUpdateDAO daoUp = new MedUpdateDAO();
            MedUpdate medUp = new MedUpdate(id, updatedAt, r_user, "Observaciones:" + note);
            
            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(apptH, id)) {
                daoUp.insert(medUp);
                out.println("alert('Cita actualizada con éxito.');");
            } else {
                out.println("alert('Error al actualizar Cita!');");
            }
            out.println("window.location='/Veterinaria/views/apptUpH.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptHospitalUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
