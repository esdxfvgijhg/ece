// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.parser;


// Referenced classes of package org.apache.batik.parser:
//            Parser, ClockHandler

public interface ClockParser
    extends Parser
{

    public abstract void setClockHandler(ClockHandler clockhandler);

    public abstract ClockHandler getClockHandler();
}
