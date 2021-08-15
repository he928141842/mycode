package com.hh.myproject.base;

import lombok.Data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author hejiayuan
 * @date 2020-12-31 16:12
 */
@Data
public class MyCollector<T> implements Collector<T, Set<T>, Map<T,T>> {

    /**Characteristics没有current属性 所以并行流执行的时候会创建多个结果容器 每个线程操作自己的
     *
     * @return
     */
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier................创建中介容器");
        return ()->{
            System.out.println("创建结果集................真正执行");
            return new HashSet<>();
        };
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator................累加");

        return (set,item)->{
            //System.out.println("累加.......set:"+set+";item:"+item+"........真正执行");
            System.out.println("累加...............真正执行");
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner................");
        return (set1,set2)->{
            //System.out.println("合并结果集.......set1："+set1+"；set2:"+set2+".........真正执行");
            System.out.println("合并结果集..............真正执行");
            set1.addAll(set2);
            return set1;
        };
    }

    /**
     * 调不调用取决于characterrasticse的参数 IDENTITY_FINISH是否存在
     * 如果存在话表名  操作的结果集就是最终的结果集类型  直接强转  本例中<T, Set<T>, Map<T,T>  set  map明显不一样
     * 所以下面是需要赋值的
     * @return
     */
    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher................返回最终容器类型");

        return set->{
            //System.out.println("finisher................真正执行");
            Map<T,T> map = new HashMap<>();
            set.stream().forEach(item->map.put(item,item));
            return map;
        };
    }

    /**
     * 对于一个并行流  如果不加 Characteristics.concurrent
     * 那么每个线程会创建自己的结果集 然后 每个结果容器加一个数据进去 再调用combian 方法  将结果容器合并
     *
     * 如果加了concurrent的话 指挥创建一次结果集  对结果集进行累加  然后不执行combine方法  理解（相当于sychronized锁加锁 ）
     *
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics..............");

        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }
}
