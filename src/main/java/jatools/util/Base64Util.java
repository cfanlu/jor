/*
 * Created on 2004-6-20
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package jatools.util;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author java
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 * 
 */

public class Base64Util {

	
	public static String encode(byte[] ba) {
		return Base64.encodeBase64String(ba);
	}

	
	public static byte[] decode(String s) {
		return Base64.decodeBase64(s);
	}

}
