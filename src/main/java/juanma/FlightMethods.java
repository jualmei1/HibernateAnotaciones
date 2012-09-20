package juanma;

import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;


/**
 * Clase con llamada a metodos 
 *
 */


public class FlightMethods 
{
	private final static Logger log = Logger.getLogger(FlightMethods.class);
	// Se inserta
    Long id = insertFlight();
    
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getLogger("org.hibernate").setLevel(Level.WARN);
        new FlightMethods();
    }
    
    
    public FlightMethods() {
    	listEvents();
    	insertFlight();
    	HibernateUtil.getSession().close();
    }
    
    private Long insertFlight() {
        // Se obtiene la sesion
        Session s = HibernateUtil.getSession();
        s.beginTransaction();

        // Se instancia la clase Flight y se rellenan sus datos
        Flight f = new Flight();
        f.setNombre("Iberia");
        f.setFecha(new Date());
        
        // Se salva en base de datos
        s.save(f);
        s.getTransaction().commit();

        return f.getId();
    }
    private List<Flight> listEvents() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Flight> result = (List<Flight>)session.createQuery("from VUELO").list();
        session.getTransaction().commit();
        for (Flight evento : result) {
            log.info("Leido: "+evento);
        }
        return result;
    }
}
