package exam2006;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Defining an interface to be used by the Main classes (to link non-static methods from the Methods class)
 *
 * 
 *    
 */
public interface Interface {

	// See Methods.java for methods and functions definitions
	
	
	public ArrayList<DataFormat> readData(String url) throws IOException;

	public ArrayList<BackgroundFormat> readBackground(String url, ArrayList<DataFormat> data) throws IOException;
	
		}

