// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.dom.svg;

import org.w3c.dom.events.EventTarget;

// Referenced classes of package org.w3c.dom.svg:
//            SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, 
//            SVGStylable, SVGTransformable, SVGAnimatedLength

public interface SVGEllipseElement
    extends SVGElement, SVGTests, SVGLangSpace, SVGExternalResourcesRequired, SVGStylable, SVGTransformable, EventTarget
{

    public abstract SVGAnimatedLength getCx();

    public abstract SVGAnimatedLength getCy();

    public abstract SVGAnimatedLength getRx();

    public abstract SVGAnimatedLength getRy();
}
