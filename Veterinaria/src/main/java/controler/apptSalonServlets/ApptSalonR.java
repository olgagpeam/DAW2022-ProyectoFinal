/*
 *  
 */

package controler.apptSalonServlets;

import data.OwnerDAO;
import data.PetDAO;
import data.UserDAO;
import model.Owner;
import model.Pet;
import model.User;
import java.io.IOException;
import java.text.ParseException;
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
@WebServlet(name = "ApptSalonR", urlPatterns = {"/ApptSalonR"})

public class ApptSalonR extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        OwnerDAO daoO = new OwnerDAO();
        ArrayList<Owner> ownr;
        
        PetDAO daoP = new PetDAO();
        ArrayList<Pet> pt;
        
        UserDAO daoU = new UserDAO();
        ArrayList<User> usr;
        
        try {
            ownr = daoO.select();
            pt = daoP.select();
            usr = daoU.select();
            rq.getSession().setAttribute("owner", ownr);
            rq.getSession().setAttribute("pet", pt);
            rq.getSession().setAttribute("user", usr);
            rp.sendRedirect("/Veterinaria/views/apptInS.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ApptSalonR.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
