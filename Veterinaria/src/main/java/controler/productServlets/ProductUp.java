/*
 *  
 */
package controler.productServlets;

import data.CategoryDAO;
import data.ProductDAO;
import model.Category;
import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ProductUp", urlPatterns = {"/ProductUp"})

public class ProductUp extends HttpServlet {

    String[] result = null;

    //Para buscar producto por id para editar sus datos
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rp) throws IOException {
        ProductDAO dao = new ProductDAO();
        CategoryDAO r_category = new CategoryDAO();
        ArrayList<Category> cat;
        try {
            String id = rq.getParameter("id");
            String button = rq.getParameter("search");
            result = dao.selectOnly(id);
            cat = r_category.select();

            PrintWriter out = rp.getWriter();
            //apartado para añadir y retirar unidades del stock
            //ADD para añadir   DEL para retirar
            //cualquier otro es para editar toda la info
            if (button.equals("ADD") || button.equals("DEL")) {
                if (button.equals("ADD")) {
                    if (result[0].equals("404NotFound")) {
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<script>");
                        out.println("alert('Producto no encontrado/ID equivocado!');");
                        out.println("window.location='/Veterinaria/views/productADD.jsp'");
                        out.println("</script>");
                        out.println("</head>");
                        out.println("</html>");
                    } else if (result != null || result.length < 0) {
                        rq.getSession().setAttribute("resADD", result);
                        rq.getSession().setAttribute("cat", cat);
                        rp.sendRedirect("/Veterinaria/views/productADD.jsp");
                    } else {
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<script>");
                        out.println("alert('Error al buscar producto!');");
                        out.println("window.location='/Veterinaria/views/productADD.jsp'");
                        out.println("</script>");
                        out.println("</head>");
                        out.println("</html>");
                    }
                } else if (button.equals("DEL")) {
                    if (result[0].equals("404NotFound")) {
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<script>");
                        out.println("alert('Producto no encontrado/ID equivocado!');");
                        out.println("window.location='/Veterinaria/views/productDE.jsp'");
                        out.println("</script>");
                        out.println("</head>");
                        out.println("</html>");
                    } else if (result != null || result.length < 0) {
                        rq.getSession().setAttribute("resDEL", result);
                        rq.getSession().setAttribute("cat", cat);
                        rp.sendRedirect("/Veterinaria/views/productDE.jsp");
                    } else {
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<script>");
                        out.println("alert('Error al buscar producto!');");
                        out.println("window.location='/Veterinaria/views/productDE.jsp'");
                        out.println("</script>");
                        out.println("</head>");
                        out.println("</html>");
                    }
                }
            } else if (result[0].equals("404NotFound")) {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Producto no encontrado/ID equivocado!');");
                out.println("window.location='/Veterinaria/views/productUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else if (result != null || result.length > 0) {
                rq.getSession().setAttribute("result", result);
                rq.getSession().setAttribute("cat", cat);
                rp.sendRedirect("/Veterinaria/views/productSearch.jsp");
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                out.println("alert('Error al buscar producto!');");
                out.println("window.location='/Veterinaria/views/productUp.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            }
        } catch (ParseException ex) {
            Logger.getLogger(ProductUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Para editar los datos en la base de datos
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException {

        String button = rq.getParameter("up");
        String id = rq.getParameter("id");
        int inStock = (rq.getParameter("inStock").equals("")) ? 0 : Integer.valueOf(rq.getParameter("inStock"));
        PrintWriter out = rp.getWriter();
        result = null;
        //Apartado de add y del para solo agregar o retirar unidades del stock
        //el restante es para la edicion de todos los datos
        if (button.equals("add") || button.equals("del")) {
            rq.getSession().setAttribute("resDEL", result);
            rq.getSession().setAttribute("resADD", result);
            int upStock = (rq.getParameter("upStock").equals("")) ? 0 : Integer.valueOf(rq.getParameter("upStock"));
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            ProductDAO dao = new ProductDAO();

            if (button.equals("add")) {
                inStock += upStock;
                Product add = new Product(inStock, updatedAt);
                out.println("<html>");
                out.println("<head>");
                out.println("<script>");
                if (dao.updateADD(add, id)) {
                    out.println("alert('Unidades añadidas con éxito.');");
                } else {
                    out.println("alert('Error al añadir unidades al producto!');");
                }
                out.println("window.location='/Veterinaria/views/productADD.jsp'");
                out.println("</script>");
                out.println("</head>");
                out.println("</html>");
            } else if (button.equals("del")) {
                int minStock = (rq.getParameter("minStock").equals("")) ? 0 : Integer.valueOf(rq.getParameter("minStock"));
                if (inStock - upStock < 0) {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    out.println("alert('No puede retirar mas unidades de las disponibles en inventario!');");
                    out.println("window.location='/Veterinaria/views/productDE.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                } else {
                    inStock -= upStock;
                    Product del = new Product(inStock, updatedAt);

                    out.println("<html>");
                    out.println("<head>");
                    out.println("<script>");
                    if (dao.updateADD(del, id)) {
                        if (inStock <= minStock) {
                            out.println("alert('Unidades retiradas con éxito. Se recomienda resurtir inventario. Unidades minimas!');");
                        } else {
                            out.println("alert('Unidades retiradas con éxito.');");
                        }
                    } else {
                        out.println("alert('Error al retirar unidades del producto!');");
                    }
                    out.println("window.location='/Veterinaria/views/productDE.jsp'");
                    out.println("</script>");
                    out.println("</head>");
                    out.println("</html>");
                }
            }
        } else {
            String name = rq.getParameter("name");
            String description = rq.getParameter("description");
            int minStock = ("".equals(rq.getParameter("minStock"))) ? 0 : Integer.parseInt(rq.getParameter("minStock"));
            float priceIn = ("".equals(rq.getParameter("priceIn"))) ? -1 : Float.parseFloat(rq.getParameter("priceIn"));
            float priceOut = ("".equals(rq.getParameter("priceOut"))) ? -1 : Float.parseFloat(rq.getParameter("priceOut"));
            int r_category = ("".equals(rq.getParameter("r_category"))) ? 0 : Integer.parseInt(rq.getParameter("r_category"));
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            boolean isActive = ((rq.getParameter("isActive")).equals("si"));
            ProductDAO dao = new ProductDAO();
            Product prod = new Product(name, description, inStock, minStock, priceIn, priceOut, r_category, updatedAt, isActive);

            out.println("<html>");
            out.println("<head>");
            out.println("<script>");
            if (dao.update(prod, id)) {
                out.println("alert('Producto actualizado con éxito.');");
            } else {
                out.println("alert('Error al actualizar producto!');");
            }
            out.println("window.location='/Veterinaria/views/productUp.jsp'");
            out.println("</script>");
            out.println("</head>");
            out.println("</html>");
        }
    }
}
