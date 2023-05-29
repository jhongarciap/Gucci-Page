/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Model.Product;
import Model.ProductDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author garci
 */
public class ProductosController extends HttpServlet {

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDao productDao = new ProductDao();
        String action;
        RequestDispatcher dispatcher = null;

        action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            dispatcher = request.getRequestDispatcher("ViewTable.jsp");
            List<Product> listProduct = productDao.listProduct();
            request.setAttribute("list", listProduct);
        } else if ("add".equals(action)) {
            dispatcher = request.getRequestDispatcher("add.jsp");

        } else if ("insert".equals(action)) {
            String code = request.getParameter("all_code");
            String name = request.getParameter("all_name");
            String amountParam = request.getParameter("all_amount");
            String priceParam = request.getParameter("all_price");
            String specifications = request.getParameter("all_specifications");

            int amount;
            float price;

            if (isNumeric(amountParam) && isNumeric(priceParam) && 0<code.length()&& code.length()<=3) {
                amount = Integer.parseInt(amountParam);
                price = Float.parseFloat(priceParam);

                Product product = new Product(code, name, amount, price, specifications);

                productDao.insertProduct(product);

                dispatcher = request.getRequestDispatcher("ViewTable.jsp");
            } else {
                String errorMessage = "Los campos de cantidad y precio deben ser valores numéricos, además, el código debe ser de 3 carácteres";
                request.setAttribute("errorMessage", errorMessage);

                String script = "<script>alert('" + errorMessage + "');</script>";
                request.setAttribute("script", script);
                request.getRequestDispatcher("add.jsp").forward(request, response);


            }
        } else if ("delete".equals(action)) {

            String code = request.getParameter("code"); // Obtén el código del producto a eliminar

            boolean deletionSuccess = productDao.deleteProduct(code); // Llama al método deleteProduct del ProductDao

            if (deletionSuccess) {
                System.out.println("Producto eliminado con éxito");
            } else {
                System.out.println("Error al eliminar el producto");
            }

            dispatcher = request.getRequestDispatcher("ViewTable.jsp");
            List<Product> listProduct = productDao.listProduct();
            request.setAttribute("list", listProduct);

        } else {
            dispatcher = request.getRequestDispatcher("index.html");
        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
