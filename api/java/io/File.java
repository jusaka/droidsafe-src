package java.io;

import droidsafe.annotations.*;
import droidsafe.helpers.*;

public class File implements Serializable, Comparable<File> {
	private static final long serialVersionUID = 301077366599181567L;
	public static final char separatorChar;
	public static final String separator;
	public static final char pathSeparatorChar;
	public static final String pathSeparator;
	
	static {
        separatorChar = System.getProperty("file.separator", "/").charAt(0);
        pathSeparatorChar = System.getProperty("path.separator", ":").charAt(0);
        separator = String.valueOf(separatorChar);
        pathSeparator = String.valueOf(pathSeparatorChar);
    }
	
	private DSTaintObject dsTaint = new DSTaintObject();
	
	@DSModeled(DSC.SAFE)
	public File(String path) {
		dsTaint.addTaint(path);
        //this.path = fixSlashes(path);
    }

	@DSModeled(DSC.SAFE)
	public File(File dir, String name) {
        this(dir == null ? null : dir.getPath(), name);
    }
	
	@DSModeled(DSC.SAFE)
	public File(String dirPath, String name) {
		dsTaint.addTaints(dirPath, name);  //DSFIXME:  Value is conditional based on nulls, but model probably doesn't care
		/*
        if (name == null) {
            throw new NullPointerException();
        }
        if (dirPath == null || dirPath.isEmpty()) {
            this.path = fixSlashes(name);
        } else if (name.isEmpty()) {
            this.path = fixSlashes(dirPath);
        } else {
            this.path = fixSlashes(join(dirPath, name));
        }
        */
    }
	
	@Override
	public int compareTo(File arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public String getPath() {
		return dsTaint.getTaintString();
        //return path;
    }
	
	@DSModeled(DSC.SAFE)
    @Override
    public String toString() {
    	return dsTaint.getTaintString();
        //return path;
    }
}
