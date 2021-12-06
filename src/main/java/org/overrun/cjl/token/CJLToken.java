package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;

/**
 * @author squid233
 * @since 0.1.0
 */
public abstract class CJLToken {
    public final String value;

    public CJLToken(String value) {
        this.value = value;
    }

    public abstract int parse(CJLAst root,
                              String[] src,
                              int index);
}
