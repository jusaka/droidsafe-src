package com.android.internal.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.net.NetworkUtils;
import android.util.Log;
import java.net.InetAddress;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.security.auth.x500.X500Principal;

public class DomainNameValidator {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.388 -0400", hash_original_method = "C5190347A8092226EE089C86AEE611D1", hash_generated_method = "C5190347A8092226EE089C86AEE611D1")
    public DomainNameValidator ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SPEC)
    public static boolean match(X509Certificate certificate, String thisDomain) {
        if (certificate == null || thisDomain == null || thisDomain.length() == 0) {
            return false;
        }
        thisDomain = thisDomain.toLowerCase();
        if (!isIpAddress(thisDomain)) {
            return matchDns(certificate, thisDomain);
        } else {
            return matchIpAddress(certificate, thisDomain);
        }
    }

    
    @DSModeled(DSC.SPEC)
    private static boolean isIpAddress(String domain) {
        boolean rval = (domain != null && domain.length() != 0);
        if (rval) {
            try {
                rval = domain.equals(
                        NetworkUtils.numericToInetAddress(domain).getHostAddress());
            } catch (IllegalArgumentException e) {
                if (LOG_ENABLED) {
                    Log.v(TAG, "DomainNameValidator.isIpAddress(): " + e);
                }
                rval = false;
            }
        }
        return rval;
    }

    
    @DSModeled(DSC.SPEC)
    private static boolean matchIpAddress(X509Certificate certificate, String thisDomain) {
        if (LOG_ENABLED) {
            Log.v(TAG, "DomainNameValidator.matchIpAddress(): this domain: " + thisDomain);
        }
        try {
            Collection subjectAltNames = certificate.getSubjectAlternativeNames();
            if (subjectAltNames != null) {
                Iterator i = subjectAltNames.iterator();
                while (i.hasNext()) {
                    List altNameEntry = (List)(i.next());
                    if (altNameEntry != null && 2 <= altNameEntry.size()) {
                        Integer altNameType = (Integer)(altNameEntry.get(0));
                        if (altNameType != null) {
                            if (altNameType.intValue() == ALT_IPA_NAME) {
                                String altName = (String)(altNameEntry.get(1));
                                if (altName != null) {
                                    if (LOG_ENABLED) {
                                        Log.v(TAG, "alternative IP: " + altName);
                                    }
                                    if (thisDomain.equalsIgnoreCase(altName)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {}
        return false;
    }

    
    @DSModeled(DSC.SPEC)
    private static boolean matchDns(X509Certificate certificate, String thisDomain) {
        boolean hasDns = false;
        try {
            Collection subjectAltNames = certificate.getSubjectAlternativeNames();
            if (subjectAltNames != null) {
                Iterator i = subjectAltNames.iterator();
                while (i.hasNext()) {
                    List altNameEntry = (List)(i.next());
                    if (altNameEntry != null && 2 <= altNameEntry.size()) {
                        Integer altNameType = (Integer)(altNameEntry.get(0));
                        if (altNameType != null) {
                            if (altNameType.intValue() == ALT_DNS_NAME) {
                                hasDns = true;
                                String altName = (String)(altNameEntry.get(1));
                                if (altName != null) {
                                    if (matchDns(thisDomain, altName)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (CertificateParsingException e) {
            String errorMessage = e.getMessage();
            if (errorMessage == null) {
                errorMessage = "failed to parse certificate";
            }
            Log.w(TAG, "DomainNameValidator.matchDns(): " + errorMessage);
            return false;
        }
        if (!hasDns) {
            final String cn = new DNParser(certificate.getSubjectX500Principal())
                    .find("cn");
            if (LOG_ENABLED) {
                Log.v(TAG, "Validating subject: DN:"
                        + certificate.getSubjectX500Principal().getName(X500Principal.CANONICAL)
                        + "  CN:" + cn);
            }
            if (cn != null) {
                return matchDns(thisDomain, cn);
            }
        }
        return false;
    }

    
    @DSModeled(DSC.SPEC)
    public static boolean matchDns(String thisDomain, String thatDomain) {
        if (LOG_ENABLED) {
            Log.v(TAG, "DomainNameValidator.matchDns():" +
                      " this domain: " + thisDomain +
                      " that domain: " + thatDomain);
        }
        if (thisDomain == null || thisDomain.length() == 0 ||
            thatDomain == null || thatDomain.length() == 0) {
            return false;
        }
        thatDomain = thatDomain.toLowerCase();
        boolean rval = thisDomain.equals(thatDomain);
        if (!rval) {
            String[] thisDomainTokens = thisDomain.split("\\.");
            String[] thatDomainTokens = thatDomain.split("\\.");
            int thisDomainTokensNum = thisDomainTokens.length;
            int thatDomainTokensNum = thatDomainTokens.length;
            if (thisDomainTokensNum >= thatDomainTokensNum) {
                for (int i = thatDomainTokensNum - 1; i >= 0; --i) {
                    rval = thisDomainTokens[i].equals(thatDomainTokens[i]);
                    if (!rval) {
                        rval = (i == 0 && thisDomainTokensNum == thatDomainTokensNum);
                        if (rval) {
                            rval = thatDomainTokens[0].equals("*");
                            if (!rval) {
                                rval = domainTokenMatch(
                                    thisDomainTokens[0], thatDomainTokens[0]);
                            }
                        }
                        break;
                    }
                }
            } else {
              rval = thatDomain.equals("*." + thisDomain);
            }
        }
        return rval;
    }

    
    @DSModeled(DSC.SPEC)
    private static boolean domainTokenMatch(String thisDomainToken, String thatDomainToken) {
        if (thisDomainToken != null && thatDomainToken != null) {
            int starIndex = thatDomainToken.indexOf('*');
            if (starIndex >= 0) {
                if (thatDomainToken.length() - 1 <= thisDomainToken.length()) {
                    String prefix = thatDomainToken.substring(0,  starIndex);
                    String suffix = thatDomainToken.substring(starIndex + 1);
                    return thisDomainToken.startsWith(prefix) && thisDomainToken.endsWith(suffix);
                }
            }
        }
        return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.390 -0400", hash_original_field = "16845E8E4DE531A87BF4CC1D2DC4F08E", hash_generated_field = "D762B92100EC492C8E2F43AE3DE0E7E1")

    private final static String TAG = "DomainNameValidator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.390 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.390 -0400", hash_original_field = "2600CAE892D7C6A21DB7F1CB3CE2784F", hash_generated_field = "C040F7E72494FCBA74A6440C651C9D2C")

    private static final boolean LOG_ENABLED = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.390 -0400", hash_original_field = "F32255F4F06275F74CB61F3DA51A229B", hash_generated_field = "D60747C22CE448F6B43389DBEE293EA4")

    private static final int ALT_DNS_NAME = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.390 -0400", hash_original_field = "F2EC570492E32F916A66D41EEF6D0EE0", hash_generated_field = "8F4F08DC629818A48F022D07A771C3BD")

    private static final int ALT_IPA_NAME = 7;
}

