/*
 *  
 */
package controler.petServlets;

import data.OwnerDAO;
import data.PetDAO;
import model.Owner;
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

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "PetSeIn", urlPatterns = {"/PetSeIn"})

public class PetSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        PetDAO dao = new PetDAO();
        ArrayList<Pet> pet;
        
        OwnerDAO r_owner = new OwnerDAO();
        ArrayList<Owner> ownr;
        try {
            pet = dao.select();
            ownr = r_owner.select();
            
            rq.getSession().setAttribute("pet", pet);
            rq.getSession().setAttribute("owner", ownr);
            rp.sendRedirect("/Veterinaria/views/petSe.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(PetSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            String name = rq.getParameter("name");
            Date bdate = null;
            if (!rq.getParameter("bdate").equals("")){
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
            if (dao.insert(pet)) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Mascota agregada con éxito.');");
                out.println("window.location='/Veterinaria/views/petSearch.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al agregar mascota!.');");
                out.println("window.location='/Veterinaria/views/petSearch.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(PetSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
