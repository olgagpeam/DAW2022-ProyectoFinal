/*
 *  
 */
package controler.apptSalonServlets;

import data.ApptSalonDAO;
import data.OwnerDAO;
import data.PetDAO;
import data.ServiceDAO;
import data.UserDAO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApptSalon;
import model.Owner;
import model.Pet;
import model.Service;
import model.User;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ApptSalonUp", urlPatterns = {"/ApptSalonUp"})

public class ApptSalonUp extends HttpServlet {

    SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ApptSalonDAO dao = new ApptSalonDAO();
        ArrayList<ApptSalon> sal;

        OwnerDAO r_owner = new OwnerDAO();
        ArrayList<Owner> ownr;

        PetDAO r_pet = new PetDAO();
        ArrayList<Pet> pet;

        UserDAO r_user = new UserDAO();
        ArrayList<User> usr;

        ServiceDAO r_serv = new ServiceDAO();
        ArrayList<Service> serv;

        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            sal = dao.select();
            ownr = r_owner.select();
            pet = r_pet.select();
            usr = r_user.select();
            serv = r_serv.select();
            String[] apptSRes = {"", "", "", "", "", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (ApptSalon sl : sal) {
                if (sl.getId() == id) {
                    apptSRes[0] = String.valueOf(id);
                    apptSRes[1] = sl.getR_user();
                    apptSRes[2] = sl.getR_owner();
                    apptSRes[3] = String.valueOf(sl.getR_pet());
                    apptSRes[4] = sl.getAddr();
                    Date date = null;
                    apptSRes[5] = null;
                    if (sl.getDateAppt() != null) {
                        date = new Date(df.parse(sl.getDateAppt().toString()).getTime());
                        apptSRes[5] = date.toString();
                    }
                    Time hour = null;
                    apptSRes[6] = null;
                    if (sl.getInHour() != null) {
                        hour = new Time(tdf.parse(sl.getInHour().toString()).getTime());
                        apptSRes[6] = hour.toString();
                    }
                    apptSRes[7] = sl.getNote();

                    apptSRes[8] = String.valueOf(sl.getR_service());
                    Time outhour = null;
                    apptSRes[9] = null;
                    if (sl.getOutHour() != null) {
                        outhour = new Time(tdf.parse(sl.getOutHour().toString()).getTime());
                        apptSRes[9] = outhour.toString();
                    }
                    apptSRes[10] = sl.getProducts();

                    rq.getSession().setAttribute("apptSRes", apptSRes);
                    rq.getSession().setAttribute("owner", ownr);
                    rq.getSession().setAttribute("pet", pet);
                    rq.getSession().setAttribute("user", usr);
                    rq.getSession().setAttribute("serv", serv);
                    rp.sendRedirect("/Veterinaria/views/apptSearchS.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Cita no encontrada/ID equivocado!');");
                    out.println("window.location='/Veterinaria/views/apptUpS.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonUp.class.getName()).log(Level.SEVERE, null, ex);
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

            int r_service = Integer.parseInt(rq.getParameter("r_service"));

            String hhO = ((rq.getParameter("hhO").equals("")) ? "00" : rq.getParameter("hhO")) + ":"
                    + ((rq.getParameter("mmO").equals("")) ? "00" : rq.getParameter("mmO")) + ":00";
            Time outHour = new Time(tdf.parse(hhO).getTime());
            String products = rq.getParameter("products");

            ApptSalonDAO dao = new ApptSalonDAO();
            ApptSalon apptS = new ApptSalon(r_user, addr, dateAppt, inHour, note, r_service, outHour, products);

            PrintWriter out = rp.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(apptS, id)) {
                out.println("alert('Cita actualizada con éxito.');");
            } else {
                out.println("alert('Error al actualizar Cita!');");
            }
            out.println("window.location='/Veterinaria/views/apptUpS.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
