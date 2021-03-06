//
//  ========================================================================
//  Copyright (c) 1995-2017 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.util;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * Tests for LazyList utility class.
 */
public class JavaVersionTest
{
    @Test
    public void test9()
    {
        JavaVersion version = JavaVersion.parse("9.0.1");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(0));
        assertThat(version.getSuffix(),nullValue());
    }
    
    @Test
    public void test9nano()
    {
        JavaVersion version = JavaVersion.parse("9.0.1.3");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(0));
        assertThat(version.getSuffix(),is("3"));
    }
    
    @Test
    public void test9build()
    {
        JavaVersion version = JavaVersion.parse("9.0.1+11");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(11));
        assertThat(version.getSuffix(),nullValue());
    }
    
    @Test
    public void test9all()
    {
        JavaVersion version = JavaVersion.parse("9.0.1-ea+11-b01");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(11));
        assertThat(version.getSuffix(),is("ea-b01"));
    }
    
    @Test
    public void test9yuck()
    {
        JavaVersion version = JavaVersion.parse("9.0.1.2.3-ea+11-b01");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(11));
        assertThat(version.getSuffix(),is("2.3-ea-b01"));
    }
    
    @Test
    public void test10ea()
    {
        JavaVersion version = JavaVersion.parse("10-ea");
        assertThat(version.getPlatform(),is(10));
        assertThat(version.getMajor(),is(10));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(0));
        assertThat(version.getUpdate(),is(0));
        assertThat(version.getSuffix(),is("ea"));
    }
    
    @Test
    public void test8()
    {
        JavaVersion version = JavaVersion.parse("1.8.0_152");
        assertThat(version.getPlatform(),is(8));
        assertThat(version.getMajor(),is(1));
        assertThat(version.getMinor(),is(8));
        assertThat(version.getMicro(),is(0));
        assertThat(version.getUpdate(),is(152));
        assertThat(version.getSuffix(),nullValue()); 
    }

    @Test
    public void test8ea()
    {
        JavaVersion version = JavaVersion.parse("1.8.1_03-ea");
        assertThat(version.getPlatform(),is(8));
        assertThat(version.getMajor(),is(1));
        assertThat(version.getMinor(),is(8));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(3));
        assertThat(version.getSuffix(),is("ea")); 
    }
    
    @Test
    public void test3eaBuild()
    {
        JavaVersion version = JavaVersion.parse("1.3.1_05-ea-b01");
        assertThat(version.getPlatform(),is(3));
        assertThat(version.getMajor(),is(1));
        assertThat(version.getMinor(),is(3));
        assertThat(version.getMicro(),is(1));
        assertThat(version.getUpdate(),is(5));
        assertThat(version.getSuffix(),is("ea-b01")); 
    }
    
    @Test
    public void testUbuntu()
    {
        JavaVersion version = JavaVersion.parse("9-Ubuntu+0-9b181-4");
        assertThat(version.getPlatform(),is(9));
        assertThat(version.getMajor(),is(9));
        assertThat(version.getMinor(),is(0));
        assertThat(version.getMicro(),is(0));
        assertThat(version.getUpdate(),is(0));
        assertThat(version.getSuffix(),is("Ubuntu-9b181-4")); 
    }
}
