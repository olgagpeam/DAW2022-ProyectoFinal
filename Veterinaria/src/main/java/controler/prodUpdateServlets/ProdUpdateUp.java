/*
 *  
 */
package controler.prodUpdateServlets;

import data.ProdUpdateDAO;
import model.ProdUpdate;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ProdUpdateUp", urlPatterns = {"/ProdUpdateUp"})

public class ProdUpdateUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        int id = Integer.parseInt(rq.getParameter("id"));
        String r_id = rq.getParameter("r_id");
        Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
        //Date date = new Date();
        //Timestamp updatedAt = new Timestamp(date.getTime());
        String r_user = rq.getParameter("r_user");
        String notes = rq.getParameter("notes");
        
        ProdUpdateDAO dao = new ProdUpdateDAO();
        ProdUpdate prodUp = new ProdUpdate(r_id, updatedAt, r_user, notes);
        dao.update(prodUp, id);
    }
}
