
package juanma;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**Clase de utilidad para obtener la sesion de hibernate.
 * @author jmalmeida
 *
 */
public class HibernateUtil {
	
	 private static final SessionFactory sessionFactory;
	 
	 static{
		 try{
			 //Cargamos el fichero de configuracion hibernate
			 sessionFactory = new AnnotationConfiguration().configure("/juanma/hibernateAnnotations.cfg.xml").buildSessionFactory();
			 
		 	}catch (Throwable ex) {
		            // 
		            System.err.println("Fallo al iniciar el SessionFactory." + ex);
		            throw new ExceptionInInitializerError(ex);
			 
		 	}
		
		    }
	 public static Session getSession() throws HibernateException {
	        return sessionFactory.openSession();
	    }
}
