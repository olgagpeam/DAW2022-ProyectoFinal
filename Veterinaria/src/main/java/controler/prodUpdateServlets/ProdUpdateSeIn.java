/*
 *  
 */
package controler.prodUpdateServlets;

import data.ProdUpdateDAO;
import data.ProductDAO;
import model.ProdUpdate;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "ProdUpdateSeIn", urlPatterns = {"/ProdUpdateSeIn"})

public class ProdUpdateSeIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ProdUpdateDAO daoUp = new ProdUpdateDAO();
        ArrayList<ProdUpdate> prodUp;
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> prod;
        try {
            prodUp = daoUp.select();
            prod = dao.select();
            rq.getSession().setAttribute("prodUp", prodUp);
            rq.getSession().setAttribute("prod", prod);
            rp.sendRedirect("/Veterinaria/views/productUpdateSe.jsp");
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
            String notes = rq.getParameter("notes");
            ProdUpdateDAO dao = new ProdUpdateDAO();
            ProdUpdate prodUp = new ProdUpdate(r_id, updatedAt, r_user, notes);
            dao.insert(prodUp);
        } catch (ParseException ex) {
            Logger.getLogger(ProdUpdateSeIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
