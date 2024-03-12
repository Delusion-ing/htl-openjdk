package cn.htl.moon20220114;

/**
 * CreateTime 2022/1/14 hushujing
 */
@FunctionalInterface
public interface BranchHandleExample {
    void trueOrFalse(Runnable trueHandle, Runnable falseHandle);
}
