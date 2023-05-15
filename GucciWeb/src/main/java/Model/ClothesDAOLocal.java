/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package Model;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author garci
 */
@Local
public interface ClothesDAOLocal {

    void add_Clothes(Clothes clothes);

    void edit_Clothes(Clothes clothes);

    void delete_Clothes(int clothes);

    Clothes get_Clothes(int clothes);

    public List<Clothes> get_AllClothes(Clothes clothes);

}
