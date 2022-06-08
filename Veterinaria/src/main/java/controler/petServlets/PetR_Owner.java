/*
 *  
 */

package controler.petServlets;

import data.OwnerDAO;
import model.Owner;
import java.io.IOException;
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
@WebServlet(name = "PetR_Owner", urlPatterns = {"/PetR_Owner"})

public class PetR_Owner extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        OwnerDAO dao = new OwnerDAO();
        ArrayList<Owner> ownr;
        try {
            ownr = dao.select();
            rq.getSession().setAttribute("owner", ownr);
            rp.sendRedirect("/Veterinaria/views/petIn.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(PetSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}