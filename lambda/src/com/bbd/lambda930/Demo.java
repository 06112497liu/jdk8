package com.bbd.lambda930;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * @author Liuweibo
 * @version Id: Demo.java, v0.1 2017/9/30 Liuweibo Exp $$
 */
public class Demo {
    @Test
    public void test01() {
        Runnable runnable = () -> System.out.println("Hello Word");
        runnable.run();
        ActionListener oneArgument = event -> System.out.println("button clicked");
        BinaryOperator<Long> addExplicit = (x, y) -> x + y;
    }

    @Test
    public void test02() {
        int a = 9;
        Runnable runnable = () -> {
            System.out.println(a);
        };
        runnable.run();
    }

    @Test
    public void test03() {
        Predicate<Integer> predicate = x -> x > 5;
        boolean flag = predicate.test(5);
        System.out.println(flag);
    }
}
    
    