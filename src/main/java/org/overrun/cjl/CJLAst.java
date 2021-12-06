package org.overrun.cjl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author squid233
 * @since 0.1.0
 */
public class CJLAst {
    public final List<CJLAst> children = new ArrayList<>();
    public String value;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
            .append(value)
            .append("={");
        boolean first = true;
        for (CJLAst child : children) {
            if (!first) {
                sb.append(",");
            }
            sb.append(child);
            first = false;
        }
        return sb.append("}").toString();
    }
}
