package org.overrun.cjl;

/**
 * @author squid233
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(CJLParser.parse(
            "设 函数 入口点 {\n" +
            "    调用 函数 sys 中的 输出 （ 字符串 （ 你好世界 ） ）\n" +
            "}"));
    }
}
