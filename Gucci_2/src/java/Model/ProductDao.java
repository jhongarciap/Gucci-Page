/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author garci
 */
public class ProductDao {

    Connection conexion;

    public ProductDao() {
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }

    public List<Product> listProduct() {
    PreparedStatement ps;
    ResultSet rs;
    List<Product> list = new ArrayList<>();
    try {
        ps = conexion.prepareStatement("SELECT all_code, all_name, all_amount, all_price, all_specifications FROM all_products");
        rs = ps.executeQuery();
        while (rs.next()) {
            String code = rs.getString("all_code");
            String name = rs.getString("all_name");
            int amount = rs.getInt("all_amount");
            float price = rs.getFloat("all_price");
            String specifications = rs.getString("all_specifications");

            Product product = new Product(code, name, amount, price, specifications);
            list.add(product);
        }
        return list;
    } catch (SQLException e) {
        System.out.println(e.toString());
        return null;
    }
}

    
    public Product viewProduct(String _code) {

        PreparedStatement ps;
        ResultSet rs;
        Product product = null;
        try {
            ps = conexion.prepareStatement("SELECT all_code, all_name, all_amount, all_price, all_specifications FROM all_products WHERE all_code=?");
            ps.setString(1, _code);
            rs = ps.executeQuery();
            while (rs.next()) {
                String code = rs.getString("all_code");
                String name = rs.getString("all_name");
                int amount = rs.getInt("all_amount");
                float price = rs.getFloat("all_price");
                String specifications = rs.getString("all_specifications");

                 product = new Product(code, name, amount, price, specifications);

            }
            return product;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
   
    public boolean insertProduct(Product product) {

        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("INSERT INTO all_products (all_code, all_name, all_amount, all_price, all_specifications)  Values (?,?,?,?,?)");
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getAmount());
            ps.setFloat(4, product.getPrice());
            ps.setString(5, product.getSpecifications());
            ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean updateProduct(Product product) {

        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("UPDATE all_products SET all_name=?, all_amount=?, all_price=?, all_specifications=? WHERE all_code=?");
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getAmount());
            ps.setFloat(4, product.getPrice());
            ps.setString(5, product.getSpecifications());
            ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean deleteProduct(String _code) {

        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("DELETE FROM all_products WHERE all_code=?");
            ps.setString(1, _code);
            ps.execute();
           return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
