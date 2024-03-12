package cn.htl.moon20220114;

/**
 * CreateTime 2022/1/14 hushujing
 */
public class FuncTest {
    public static void main(String[] args) {
        BranchHandleExample aTrue = VUtils.isTrue(false);
        aTrue.trueOrFalse(
                () -> System.out.printf("result:%s\n", "this is true"),
                () -> System.out.printf("result:%s\n", "this is false")
        );

        System.out.println(strTest("-100"));
        System.out.println(strTest("+100"));
    }

    static String strTest(String str){
        if (str.charAt(0) == '-') {
            return str.substring(1);
        }
        return str;
    }
}
