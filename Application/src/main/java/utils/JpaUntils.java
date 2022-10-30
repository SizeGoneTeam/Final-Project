package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class JpaUntils {
    private static EntityManagerFactory factory;
    public static EntityManager getEntityManager() {
        if(factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("dbbook");
            
        }
        return factory.createEntityManager();
    }
    static public void shutdown() {
        if(factory != null && factory.isOpen()) {
            factory.close();
        }
        factory = null;
    }
    
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dbbook");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
