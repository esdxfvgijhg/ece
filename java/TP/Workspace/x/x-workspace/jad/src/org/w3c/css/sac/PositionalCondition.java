// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            Condition

public interface PositionalCondition
    extends Condition
{

    public abstract int getPosition();

    public abstract boolean getTypeNode();

    public abstract boolean getType();
}
