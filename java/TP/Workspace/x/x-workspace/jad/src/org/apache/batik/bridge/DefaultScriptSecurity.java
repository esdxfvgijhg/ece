// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.util.ParsedURL;

// Referenced classes of package org.apache.batik.bridge:
//            ScriptSecurity, Messages

public class DefaultScriptSecurity
    implements ScriptSecurity
{

    public void checkLoadScript()
    {
        if(se != null)
            throw se;
        else
            return;
    }

    public DefaultScriptSecurity(String s, ParsedURL parsedurl, ParsedURL parsedurl1)
    {
        if(parsedurl1 == null)
        {
            se = new SecurityException(Messages.formatMessage("DefaultScriptSecurity.error.cannot.access.document.url", new Object[] {
                parsedurl
            }));
        } else
        {
            String s1 = parsedurl1.getHost();
            String s2 = parsedurl.getHost();
            if(s1 != s2 && (s1 == null || !s1.equals(s2)) && !parsedurl1.equals(parsedurl) && (parsedurl == null || !"data".equals(parsedurl.getProtocol())))
                se = new SecurityException(Messages.formatMessage("DefaultScriptSecurity.error.script.from.different.url", new Object[] {
                    parsedurl
                }));
        }
    }

    public static final String DATA_PROTOCOL = "data";
    public static final String ERROR_CANNOT_ACCESS_DOCUMENT_URL = "DefaultScriptSecurity.error.cannot.access.document.url";
    public static final String ERROR_SCRIPT_FROM_DIFFERENT_URL = "DefaultScriptSecurity.error.script.from.different.url";
    protected SecurityException se;
}
