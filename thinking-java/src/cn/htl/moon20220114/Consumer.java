package cn.htl.moon20220114;

/**
 * CreateTime 2022/1/14 hushujing
 */
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
