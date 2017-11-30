package modelo.dao;

import Services.Funciones;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.entidad.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "Hospital-Loayza-V1.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario login(Usuario usu) {
        Usuario user = null;
        String password = Funciones.encriptar(usu.getPwdusu());
        String jpql = "SELECT u FROM Usuario u WHERE u.usuusu = :usuusu and u.pwdusu = :pwdusu";
        Query q = em.createQuery(jpql);
        q.setParameter("usuusu", usu.getUsuusu());
        q.setParameter("pwdusu", password);
        List<Usuario> lstUser = q.getResultList();
        if (lstUser.size() > 0) {
            user = lstUser.get(0);
        }
        return user;
    }
}
