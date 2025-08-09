import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Class to help determine the directory from which the app was launched
 * @author vegdahl
 *
 */
public class Dir {

	/**
	 * returns the directly from which the current app was launched
	 * @return a file object that denotes the launching directory
	 */
	public static File dir() {
		return new Dir().exec();
	}
	
	// helper method to find the launching directory
	private File exec() {
		// URI to contain the executable
		URI u;
		try {
			// get the current executable
			u = new URI(this.getClass().getProtectionDomain().getCodeSource().getLocation().toString());
		} catch (URISyntaxException e) {
			// return null if there was some kind of an error
			return null;
		}
		
		// return the parent file of the current executable
		File f = new File(u);
		return f;
	}
}