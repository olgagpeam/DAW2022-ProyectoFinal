/*
 *  
 */
package controler.sectorServlets;

import data.SectorDAO;
import model.Sector;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alarcon Olga
 */
@WebServlet(name = "SectorUp", urlPatterns = {"/SectorUp"})

public class SectorUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        
        String id = rq.getParameter("id");
        String sector = rq.getParameter("sector");

        SectorDAO dao = new SectorDAO();
        Sector sec = new Sector(sector);
        dao.update(sec, id);
    }
}
