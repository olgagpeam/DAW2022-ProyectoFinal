/*
 *  
 */
package controler.medUpdateServlets;

import data.MedUpdateDAO;
import model.MedUpdate;
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
@WebServlet(name = "MedUpdateSeIn", urlPatterns = {"/MedUpdateSeIn"})

public class MedUpdateSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        MedUpdateDAO dao = new MedUpdateDAO();
        ArrayList<MedUpdate> medUp;
        try {
            medUp = dao.select();
            rq.getSession().setAttribute("medUp", medUp);
            rp.sendRedirect("/Veterinaria/views/MedUpdateConsulta.jsp");
        } catch (ParseException ex) {
            Logger.getLogger(MedUpdateSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        try {
            int r_id = Integer.parseInt(rq.getParameter("r_id"));
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            //Date date = new Date();
            //Timestamp updatedAt = new Timestamp(date.getTime());
            String r_user = rq.getParameter("r_user");
            String updates = rq.getParameter("updates");

            MedUpdateDAO dao = new MedUpdateDAO();
            MedUpdate medUp = new MedUpdate(r_id, updatedAt, r_user, updates);
            dao.insert(medUp);
        } catch (ParseException ex) {
            Logger.getLogger(MedUpdateSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
