// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.events.UIEvent;

// Referenced classes of package org.w3c.dom.svg:
//            SVGRect, SVGPoint

public interface SVGZoomEvent
    extends UIEvent
{

    public abstract SVGRect getZoomRectScreen();

    public abstract float getPreviousScale();

    public abstract SVGPoint getPreviousTranslate();

    public abstract float getNewScale();

    public abstract SVGPoint getNewTranslate();
}
