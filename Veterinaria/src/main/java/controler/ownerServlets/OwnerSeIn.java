/*
 *  
 */
package controler.ownerServlets;

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
@WebServlet(name = "OwnerSeIn", urlPatterns = {"/OwnerSeIn"})

public class OwnerSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        OwnerDAO dao = new OwnerDAO();
        ArrayList<Owner> ownr;
        try {
            ownr = dao.select();
            rq.getSession().setAttribute("owner", ownr);
            rp.sendRedirect("/Veterinaria/views/OwnerConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(OwnerSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
            String ine = rq.getParameter("ine");
            String name = rq.getParameter("name");
            Date bdate = new Date(df.parse(rq.getParameter("bdate")).getTime());
            String addr = rq.getParameter("addr");
            String tel = rq.getParameter("cel");
            String cel = rq.getParameter("tel");
            String email = rq.getParameter("email");

            OwnerDAO dao = new OwnerDAO();
            Owner ownr = new Owner(ine, name, bdate, addr, tel, cel, email);
            dao.insert(ownr);
        } catch (ParseException ex) {
            Logger.getLogger(OwnerSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
