package cn.htl.moon20220114;

/**
 * CreateTime 2022/1/14 hushujing
 */
public class VUtils{
    public static BranchHandle isTrue(boolean b){
        return (trueHandle, falseHandle) -> {
            if (b){
                trueHandle.run();
            } else {
                falseHandle.run();
            }
        };
    }
}
