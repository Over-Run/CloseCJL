package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;
import org.overrun.cjl.IndexValue;

import static org.overrun.cjl.token.Tokens.defFunc;

/**
 * @author squid233
 * @since 0.1.0
 */
public class SetToken extends CJLToken {
    public static final String value = "\u8BBE";

    @Override
    public IndexValue parse(CJLAst root,
                            String[] src,
                            IndexValue index,
                            int depth) {
        final int treeIndex = index.treeIndex;
        final int srcIndex = index.srcIndex;
        IndexValue newIndex = new IndexValue();
        newIndex.srcIndex = srcIndex + 1;
        CJLAst node = new CJLAst();
        node.value = value;
        root.children.add(treeIndex, node);
        for (int i = srcIndex; i < src.length; i++) {
            if (defFunc.equals(src[i])) {
                IndexValue v = defFunc.parse(node,
                    src,
                    new IndexValue(0, i + 1),
                    depth);
                newIndex.treeIndex = v.treeIndex;
                i = v.srcIndex;
            }
            newIndex.srcIndex = i;
        }
        return newIndex;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String engValue() {
        return "set";
    }
}
