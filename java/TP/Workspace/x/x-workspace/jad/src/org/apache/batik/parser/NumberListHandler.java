// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            ParseException

public interface NumberListHandler
{

    public abstract void startNumberList()
        throws ParseException;

    public abstract void endNumberList()
        throws ParseException;

    public abstract void startNumber()
        throws ParseException;

    public abstract void endNumber()
        throws ParseException;

    public abstract void numberValue(float f)
        throws ParseException;
}
