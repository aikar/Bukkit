/*
 * Copyright (c) 2016 Starlis LLC / Daniel Ennis (Aikar) - MIT License
 *
 *  Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the
 *  "Software"), to deal in the Software without restriction, including
 *  without limitation the rights to use, copy, modify, merge, publish,
 *  distribute, sublicense, and/or sell copies of the Software, and to
 *  permit persons to whom the Software is furnished to do so, subject to
 *  the following conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 *  MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 *  LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 *  WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.empireminecraft.api;

import org.apache.commons.lang.exception.ExceptionUtils;

public abstract class API {

    public static EAPI_Entity entity;
    public static EAPI_Misc misc;

    public static String stack() {
        return ExceptionUtils.getFullStackTrace(new Throwable());
    }

    public static void exception(Throwable e) {
        exception(null, e);
    }

    public static void exception(String msg, Throwable e) {
        if (msg != null) {
            System.err.println(msg);
        }
        if (e.getMessage() != null) {
            System.err.println(e.getMessage());
        }
        for (String line : ExceptionUtils.getFullStackTrace(e).split("\n")) {
            System.err.println(line);
        }
    }
}
