package cn.htl.moon20220112;

/**
 * CreateTime 2022/1/12 hushujing
 * 在这里看结果1、2、3还好理解，从4开始就开始糊涂了，对于4来说为什么输出不是“B and B”呢？
 * 首先我们先看一句话：当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，
 * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。这句话对多态进行了一个概括。
 * 其实在继承链中对象方法的调用存在一个优先级：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 *
 *首先我们分析5，a2.show(c)，
 * 　　a2是A类型的引用变量，所以this就代表了A，a2.show(c),它在A类中找发现没有找到，于是到A的超类中找(super)，由于A没有超类（Object除外），
 * 所以跳到第三级，也就是this.show((super)O)，C的超类有B、A，所以(super)O为B、A，this同样是A，这里在A中找到了show(A obj)，
 * 同时由于a2是B类的一个引用且B类重写了show(A obj)，因此最终会调用子类B类的show(A obj)方法，结果也就是B and A。按照同样的方法我也可以确认其他的答案。
 * 方法已经找到了但是我们这里还是存在一点疑问，我们还是来看这句话：当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法。这我们用一个例子来说明这句话所代表的含义：
 * a2.show(b)；这里a2是引用变量，为A类型，它引用的是B对象，因此按照上面那句话的意思是说有B来决定调用谁的方法,所以a2.show(b)应该要调用B中的show(B obj)，产生的结果应该是“B and B”，但是为什么会与前面的运行结果产生差异呢？这里我们忽略了后面那句话“但是这儿被调用的方法必须是在超类中定义过的”，那么show(B obj)在A类中存在吗？根本就不存在！所以这句话在这里不适用？那么难道是这句话错误了？非也！其实这句话还隐含这这句话：它仍然要按照继承链中调用方法的优先级来确认。所以它才会在A类中找到show(A obj)，同时由于B重写了该方法所以才会调用B类中的方法，否则就会调用A类中的方法。
 * 所以多态机制遵循的原则概括为：
 * 当超类对象引用变量引用子类对象时，被引用对象的类型而不是引用变量的类型决定了调用谁的成员方法，但是这个被调用的方法必须是在超类中定义过的，
 * 也就是说被子类覆盖的方法，但是它仍然要根据继承链中方法调用的优先级来确认方法，该优先级为：this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
 */
class A {
        public String show(D obj) {
            return ("A and D");
        }

        public String show(A obj) {
            return ("A and A");
        }

    }

    class B extends A{
        public String show(B obj){
            return ("B and B");
        }

        public String show(A obj){
            return ("B and A");
        }
    }

    class C extends B{

    }

    class D extends B{

    }

    public class polymorphismTest {
        public static void main(String[] args) {
            A a1 = new A();
            A a2 = new B();
            B b = new B();
            C c = new C();
            D d = new D();
            System.out.println(b);
            System.out.println("1--" + a1.show(b));
//            System.out.println("2--" + a1.show(c));
//            System.out.println("3--" + a1.show(d));
//            System.out.println("4--" + a2.show(b));
//            System.out.println("5--" + a2.show(c));
//            System.out.println("6--" + a2.show(d));
//            System.out.println("7--" + b.show(b));
//            System.out.println("8--" + b.show(c));
//            System.out.println("9--" + b.show(d));
        }
    }
