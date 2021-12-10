package org.overrun.cjl.token;

import org.overrun.cjl.CJLAst;
import org.overrun.cjl.IndexValue;

import static org.overrun.cjl.token.Tokens.println;

/**
 * @author squid233
 * @since 0.1.0
 */
public class DefFunctionToken extends CJLToken {
    public static final String value = "\u51FD\u6570";

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
        CJLAst funName = new CJLAst();
        funName.value = src[srcIndex];
        root.children.add(newIndex.treeIndex = treeIndex + 1, funName);
        for (int i = srcIndex + 1; !"}".equals(src[i]); i++) {
            if (println.value().equals(src[i])) {
                IndexValue v = println.parse(node,
                    src,
                    new IndexValue(0, i + 1),
                    depth + 1);
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
        return "function";
    }
}
