/*
 *  
 */
package controler.medUpdateServlets;

import data.MedUpdateDAO;
import model.MedUpdate;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "MedUpdateUp", urlPatterns = {"/MedUpdateUp"})

public class MedUpdateUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        int r_id = Integer.parseInt(rq.getParameter("r_id"));
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        //Date date = new Date();
        //Timestamp updatedAt = new Timestamp(date.getTime());
        String r_user = rq.getParameter("r_user");
        String updates = rq.getParameter("updates");

        MedUpdateDAO dao = new MedUpdateDAO();
        MedUpdate medUp = new MedUpdate(r_id, updatedAt, r_user, updates);
        dao.update(medUp, id);
    }
}
