package droidsafe.analyses.attr;


/**
 * Class containing attribute modeling utility methods 
 * @author dpetters@mit.edu
 * */
public class AttributeModelingUtils {
    /** 
     * Convert the string signature of a regular class to the string signature of the corresponding attr modeling model
     * class 
     * */
    public static String toAttrModelingModelClass(String regularClass){
        return AttributeModeling.PACKAGE_PREFIX + regularClass;
    }
   
    /**
     * Convert the string signature of an attr modeling model class to a string signature of a regular class 
     * */
    public static String fromAttrModelingModelClass(String attrModelingModelClass){
        return attrModelingModelClass.split(AttributeModeling.PACKAGE_PREFIX)[1];
    }
}
