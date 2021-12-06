package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;

import static org.overrun.cjl.token.CJLTokens.STRING;

/**
 * @author squid233
 * @since 0.1.0
 */
public class StringToken extends CJLToken {
    public StringToken(String value) {
        super(value);
    }

    @Override
    public int parse(CJLAst root,
                     String[] src,
                     int index) {
        CJLAst node = new CJLAst();
        node.value = STRING.value;
        root.children.add(index - 1, node);
        for (int i = index + 1; i < src.length; i++) {
            if ("（".equals(src[i++])) {
                while (!"）".equals(src[i])) {
                    CJLAst n = new CJLAst();
                    n.value = src[i];
                    node.children.add(i - 3, n);
                    ++i;
                }
            } else {
                throw new IllegalStateException();
            }
        }
        return index;
    }
}
