package orm;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * <code>DataInit</code>Allows to initialize the database by creating the base sport_d2 in order to receive the tables.
 * <strong>NOTE:</strong>
 *This class<code>DataInit </code> is a motor class .
 *
 * @author  Alexander BUBB
 * @author Daniel François
 * @author Julien VEYSSEYRE
 * @author Seruche MPOU EKOUYA
 */
public class DataInit {

	public static void createTables() {
		AnnotationConfiguration config = DBConnection.getConfig();
		SchemaExport schemaExport = new SchemaExport(config);
		schemaExport.create(true, true);
	}
}
