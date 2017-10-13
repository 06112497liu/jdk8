package com.bbd.guava;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;
import com.sun.istack.internal.Nullable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


/**
 * @author Liuweibo
 * @version Id: Demo.java, v0.1 2017/10/13 Liuweibo Exp $$
 */
public class Demo {

    /**
     * 避免null
     */
    @Test
    public void test01() {
        Optional op1 = Optional.absent(); // 创建引用缺失的Optional实例
        //op1.get(); // 取值的时候报错
        Optional op2 = Optional.of(null); // 创建指定引用的Optional实例，若引用为null则快速失败
        op2.get();
        Optional op3 = Optional.fromNullable(null); // 创建指定引用的Optional实例，若引用为null则表示缺失
        op3.get(); // 取值的时候报错
    }

    /**
     * 前置条件监测
     */
    @Test
    public void test02() {
        Preconditions.checkArgument(true); // 为true时，通过验证，为false报错。没有返回参数
        Preconditions.checkNotNull(null); // 为null时报空指针异常，不为null时，返回引用。
        Preconditions.checkState(false); // 检查对象的状态，false的话报错
        Preconditions.checkElementIndex(4, 5); // 如果4<0或者4>=5的话，报越界错误，返回4
        Preconditions.checkPositionIndex(4, 5);// 如果4<0或者4>5的话，报越界错误，返回4
        Preconditions.checkPositionIndexes(4, 5, 6); // 如果4<0 || 5<4 || 5>6 报位置错误。
    }

    @Test
    public void test03() {
        List<String> list = Arrays.asList(new String[]{"bcw","as","dd"});

        Ordering<String> ordering1 = Ordering.natural(); // 自然顺序比较器
        list.sort(ordering1);

        Ordering<Object> ordering = Ordering.usingToString(); // 按对象的字符串形式做字典排序
        list.sort(ordering);

        Ordering<Comparable> ordering2 = Ordering.natural().reverse(); // 自然顺序的逆顺
        list.sort(ordering2);
    }

    @Test
    public void test04() {
        // 从后往前看
        Ordering<Foo> ordering
                = Ordering.natural() // 剩下的按自然排序
                          .nullsFirst() // 将为null的排在前面
                          .onResultOf( p -> p.sortBy); // 取Foo类的sortBy字段为排序字段
    }

    /**
     * 不可变集合
     */
    @Test
    public void test05() {
        ImmutableSet<String> color_names = ImmutableSet.of("red", "orange");
        Set<String> set = ImmutableSet.copyOf(color_names);
        set.add("green"); // 添加会报错，因为这是不可变集合
    }

    @Test
    public void test06() {
        Set<String> set = Sets.newHashSet("red", "orange", "green");
        set.add("blank"); // 能添加
        Set<String> immutableSet = ImmutableSet.copyOf(set); // 转变成不可变的Set
        immutableSet.add("blue"); // 添加报错java.lang.UnsupportedOperationException
    }
}

class Foo {

    @Nullable
    String sortBy;
    String notSortBy;
}


























    
    