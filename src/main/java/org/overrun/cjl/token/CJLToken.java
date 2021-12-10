package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;
import org.overrun.cjl.IndexValue;

import java.util.Objects;

/**
 * @author squid233
 * @since 0.1.0
 */
public abstract class CJLToken {
    public abstract IndexValue parse(CJLAst root,
                                     String[] src,
                                     IndexValue index,
                                     int depth);

    public abstract String value();

    public abstract String engValue();

    public boolean equals(String o) {
        return Objects.equals(value(), o) || Objects.equals(engValue(), o);
    }
}
