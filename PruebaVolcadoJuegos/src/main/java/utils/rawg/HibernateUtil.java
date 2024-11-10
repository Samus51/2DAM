package utils.rawg;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;

	/**
	 * M�todo que devuelve el objeto Session.
	 * 
	 * @return
	 *         <ul>
	 *         <li>Si la sesi�n no est� creada: la crea y la abre.</li>
	 *         <li>Si la sesi�n est� creada: simplemente devuelve la sesi�n
	 *         abierta.</li>
	 *         </ul>
	 */
	public static Session getSession() {
		if (sessionFactory == null) {
			session = getSessionFactory().openSession();
		}

		return session;
	}

	/**
	 * M�todo que cierra el objeto Session de HibernateUtil
	 */
	public static void closeSession() {
		Session session = ThreadLocalSessionContext.unbind(sessionFactory);
		if (session != null) {
			session.close();
		}
		closeSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
//			StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
//			sessionFactory = new MetadataSources(sr).buildMetadata().buildSessionFactory();

			sessionFactory = new Configuration().configure("hibernate.cfg.xml") // Cargar la configuraci�n desde el
																				// archivo
					.buildSessionFactory();

		}
		return sessionFactory;
	}

	private static void closeSessionFactory() {
		if ((sessionFactory != null) && (sessionFactory.isClosed() == false)) {
			sessionFactory.close();
		}
	}

}
