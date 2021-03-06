package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;
import org.overrun.cjl.IndexValue;

/**
 * @author squid233
 * @since 0.1.0
 */
public class StringToken extends CJLToken {
    public static final String value = "\u5B57\u7B26\u4E32";

    public IndexValue parse(CJLAst root,
                            String[] src,
                            IndexValue index,
                            int depth) {
        final int treeIndex = index.treeIndex;
        final int srcIndex = index.srcIndex;
        IndexValue newIndex = new IndexValue();
        CJLAst node = new CJLAst();
        node.value = value;
        root.children.add(treeIndex, node);
        ++newIndex.treeIndex;
        StringBuilder sb = new StringBuilder();
        for (int i = srcIndex + 1; !"）".equals(src[i]); i++) {
            sb.append(" ").append(src[i]);
            newIndex.srcIndex = i;
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(0);
        }
        CJLAst v = new CJLAst();
        v.value = sb.toString();
        node.children.add(0, v);
        return newIndex;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String engValue() {
        return "string";
    }
}
