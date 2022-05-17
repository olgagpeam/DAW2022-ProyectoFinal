/*
 *  
 */
package controler.prodUpdateServlets;

import data.ProdUpdateDAO;
import model.ProdUpdate;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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
@WebServlet(name = "ProdUpdateSeIn", urlPatterns = {"/ProdUpdateSeIn"})

public class ProdUpdateSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ProdUpdateDAO dao = new ProdUpdateDAO();
        ArrayList<ProdUpdate> prodUp;
        try {
            prodUp = dao.select();
            rq.getSession().setAttribute("prodUp", prodUp);
            rp.sendRedirect("/Veterinaria/views/ProdUpdateConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(ProdUpdateSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            String r_id = rq.getParameter("r_id");
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            //Date date = new Date();
            //Timestamp updatedAt = new Timestamp(date.getTime());
            String r_user = rq.getParameter("r_user");

            ProdUpdateDAO dao = new ProdUpdateDAO();
            ProdUpdate prodUp = new ProdUpdate(r_id, updatedAt, r_user);
            dao.insert(prodUp);
        } catch (ParseException ex) {
            Logger.getLogger(ProdUpdateSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
