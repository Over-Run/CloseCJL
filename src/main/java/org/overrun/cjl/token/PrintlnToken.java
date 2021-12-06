package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;

import static org.overrun.cjl.token.CJLTokens.PRINTLN;
import static org.overrun.cjl.token.CJLTokens.STRING;

/**
 * @author squid233
 * @since 0.1.0
 */
public class PrintlnToken extends CJLToken {
    public PrintlnToken(String value) {
        super(value);
    }

    @Override
    public int parse(CJLAst root,
                     String[] src,
                     int index) {
        CJLAst node = new CJLAst();
        node.value = PRINTLN.value;
        root.children.add(0, node);
        for (int i = index + 1; i < src.length; i++) {
            if (STRING.value.equals(src[i])) {
                i = STRING.parse(node, src, i);
            }
        }
        return index;
    }
}
