/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package Model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author garci
 */
@Stateless
public class ClothesDAO implements ClothesDAOLocal {
    @PersistenceContext
private EntityManager em;

    @Override
    public void add_Clothes(Clothes clothes) {
        em.persist(clothes);
    }

    @Override
    public void edit_Clothes(Clothes clothes) {
        em.merge(clothes);
    }

    @Override
    public void delete_Clothes(int all_code) {
        em.remove(get_Clothes(all_code));
    }

    @Override
    public Clothes get_Clothes(int all_code) {
        return em.find(Clothes.class, all_code);
    }

    @Override
    public List<Clothes> get_AllClothes(Clothes clothes) {
        return em.createNamedQuery("clothes.getAll").getResultList();
    }


}
