/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author garci
 */
public class Clothes {
     private String all_name;
    private float all_price;
    private String all_specification;
    private String all_size;
    private String all_code;

    public Clothes() {
    }

    public Clothes(String all_name, float all_price, String all_specification, String all_size, String all_code) {
        this.all_name = all_name;
        this.all_price = all_price;
        this.all_specification = all_specification;
        this.all_size = all_size;
        this.all_code = all_code;
    }

    /**
     * @return the all_name
     */
    public String getAll_name() {
        return all_name;
    }

    /**
     * @param all_name the all_name to set
     */
    public void setAll_name(String all_name) {
        this.all_name = all_name;
    }

    /**
     * @return the all_price
     */
    public float getAll_price() {
        return all_price;
    }

    /**
     * @param all_price the all_price to set
     */
    public void setAll_price(float all_price) {
        this.all_price = all_price;
    }

    /**
     * @return the all_specification
     */
    public String getAll_specification() {
        return all_specification;
    }

    /**
     * @param all_specification the all_specification to set
     */
    public void setAll_specification(String all_specification) {
        this.all_specification = all_specification;
    }

    /**
     * @return the all_size
     */
    public String getAll_size() {
        return all_size;
    }

    /**
     * @param all_size the all_size to set
     */
    public void setAll_size(String all_size) {
        this.all_size = all_size;
    }

    /**
     * @return the all_code
     */
    public String getAll_code() {
        return all_code;
    }

    /**
     * @param all_code the all_code to set
     */
    public void setAll_code(String all_code) {
        this.all_code = all_code;
    }
    
}
