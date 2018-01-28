package com.itcast.basic.stringtype.basicstring;
/**
 * Created by qfl on 16/4/20.
 * String StringBulider StringBuffer解析:
 * String:
 * String为final类即不可被子类继承
 * 实现接口CharSequence Compareable Serivaliable
 * 内部用常量数组实现即一旦赋值就不能修改
 * 内部方法操作都是把当前字符数组复制后进行操作并且返回新的字符串对象
 * 线程不安全 覆写Object的equals和hashCode方法
 * StringBuilder:
 * StringBuilder为final类即不可被子类继承
 * 内部由字符数组实现可以动态添加字符
 * 继承自抽象类AbstractStringBuilder 实现接口CharSequence Appendable Servializable可变字符串
 * 线程不安全 没有覆盖Object的hashCode和equals方法 没有实现Compareable接口
 * StringBuffer:
 * StringBuffer为final类即不可被子类继承
 * 内部由字符数组实现可以动态添加字符
 * 内部方法大多为同步方法
 * 继承自抽象类AbstractStringBuilder 实现接口CharSequence Appendable Servializable可变字符串
 * 线程安全 没有覆盖Object的hashCode和equals方法 没有实现Compareable接口
 * 关于抽象类和接口的思考:
 * 抽象类:
 * 抽象类的域字段可以为任意类型没有特殊限制(访问权限(public default protected private均可)和类型(final和非final均可))
 * 抽象类一般用abstract声明 抽象类中既可以存在抽象方法(被abstract修饰的没有方法体的方法)也可以存在非抽象的方法(没有被abstract修饰的有方法体的方法)
 * 抽象类可以声明静态和非静态代码块(static{}和{})也可以声明静态方法也即类方法(static)
 * 抽象方法只能存在于抽象类或者接口中 抽象方法必须在非抽象子类中实现
 * 接口:
 * 接口的域必须为静态常量域(默认public final)
 * 接口一般用@interface声明 接口中的方法必须为抽象方法(默认public abstract) 接口中不能声明静态方法和代码块(静态和非静态代码块)
 * 接口是高度抽象的 支持多继承 类只能单继承 但可以实现多个接口 可以多层继承
 * 关于继承的思考:
 * 父类的私有域不能被子类继承(即被private修饰的域) 父类的私有方法不能被子类继承(被private修饰的方法)
 * 父类的protected和public修饰的域可以被子类继承 父类的protected和public修饰的方法可以被子类继承
 * 父类的默认控制访问权限修饰的域和方法 如果父类和子类在同一个包下则可以继承 否则不能继承
 * 关于非类方法覆盖的思考:
 * 方法签名:方法名称+参数列表(参数类型和参数顺序)
 * 方法覆盖出现在当子类中含有和父类非类方法签名相同的非类方法时会覆盖父类的方法
 * 当发生非类方法覆盖时子类的非类方法的访问控制权限必须大于或者等于父类被覆盖的非类方法的控制访问权限
 * 非类方法的返回值类型必须兼容父类非类方法的返回值类型
 * 关于类方法隐藏的思考:
 * 当子类中存在与父类类方法方法签名相同的静态方法时 子类的静态方法不会覆盖父类的静态方法
 * 当子类中存在与父类相同名字的域时 子类的域不会覆盖父类域
 * 关于方法重载的思考:
 * 类自身的方法重载:
 * 同个类中方法名相同参数列表不同的两个方法可以进行重载
 * 子类基于继承父类方法的重载:
 * 当子类中存在与父类方法名相同参数列表不同的方法时可以进行重载
 * java不允许同个类中包含返回值不同方法签名相同的方法存在
 * 关于java中控制访问权限的思考:
 * 外部类的访问权限只能是public和包访问权限 类文件只能包含一个public类并且类文件名必须与public类名相同 内部类可以被任意控制访问权限修饰符修饰
 * 当外部类被public修饰时则可以在任何包中的类对该类进行实例化
 * 当外部类的访问控制权为默认时只能在该类所在包的其他类对该类进行实例化
 * 当非静态内部类被public修饰时则可以在任何包中通过外部类实例对该内部类实例化
 * 当静态内部类被public修饰时则可以在任何包中通过外部类类名对该内部类实例化
 * 当非静态内部类的控制权限为包控制权限时则可以在该类所在外部类包中的其他类中通过外部类实例对该内部类实例化
 * 当静态内部类的控制访问权限为包控制访问权限时则可以在该类所在外部类包中的其他类中通过类名对该内部类实例化
 * 当非静态内部类被protected修饰时则可以在该类所在外部类包中的其他类中通过外部类实例对该类进行实例化 但在其他包中此内部类所在外部类的子类可以访问但不能进行实例化(原因笔者在探讨)
 * 当静态内部类被protected修饰时则可以在该类所在外部类包中的其他类中通过外部类类名对该类进行实例化 但在其他包中此内部类所在外部类的子类可以访问但不能进行实例化(原因笔者亦在探讨)
 * 当非静态内部类的控制访问权限为私有访问权限时则只可以在该类的外部类内部通过外部类实例对该内部类实例化
 * 当静态内部类的访问权限为私有访问权限时则只可以在该类的外部类内部通过外部类类名对该内部类实例化
 * public修饰类属性(方法和域)时被修饰的属性访问权限无限制
 * protected修饰类属性(方法和域)时被修饰的属性可以该类所在包下的类访问 亦可以被不同包下该类的子类访问
 * 包控制权限修饰类属性(方法和域)时被修饰的属性仅可以在该类所在包下的类访问
 * private修饰类属性(方法和域)时被修饰的属性仅可以在该类中被访问
 * Java常见关键字的枚举:
 * 基本数据类型:doublemaper float long int short byte char type boolean void
 * 访问控制权限:public protected private
 * 变量修饰符:final static transient volatitle
 * 内置同步:synchronized
 * 释放资源:finalize
 * 包:package
 * 枚举:menu
 * 类和接口:class interface extends implements new this super abstract instanceof import
 * 逻辑操作:do while for return switch case default if else continue break
 * 待使用:goto const
 * 异常操作:try catch finally
 * 关于final关键字的思考:
 * final修饰类表示该类不能被子类继承 final修饰方法表示该方法不能被子类覆盖
 * final修饰变量(引用变量和非引用变量)表示该变量不可变且必须进行初始化(声明时初始化或者构造器初始化)
 * 关于static关键字的思考:
 * static不能修饰外部类可以修饰内部类 当内部类被static修饰时称为静态内部类 可以直接通过内部类所在外部类的名字访问
 * static修饰方法时称为类方法(静态方法)该方法为该类和该类的所有实例所拥有 可以直接通过类名调用
 * static修饰变量时称为类变量(静态变量)该变量为该类和该类的所有实例所共有 亦可以通过类名直接调用 在内存中只保留一份
 * static代码块初始化类时第一个执行的本类块
 * 关于native关键字的思考:
 * 被native修饰的方法称为本地方法 是通过其它语言编写的函数
 * 关于transient关键字的思考:
 * 被transient修饰的属性不进行序列化(将javabean转换为可以在网络传递的二进制流的过程叫做序列化)*
 * 关于java异常链的思考:
 *     Throwable
 *        /  \
 *       /    \
 *    Error   Exception
 *              /  \
 *             /    \
 *            /      \
 * RunTimeException   非运行时异常
 * 当子类覆盖父类的非异常方法时子类方法不能抛出异常 当子类覆盖父类的异常方法时要求子类抛出的异常向上兼容(即子类抛出的异常类是父类抛出的异常类的子类)
 * 当子类覆盖父类的异常方法时子类可以抛出多个向上兼容的异常 不可抛出不同类型的异常(如果父类抛出运行时异常子类不可添加非运行时异常)
 * 编写try{}catch(){}..finally{}语句应注意尽量把顶层异常类写的分支下层以保证能抛出具体异常而不会被父异常覆盖
 * 关于try{}catch(){}..finally{}返回值的思考:
 * 当try语句块中有return但catch finally语句块没有return情况下:
 * 无异常时执行顺序:先执行try语句块中return前面的代码 然后跳过catch块执行finally块最后返回try块执行return语句
 * 有异常时执行顺序:先执行try语句块中return前面的代码直到发现异常然后 执行catch块 执行finally块 最后退出不会返回try块执行return语句
 * 当catch语句块中有return但try finally语句块没有return情况下:
 * 无异常时执行顺序:先try语句块然后执行finally语句块最后退出
 * 有异常时先执行try语句块异常之前的代码 当捕获到异常执行catch语句块直到执行catch语句块return之前然后执行finally语句块最后返回catch语句块执行return语句
 * 当try catch finally语句块均有return 而且存在异常情况下 先执行try语句块异常之前的代码 当捕获到异常时 进入catch代码块 执行catch代码块return之前的代码 然后执行finally语句块的代码直到执行finally语句块中的return最后返回
 * 关于switch(){case constantValue:doSomeThing();break;default:doSomeThing();break;}的思考:
 * switch语句中的constantValue的类型可以为字符串常量(jdk7支持) char int byte short 常量
 * 关于for(int i=0;i<10;i++){}和for(String s:lists){}的思考:
 * for(int i=0;i<10;i++){}可以用于各种循环输出(但是容易由于下标编写不当会造成运行时异常)
 * for(String s:lists){}仅仅用于实现Iterable接口的集合输出(实际是调用集合的Iterator类中的方法(必须先next()才能remove()))
 * 关于try{}catch(){}..finally{}和try(){}catch(){}..的思考:
 * try{}catch{}..finally{}必须手动关闭流
 * try(InputStream i=new InputStream(new FileInputStream(fileName));){}catch(){}将可关闭的流(实现closeable接口)写到try语句内将在执行完方法后自动关闭流
 * 关于throw和throws的思考:
 * throw用于方法体内且一定抛出异常并且中断程序运行
 * throws用在方法名后面表示可能抛出的异常
 * 关于this和super的思考:
 * this表示当前对象或者作为内部类指向外部类的隐式参数亦可以用来调用类的构造方法
 * super关键字可以调用父类的构造方法 亦可以告诉编译器即将使用父类的属性(方法或域)
 * 关于java中String重载操作符+和+=的思考:
 * 当字符串进行+操作时 java编译器会利用new StringBuilder().append().toString()替代
 * 关于==和equals的思考:
 * ==作用于基本数据类型时比较的是基本数据类型的值 ==作用于引用类型时比较的是对象在内存(堆)中存储的地址
 * equals不能作用于基本数据类型 如果没有对equals方法进行覆写则equals比较的是对象在内存(堆)中存储的地址 否则将根据覆写后的逻辑进行比较(一般比较对象存储的值)
 * 关于hashCode的思考:
 * 相同对象的hashCode值相同 hashCode相同不能保证对象相同
 * 对于未覆盖hashCode方法的对象 hashCode方法返回对象的内存地址
 * 对于覆盖hashCode方法的对象 hashCode方法返回根据一定规则对内存地址计算后的常数
 * 对于键值对映射集合 hashCode用来产生散列码
 * 补充概念(java并发编程中的概念):
 * 原子性:即一个操作或者多个操作 要么全部执行并且执行的过程不会被任何因素打断，要么就都不执行
 * 可见性:当多个线程访问同一变量时 一个线程改变变量的值 其它线程能够立即看到改变后的值
 * 有序性:程序执行的顺序按照代码编写的顺序执行不会出现指令重排
 * 关于volatile关键字的思考:
 * 不能保证原子性
 * volatile关键字可以防止指令重排
 * 保证变量的多线程可见性即被volatile修饰的变量当多线程对其进行访问时 一个线程改变该变量的值会立即同步到主存 保证其它线程看到的是改变后的值
 * 关于静态导入(import static)的思考:
 * 仅仅导入类的静态方法 静态域 静态常量
 */
public class BasicStringDemo {
    public static void main(String[] args) {
        System.out.println("欢迎来到字符串世界");
        System.out.println("*************************************************************************");
        String s = "hello";
        String s1 = "world";
        final String s2 = "world";
        final String s3 = getWorld();
        String s4 = "helloworld";
        String s5 = "helloworld";
        System.out.println(s4 == s5);//true 编译器对字符串常量进行缓存
        System.out.println("*************************************************************************");
        String s6 = s + s1;//java对+操作符进行重载 new StringBuilder.append(s).append(s1).toString()
        System.out.println(s5 == s6);//false

        String s7 = s + "world";//java对+操作符进行重载 new StringBuilder.append(s).append("world").toString()
        System.out.println(s5 == s7);//false

        String s8 = "hello" + s1;//java对+操作符进行重载 new StringBuilder.append("hello").append(s1).toString()
        System.out.println(s5 == s8);//false
        System.out.println("*************************************************************************");

        String s9 = "hello" + s2;//被final修饰的引用如果可以在编译期间确定其值那么编译器将在后面用常量替代改引用 String s9="hello"+"world"
        System.out.println(s5 == s9);//true
        String s10 = "hello" + s3;//当final引用指向一个方法或者对象(String s=new String("hello"))时编译器在编译期间无法确定其引用
        System.out.println(s5 == s10);//false
        System.out.println("*************************************************************************");
        /**
         * 从编译器角度透析下面运算
         * 如果现行运算("i am " + "Lily")则编译器将当做常量运算处理
         * s11 = s11 + "i am " + "Lily"->new StringBuilder.append(s11).append("i am ").append("Lily").toString()
         * s11 = s11 + ("i am " + "Lily")->new StringBuilder.append(s11).append("i am Lily").toString()
         * s11 += "i am " + "Lily"->new StringBuilder.append(s11).append("i am Lily").toString()
         */
        String s11 = "helloWorld";
        s11 = s11 + "i am " + "Lily";
        s11 = s11 + ("i am " + "Lily");
        s11 += "i am " + "Lily";
        System.out.println("*************************************************************************");
    }
    public static String getWorld() {
        return "world";
    }
}
