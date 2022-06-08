/*
 *  
 */

package controler.petServlets;

import controler.ownerServlets.OwnerSeIn;
import data.PetDAO;
import model.Pet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pet;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet (name = "PetUp", urlPatterns = {"/PetUp"})

public class PetUp extends HttpServlet{
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        PetDAO dao = new PetDAO();
        ArrayList<Pet> pet;
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            pet = dao.select();
            String[] result = {"", "", "", "", "", "", "", "", ""};

            PrintWriter out = rp.getWriter();
            for (Pet pt : pet) {
                if (pt.getId() == id) {
                    result[0] = pt.getName();
                    Date bdate = null;
                    result[1] = null;
                    if (pt.getBdate() != null) {
                        bdate = new Date(df.parse(pt.getBdate().toString()).getTime());
                        result[1] = bdate.toString();
                    }
                    result[2] = pt.getSpecie();
                    result[3] = pt.getRace();
                    result[4] = pt.getR_sex() + "";
                    result[5] = pt.getColor();
                    result[6] = pt.getR_owner();
                    result[7] = pt.getOther();
                    result[8] = String.valueOf(id);
                    
                    rq.getSession().setAttribute("result", result);
                    rp.sendRedirect("/Veterinaria/views/petSearch.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('Mascota no encontrada/ID equivocado!');");
                    out.println("window.location='/Veterinaria/views/petUp.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(OwnerSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            int id = Integer.parseInt(rq.getParameter("id"));
            String name = rq.getParameter("name");
            Date bdate = null;
            if (!rq.getParameter("bdate").equals("")) {
                bdate = new Date(df.parse(rq.getParameter("bdate")).getTime());
            }
            String specie = rq.getParameter("specie");
            String race = rq.getParameter("race");
            String sex = rq.getParameter("sex");
            char r_sex = sex.charAt(0);
            String color = rq.getParameter("color");
            String r_ownr = rq.getParameter("r_ownr");
            String other_notes = rq.getParameter("other_notes");

            PetDAO dao = new PetDAO();
            Pet pet = new Pet(name, bdate, specie, race, r_sex, color, r_ownr, other_notes);
            
            PrintWriter out = rp.getWriter();
            if (dao.update(pet, id)) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Mascota actualizada con éxito.');");
                out.println("window.location='/Veterinaria/views/petUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al actualizar mascota!');");
                out.println("window.location='/Veterinaria/views/petUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(PetUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
