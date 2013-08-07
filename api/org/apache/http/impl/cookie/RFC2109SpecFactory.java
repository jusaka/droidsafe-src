package org.apache.http.impl.cookie;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.params.CookieSpecPNames;
import org.apache.http.params.HttpParams;



public class RFC2109SpecFactory implements CookieSpecFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.117 -0400", hash_original_method = "D388D125B30D289290BCCEEE1DC724F5", hash_generated_method = "D388D125B30D289290BCCEEE1DC724F5")
    public RFC2109SpecFactory ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.118 -0400", hash_original_method = "319F84F2475AFEEE24E68A878D2B0074", hash_generated_method = "CA52BEFBC0B10DD81B1A0B5931E0527D")
    public CookieSpec newInstance(final HttpParams params) {
        addTaint(params.getTaint());
        if(params != null)        
        {
CookieSpec var536902E205C4FCF251216F065D8F7073_271657188 =             new RFC2109Spec(
                    (String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
            var536902E205C4FCF251216F065D8F7073_271657188.addTaint(taint);
            return var536902E205C4FCF251216F065D8F7073_271657188;
        } //End block
        else
        {
CookieSpec varDC84E44E1005E8102B12913F71F9EE55_280369122 =             new RFC2109Spec();
            varDC84E44E1005E8102B12913F71F9EE55_280369122.addTaint(taint);
            return varDC84E44E1005E8102B12913F71F9EE55_280369122;
        } //End block
        // ---------- Original Method ----------
        //if (params != null) {
            //return new RFC2109Spec(
                    //(String []) params.getParameter(CookieSpecPNames.DATE_PATTERNS), 
                    //params.getBooleanParameter(CookieSpecPNames.SINGLE_COOKIE_HEADER, false));
        //} else {
            //return new RFC2109Spec();
        //}
    }

    
}

