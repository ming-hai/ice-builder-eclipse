// **********************************************************************
//
// Copyright (c) 2008-2017 ZeroC, Inc. All rights reserved.
//
// **********************************************************************

package com.zeroc.icebuilderplugin.internal;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.ClasspathVariableInitializer;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

public class IceClasspathVariableInitializer extends ClasspathVariableInitializer
{
    private final static String VARIABLE_NAME = "ICE_JAR_HOME";

    @Override
    public void initialize(String variable)
    {
        if(variable.equals(VARIABLE_NAME))
        {
            update();
        }
    }

    public static void update()
    {
        IPath path = new Path(Configuration.getJarDir());
        try
        {
            JavaCore.setClasspathVariable(VARIABLE_NAME, path, null);
        }
        catch(JavaModelException e)
        {
            e.printStackTrace();
        }
    }
}
