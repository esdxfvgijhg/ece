// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

// Referenced classes of package org.w3c.dom.svg:
//            SVGCSSRule, SVGRenderingIntent

public interface SVGColorProfileRule
    extends SVGCSSRule, SVGRenderingIntent
{

    public abstract String getSrc();

    public abstract void setSrc(String s)
        throws DOMException;

    public abstract String getName();

    public abstract void setName(String s)
        throws DOMException;

    public abstract short getRenderingIntent();

    public abstract void setRenderingIntent(short word0)
        throws DOMException;
}
