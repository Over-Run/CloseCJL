package org.overrun.cjl;

import static org.overrun.cjl.token.Tokens.set;

/**
 * @author squid233
 * @since 0.1.0
 */
public class CJLParser {
    public static CJLAst parse(String src) {
        CJLAst root = new CJLAst();
        String[] spl = src.split("\\s+");
        int ti = 0;
        for (int i = 0; i < spl.length; i++) {
            String s = spl[i];
            if (set.equals(s)) {
                IndexValue v = set.parse(root,
                    spl,
                    new IndexValue(ti, i + 1),
                    0);
                ti = v.treeIndex;
                i = v.srcIndex;
            }
        }
        return root;
    }
}
