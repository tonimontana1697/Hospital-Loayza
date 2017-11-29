package controlador;

import modelo.entidad.Ubigeo;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import modelo.dao.UbigeoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("ubigeoController")
@SessionScoped
public class UbigeoController implements Serializable {

    @EJB
    private modelo.dao.UbigeoFacade ejbFacade;
    private List<Ubigeo> lstdpt;
    private List<Ubigeo> lstprov;
    private List<Ubigeo> lstdist;
    private Ubigeo dptSeleccionado; // objeto seleccionado departamento
    private Ubigeo proSeleccionado; // objeto seleccionado provincia
    private Ubigeo disSeleccionado; // objeto seleccionado distrito
    private List<Ubigeo> items = null;
    private Ubigeo selected;
    String ver;
    
    public UbigeoController() {
    }

    public Ubigeo getSelected() {
        return selected;
    }

    public void setSelected(Ubigeo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UbigeoFacade getFacade() {
        return ejbFacade;
    }

    public Ubigeo prepareCreate() {
        selected = new Ubigeo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Vista").getString("UbigeoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Vista").getString("UbigeoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Vista").getString("UbigeoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ubigeo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Vista").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Ubigeo getUbigeo(java.lang.String id) {
        return getFacade().find(id);
    }

    public List<Ubigeo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ubigeo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ubigeo.class)
    public static class UbigeoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UbigeoController controller = (UbigeoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ubigeoController");
            return controller.getUbigeo(getKey(value));
        }

        java.lang.String getKey(String value) {
            java.lang.String key;
            key = value;
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Ubigeo) {
                Ubigeo o = (Ubigeo) object;
                return getStringKey(o.getUbigeo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ubigeo.class.getName()});
                return null;
            }
        }

    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public UbigeoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(UbigeoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public List<Ubigeo> getLstdpt() {
        return lstdpt;
    }

    public void setLstdpt(List<Ubigeo> lstdpt) {
        this.lstdpt = lstdpt;
    }

    public List<Ubigeo> getLstprov() {
        return lstprov;
    }

    public void setLstprov(List<Ubigeo> lstprov) {
        this.lstprov = lstprov;
    }

    public List<Ubigeo> getLstdist() {
        return lstdist;
    }

    public void setLstdist(List<Ubigeo> lstdist) {
        this.lstdist = lstdist;
    }

    public Ubigeo getDptSeleccionado() {
        return dptSeleccionado;
    }

    public void setDptSeleccionado(Ubigeo dptSeleccionado) {
        this.dptSeleccionado = dptSeleccionado;
    }

    public Ubigeo getProSeleccionado() {
        return proSeleccionado;
    }

    public void setProSeleccionado(Ubigeo proSeleccionado) {
        this.proSeleccionado = proSeleccionado;
    }

    public Ubigeo getDisSeleccionado() {
        return disSeleccionado;
    }

    public void setDisSeleccionado(Ubigeo disSeleccionado) {
        this.disSeleccionado = disSeleccionado;
    }
    
    public void listardpt(){
        lstdpt=ejbFacade.listarDepartamento();
    }
    
    public void cambioProvincia(){
        lstprov = ejbFacade.listarProvincia(dptSeleccionado);
    }
    
    public void cambioDistrito(){
        lstdist = ejbFacade.listarDistrito(proSeleccionado);
    }
    
    @PostConstruct
    public void iniciar(){
        try{
            listardpt();
            setLstprov(null);
            setLstdist(null);
        } catch (Exception e){
        }
    }

}
