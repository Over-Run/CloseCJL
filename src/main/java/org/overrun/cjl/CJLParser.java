package org.overrun.cjl;

import java.util.Scanner;

import static org.overrun.cjl.token.CJLTokens.PRINTLN;

/**
 * @author squid233
 * @since 0.1.0
 */
public class CJLParser {
    private static CJLAst parseLine(CJLAst root,
                                    String src) {
        String[] spl = src.split("\\s");
        int len = spl.length;
        for (int i = 0; i < len; i++) {
            String s = spl[i];
            if (PRINTLN.value.equals(s)) {
                i = PRINTLN.parse(root, spl, i);
            }
        }
        return root;
    }

    public static CJLAst parse(String src) {
        CJLAst root = new CJLAst();
        Scanner sc = new Scanner(src);
        while (sc.hasNextLine()) {
            String ln = sc.nextLine().trim();
            parseLine(root, ln);
        }
        return root;
    }
}
