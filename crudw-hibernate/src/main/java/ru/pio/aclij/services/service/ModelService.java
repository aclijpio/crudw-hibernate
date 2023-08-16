package ru.pio.aclij.services.service;

import lombok.Getter;
import org.hibernate.Session;
import ru.pio.aclij.models.Model;

@Getter
public abstract class ModelService {
    Session session;

    public ModelService(Session session) {
        this.session = session;
    }
    public final void close(){
        this.session.close();
    }
    public void begin(){
        this.session.beginTransaction();
    }
    public void save(Model model){
        this.session.persist(model);
    }
    public void remove(Model model){
        this.session.remove(model);
    }
    public Model get(Class<Model> modelClass, int id){
        return this.session.get(modelClass,  id);
    }
    public void commit(){
        this.session.getTransaction().commit();
    }

}
