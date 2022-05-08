package cn.htl.moon20220114;

/**
 * CreateTime 2022/1/14 hushujing
 */
@FunctionalInterface
public interface BranchHandle {
    void trueOrFalseHandle(Runnable trueHandle, Runnable falseHandle);
}
