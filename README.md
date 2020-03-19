# Java基础知识与常见面试题 

## 单例模式
1. 饿汉式：线程安全，反射不安全，反序列化不安全
2. 登记式：又称静态内部类式，线程安全，防止反射攻击，反序列化不安全
3. 枚举式：线程安全，支持序列化，反序列化安全，防止反射攻击
4. 懒汉式：线程不安全，延迟加载，可以加同步解决线程安全，效率低，加双捡锁优化，volatile避免由于指令重排出现的空对象。
5. ThreadLocal：在各个线程内式单例的，不同线程不保证单例
6. CAS：无锁乐观策略，线程安全

## 基础
1. 抽象类可以有构造方法，但是不能被实例化。不一定只有抽象方法，相反有抽象方法的一定是抽象类。
2. 抽象类和接口的区别    
    1. 接口可以继承接口，并且可以多继承，但类只能单继承
    2. 抽象类必须有某一个子类实现所有的方法。
    3. 接口中只能有方法的声明，静态方法和default方法，但抽象类可以有普通方法。
    4. 抽象类的变量是普通变量，接口中是公共的常量。
2. 外部类不能是静态的，因为如果是静态的，那么随着应用启动该类就会被加载，如果根本没有用过该类，那么就会造成内存浪费，这样是不合理的。
3. Try-Catch-Finally中，如果在finally修改返回值不会生效，但是如果直接return会覆盖try中的return。
4. 类初始化的过程
    1. 创建实例前需要先加载并初始化该类
    2. 子类初始化前需要初始化父类
    3. 类初始化执行静态类变量显示赋值代码和静态代码块，从上到下执行。
5. 实例化的初始化过程
    1. 非静态实例变量显示赋值代码和非静态代码块从上到下执行，对应的构造器方法最后执行。
    2. 被重写的非静态方法的this指的是正在创建的对象，所以执行子类的重写方法。
6. 方法的传参机制和特殊类的不变性
    1. 基本数据类型传递的是数据值，引用数据类型传递的是地址值。
    2. String,包装类不可变，所以在方法中指向了新的对象，所以原数据仍然无法修改。
7. JAVA的四大特性(3.17 阿里一面题)
    1. 抽象：abstract修饰，父类为子类提供一些属性和行为，子类根据业务需求实现具体的行为。如果子类没有实现所有的抽象方法，那子类也是抽象类。
    2. 封装：private修饰，对外提供set，get方法。把对象的属性和行为结合为一个独立的整体，尽可能隐藏对象的内部实现细节。
    3. 继承：extends，子类继承父类的属性，并能根据自己的需求扩展出新的属性和行为，提高代码复用性。
    4. 多态：接口实现，继承父类进行方法重写，在同一个类中进行方法重载。不修改代码就可以改变程序运行时所绑定的具体代码，让程序可以选择多个运行状态。多态有三个必要条件
        1. 要有继承
        2. 要有重写
        3. 父类引用指向子类对象
8. Collection接口下有：List，Set，Queue,sortedSet
9. Map接口下：HashMap，HashTable，TreeMap，IdentityHashMap，WeakHashMap

## super和 this
1. 都只能在构造器的第一行，且不能同时使用。
2. this调用的是重载的构造器，super调用的是父类被子类重写的方法。
3. this和super都指的是对象，所以不能在static环境中使用。

## 异常
1. Exception和Error的区别：
    1. 都继承自Throwable
    2. Error指的是较为严重的，正常情况不应该出现的错误，如OutOfMemoryError,StackOverflowError,不应当捕获
    3. Exception指的是可以预料到的意外情况，可以捕获处理
2. 运行时异常(不受检查的异常)和一般异常的区别
    1. 受检查的异常：编译时被强制检查的异常如ClassNotFountException，IOException
    2. 不受检查的异常，在编码过程中可以避免的逻辑错误，如空指针异常，不需要在编译时强制检查。
3. 常见的几种运行时异常
    1. NullPointerException 空指针
    2. ClassCastException 类型转换
    3. NumberFormatException 数字类型转换
    4. IndexOutOfBoundsException 越界
4. throw和throws的区别
    1. throw：在方法中手动抛出异常的方法，如果方法体内不处理，需要在方法上声明throws
    2. throws：方法声明时标明可能产生的所有异常，不做任何处理直接向上层传
5. 异常使用的注意点
    1. 不要捕获Exception这样的通用异常
    2. 不要catch到异常后不处理
    3. 借助日志记录异常
    4. 不要try-catch一大段代码，因为会造成额外的性能开销    

## Int 和 Integer
1. Integer在-128到127内时，使用缓存机制，是同一个对象，否则是不同对象不能直接==判断数值。
2. Integer在自增等操作后是一个新的对象。
3. 判断数值相等时需要使用equals或拆箱为基本数据类型int比较。

## String,StringBuffer,StringBuilder
1. String是final的，所以具有不可变性，对于字符串操作会产生新的String对象。
2. StringBuffer本质是一个线程安全的可修改的字符串序列，由于加入线程安全，会带来额外性能损耗。
3. StringBuilder是没有线程安全的StringBuffer。
4. String重写了equals方法,所以可以使用equals判断两个字符串内容是否一致。equals方法先判断是否为字符串，然后逐个比较。

## 方法重写和覆盖
1. 重写指子类中重写父类的方法，实现的功能不同。要求必须满足两同两小一大。
    1. 访问修饰符要大于等于父类。
    2. 方法名和参数相同。
    3. 返回值是引用数据类型要小于等于父类，基本数据类型的返回值必须相同。
    4. 抛出的异常更小。
2. 重载指方法名相同，参数类型和类型不同。
3. final方法，静态方法，private等子类不可见方法不可被重写。

## HashMap,HashTable,ConcurrentHashMap (3.17 阿里一面题)
1. HashMap允许null的value或者key，但是HashTable不允许。
2. HashMap继承自AbstractMap。HashTable继承自Dictionary。1.7之前实现一样，都是数组+链表。
3. HashMap的默认大小是16，默认负载因子为0.75。链表长度大于8且容量大于等于64时会转为红黑树，少于6会转回链表。总容量小于64时，认为是由于格子太少造成的冲突过多，所以进行扩容。
2. HashTable在方法上添加了Synchronize，实现了线程安全，但锁住了整个HashTable,效率比较低。
3. HashMap在JDK1.8时引入了红黑树。
2. HashMap在计算哈希时，(当前的容量-1)&(哈希值) 是存放的位置。基本上就是哈希值本身，所以可以使得数据尽可能分散。
4. JDK1.7中，当扩容时，需要去计算每个数据的新位置，然后更新数据。这里使用的是头插法，当出现第一个线程刚拿到next，还没来得及放入新的位置时时间片用完，第二个线程完成了链表的逆置，这时候切回第一个线程就会导致死循环。
5. JDK1.8中，在put操作时，当出现两个线程同时往一个位置放东西且他们都是空的时，如果一个线程还没放进去时间片就用完了切换到线程二，线程二完成后线程一再操作时会覆盖线程二的数据。
6. HashSet的底层是HashMap。相当于是一个只有key的HashMap,value是一个假的Object。
7. 1.8版本之前，采用分段锁，将数据分成一段一段后，给每一段数据配置一把锁。Segment锁使用的时ReentrantLock，segments本身就是一个哈希表，每个segment守护一个HashEntry里的元素，要对其修改时要先获得他对应的Segment锁。
7. 1.8之后，ConcurrentHashMap抛弃了segment分段锁，采用了CAS+synchronized保证并发安全。CAS就是Compare and Swap，先比较在交换。1.8之后，锁的是每一个node，由于在如此细分的情况下，不容易出现极大的并发，那么synchronized不会
    转为重量级锁，省去了线程切换上下文的时间。      

##Queue
1. LinkedBlockingQueue是一个基于链表结构的可选是否有界的阻塞队列，不允许null，线程安全
2. PriorityQueue是非线程安全的，PriorityBlockingQueue是线程安全的。

## ArrayList 和 LinkList
1. ArrayList是自扩容的动态数组实现，LinkList是双向链表实现。所以性能上随机访问Array比较好，指定位置删除添加Link好。
2. ArrayList线程不安全，多线程插入数据时会出问题。可以使用Collections.synchronizedList,CopyOnWriteArrayList解决。
3. Collections.synchronizedList写的效率高，CopyOnWriteArrayList有一个复制操作所以效率低。
4. CopyOnWriteArrayList的容器可以实现在读取的时候其他线程修改数据，因为他把要读取的和写的容器分开，实现了读写分离，不须加锁，所以读的效率更高。
5. CopyOnWriteArrayList存在读写一致性问题，因为读的是保存的旧数据，所以存在其他线程修改，不能立刻读到新数据。

## & 和 &&
1. &&具有短路功能，&当左右不是boolean数据时为位运算符，表示按位与运算。

## JVM
1. JVM结构
    1. https://blog.csdn.net/ocean_fan/article/details/79298076
2. 类加载器 (阿里一面题)
    1. 加载.class文件，并创建对应的class文件。
    2. 四种类加载器：根加载器，扩展类加载器，系统类加载器，还有用户自定义加载器。
    3. 双亲委派：从根加载器开始，逐层向下找，也就是优先使用高层的，父类的类加载器，减少重复加载，保证安全。比如自己写的String类不会被加载，保证源码安全。
3. 本地方法栈
    1. Native是一个关键字，代表本地方法，用来与非JAVA程序交互。比如Thread的启动底层就是本地方法。
    2. 有声明，无实现，标记Native的方法信息保存在 Native Method Stack。
    3. 各个线程不共享。
4. PC寄存器
    1. 记录了方法之间的调用和执行情况，用来存储指向下一条指令的地址。它是当前执行的字节码的行号指示器。
    2. 各个线程不共享。
5. 方法区
    1. 所有线程共享。
    2. 存储了每一个类的结构信息。如常量池，字段和方法数据，构造函数和普通方法的字节码内容。
    3. 方法区是规范，不同虚拟机的实现不同。java 7 是永久代，java 8是元空间。
    4. 实例变量存在堆内存中，和方法区无关。
    5. JVM规范将方法区描述为堆的一个逻辑部分，但他还有别名Non-Heap，目的是和堆区分开。
6. JAVA栈 (阿里一面题)
    1. 线程不共享。
    2. 栈管运行，堆管存储。
    3. 栈不存在垃圾回收，因为线程结束占内存也就释放。
    4. 8种基本类型变量+对象的引用变量+实例方法都是在函数的栈内存中分配。
    5. 每个方法执行的同时会创建一个栈帧，用于存储局部变量表，操作数栈，动态链接，方法出口等信息，栈的大小和具体的JVM实现有关。
7. 堆 (阿里一面题)
    1. 各线程共享。
    2. 新生代：默认和老年代比例为1:2。测试中发现实际 新生代=Eden+Survivor0，并不是生代=Eden+Survivor0+Survivor1。
        1. 伊甸区(Eden)：满了会开启YGC(Minor GC)，和幸存者区的比例为8:1:1。
        2. 幸存者0区：又称From区。
        3. 幸存者1区：又称To区。
        4. Minor GC:复制->清空->互换,两个幸存者区解决了碎片化。
            1. 当Eden区满时会触发第一次GC，把活着的对象拷贝到From区。
            2. 当Eden再次满时会扫描Eden和From区，对这两个区域进行垃圾回收，把这次存活的对象拷贝到to区。
            3. 清空Eden和From区的对象。
            4. From和To区交换，对象交换15次仍然存活，就会进入老年代。所以会保证每次To区域都为空。
    3. 老年代：满了，会开启FGC(Major GC)，多次FGC后，仍无法腾出空间，触发OOM。
    4. 元空间/永久代：
        1. 永久代或元空间是方法区的一个实现。
        2. 用于存放JDK自身携带的Class，Interface的元数据，是常驻内存区域。
        3. 永久代使用的是JVM的堆内存，java8以后替换为元空间，元空间不在虚拟机内，而是使用本机物理内存。
    5.  jinfo -flags PID 查看运行的java程序的JVM参数   
        -Xms 初始分配大小，默认为物理内存的“1/64”  
        -Xmx 最大分配内存，默认为物理内存的“1/4"
        -XX:SurvivorRatio = Ratio ,设置Eden和一个Survivor的比例。  
        -XX:MaxTenuringThreshold = num 设置对象在新生代中的存活次数，默认是15且最大时15,15是由JVM的年龄计数用的是0000决定的。  
        -XX:MetaspaceSize = num 设置元空间大小  
        -XX:+PrintGCDetails 打印GC日志
    6. 强弱软虚引用
        1. 强引用：平常new的对象的引用都是强引用，宁愿抛出OOM也不会回收
        2. 软引用：softReference，内存充足不会被回收
        3. 弱引用：weakReference,会直接回收，weakHashMap利用了弱引用可以解决缓存占用空间的问题。
        4. 虚引用：要和引用队列联合使用，跟踪对象被垃圾回收的状态。我们可以在这个对象被回收后收到一个系统通知。
8. GC
    1. 两种判断对象是否死亡的算法
        1. 引用计数法
            1. 给对象添加一个引用计数器，每当有一个地方引用它，计数器+1，引用失效，计数器减1，计数器为0，则认为对象不再被使用。
            2. 优点：实现简单，判定高校，可以解决大部分问题。
            3. 缺点： 难以解决循环引用，由于需要维护计数器，所以开销较大。
        2. 可达性分析
            1. 又称传递跟踪算法，主流的判定对象是否存活的算法。
            2. 通过一系列"GC Roots"对象作为起点，开始向下搜索，搜索走过的路径被称为引用链，当某个对象到GC Roots不可达时，则该对象不可用。
            3. GC Roots对象包括：
                1. 虚拟机栈(堆栈中本地变量表)所引用的对象。也就是说在虚拟机栈中该对象的生命周期还没有结束。
                2. 方法区中类静态属性引用的对象，也就是使用了static关键字，保存在了共有的方法区中。
                3. 方法区常量引用的对象。
                4. 本地方法栈中引用的对象。
            4. 优点是准确和严谨，缺点是实现复杂，耗时，分析过程需要GC停顿，被称为Stop The World。
    2. 四种垃圾收集算法 (阿里一面题)  
        1. 分代收集算法：目前大部分垃圾收集器采用的算法，是下面三种方法的结合。
            1. 年轻代特点是区域相对较小，对象存活率较低，用复制算法。
            2. 老年代特点是区域相对较大，对象存活率较高，用标记清除和压缩混合实现的算法。
        2. 复制算法
            1. 年轻代中采用的算法
            2. 就是上面提到了复制操作。
            3. 优点不会产生内存碎片。缺点是费空间，浪费了一半的内存。并且如果Eden区存活率高，那么时间上的损耗也比较大。
        3. 标记清除
            1. 老年代中采用的算法。
            2. 第一次扫描先标记出要回收的对象，然后第二次扫描统一回收这些对象。
            3. 两次扫描耗时，会产生内存碎片。而老年代的对象往往又占据较大内存，这就导致可能会经常找不到足够大的连续空间，触发下一次GC。
        4. 标记整理
            1. 在标记清除的基础上，将存活对象滑动到连续区域，处理内存碎片问题。
            2. 可以和标记清除结合，多次GC后再压缩。
    3. 七种垃圾收集器
        1. 新生代：
            1. Serial 串行
                1. 针对新生代，采用复制算法。
                2，单线程收集且垃圾收集时必须暂停所有工作线程。
                3. 稳定，效率高，但会造成较长时间的停顿。
                4. 配合Serial Old使用
            2. ParNew 并行
                1. 多线程收集,相当于是Serial收集器的多线程版本。
                2. 其他特点和Serial一样。
                3. 配合CMS使用
            3. Parallel Scavenge 并行 默认垃圾回收期
                1. 又被称为吞吐量收集器。
                2. 新生代收集器，采用复制算法，多线程收集。
                3. 他的关注点与其他收集器不同，他的目的是达到一个可控制的吞吐量。也就是控制用户代码在CPU总消耗中的比值。(用户代码时间/（用户代码时间+垃圾收集时间）)
                4. 适用场景:高吞吐量为目标，减少垃圾收集时间。
                5. 自适应调节停顿时间。
                5. 配合Parallel Old使用
        2. 老年代： 
            1. Serial Old(MSC) 串行
                1. 是Serial的老年代版本
                2. 采用标记-整理(标记-清除，标记-压缩)方法，单线程收集，需要暂停所有用户线程。              
            2. CMS 并发                             
                1. 并发标记清理。
                2. 基于标记-清除，不进行压缩操作，产生内存碎片。可以设置参数"-XX:+CMSFullGCsBeforeCompaction"，在多次FGC后执行一次压缩操作。
                3. 目的是获取最短的回收停顿时间，并发收集。
                4. 出现异常情况将会使用Serial Old。
                5. 4个阶段
                    1. 初始标记，stw，标记一下GC Roots关联的对象
                    2. 并发标记，和用户线程并发，进行跟踪过程，标记全部对象
                    3. 重新标记，stw，标记由于用户程序运行导致标记产生变动的记录，做一次修正
                    4. 并发清除，和用户线程并发，清除工作。  
                6. 优点：并发收集停顿第
                7. 缺点：对CPU压力大，内存碎片，必须要在老年代内存用尽之前完成垃圾回收。        
            3. Parallel Old
                1. 多线程的标记-整理算法。
                2. 配合Parallel Scavenge，解决注重吞吐量和CPU资源敏感的场景。
        3. 整堆收集器:
            1. G1 面向服务器端，从1.7u4开始支持，目标时取代CMS
                1. 并行与并发
                2. G1新增了一个Humongous区，存放大对象，直接分配在老年代。
                3. Young gc还是会导致停顿。
                2. 分代收集，收集范围包括新生代和老年代。但这里的分代和Java堆的内存布局不一样。Eden，Survivo和Tenured的内存区域不再是连续的了，而是一个个大小一样的region。
                3. 整体上看是标记整理，从局部来看是基于复制的。不会产生碎片，有利于长时间运行。每个区域不再独立的属于某一代了，而是会根据状态变化。所以不存在内存碎片了。
                4. 可预测的停顿，实现了高吞吐量。可以明确指定M毫秒内，垃圾收集消耗的时间不超过N毫秒。
                5. 不需要更大的堆内存
                6. 四步回收
                    1. 初始标记
                    2. 并发标记，只有这一步时并发的
                    3. 最终标记
                    4. 筛选回收：根据时间来进行价值最大的回收，可以使用MaxGCPauseMillis指定JVM将尽可能将停顿时间小于这个时间，但不保证。
9. JMM
    1. 线程对变量的操作必须要在工作内存中，首先要把变量拷贝到线程自己的工作空间，然后对变量进行操作，操作完成后再将变量写会主内存。
    2. 可见性。由于工作内存和主内存分开，所以某个线程修改完某个变量后，在其他线程中，未必能观察到变量的修改。volatile修饰的变量具备对其他线程的可见通知性，因为他会立即更新到主内存，synchronized和final也能实现可见性。
    3. 原子性。操作不可分割，同时成功或同时失败。被synchronized关键字或其他锁包括起来的操作也可以认为是原子的。可以用Atomic解决。
    4. 有序性。java会对一些指令进行指令重排，volatile和synchronized可以保证程序的有序性，保证了指令不进行重排。

## Lambda表达式
1. 接口中只有一个方法声明时，可以使用Lambda表达式。
2. 接口中可以有方法的实现，default修饰或者是静态方法。
3. 接口中可以有方法的实现，所以如果是实现的方法不影响Lambda使用。

## JUC
1. 什么是JUC
    1. java.util.concurrent的缩写，java在并发编程中使用的工具类。
    2. 主要有三个部分java.util.concurrent，java.util.concurrent.atomic,java.util.concurrent.locks。
2. wait和sleep的区别
    1. wait会释放锁，sleep不会释放锁。
3. 线程的六种状态
    1. new 新创建的线程，还没调用start
    2. RUNNABLE 就绪和运行都属于RUNNABLE,调用start后就进入就绪状态
    3. BLOCKED 线程阻塞与锁
    4. WAITING 等待其他线程，比如通知或中断
    5. TIMED_WAITING 指定时间后悔自行返回
    6. TERMINATED 执行完毕
4. 多线程的四种方式
    1. 继承Thread，重写Run方法
    2. 实现Runnable接口，重写run方法，可以用于处理同一资源以及多继承。
    3. 实现Callable接口，重写call方法，可以拿到返回值，允许抛出异常。配合FutureTask使用，拿到返回值的get方法是阻塞的。
    4. 使用线程池，减少创建线程的时间，降低资源消耗，控制并发线程的数量，可以有返回值。
5. synchronized 和 ReentrantLock
    1. synchronized可以用来同步方法或代码块：
        1. 同步方法：给方法增加synchronized关键字，可以使静态方法，也可以是非静态方法，但不能是抽象方法。
        2. 同步代码块，通过锁定一个指定的对象，来对同步代码进行同步。
        3. 同步是高开销操作，减少使用同步方法，同步关键代码即可。
    2. ReentrantLock：可重入锁，代码通过lock()方法获取锁，调用unlock释放锁。
    3. JDK1.5前synchronized的性能较低，JDK1.6后性能基本一致。
    4. 为什么1.6后synchronized性能提高了，因为引入了锁升级
        1. 锁的4种状态：无锁，偏向锁，轻量级锁，重量级锁
        2. 偏向锁的升级，当线程1访问代码并拿到锁后，会在对象头和堆栈中记录偏向锁的threadID，偏向锁不会主动释放锁，如果有线程继续获取锁，比较当前线程的threadID是否一致，如果不一致，则产看线程1是否存活，如果线程1存活且持有这个对象，那么
        升级为轻量级锁，否则让设置为无锁状态，有新线程持有偏向锁。
        3. 轻量级锁不会阻塞其他竞争锁的线程，而是采用自旋让他等待锁的释放，如果自旋达到一定次数后，线程1还没释放，那且这时候又有新的线程来竞争锁，那么这时候轻量级锁会升级为重量级锁，防止CPU空转。
        4. 锁可以升级，但不能降级。
    4. ReentrantLock可以配合多个condition的signal方法实现指定唤醒。
    5. 类中有多个synchronized方法，synchronized锁的是当前的实例对象this，所以同一时刻只能有一个线程能调用其中一个synchronized方法。
    6. 当锁上的是静态方法，锁的是当前Class对象，所以即使是多个实例，也只能有一个调用静态方法。
    7. 普通方法上锁和静态方法上锁，两者不会互相影响，因为锁的对象不一样，一个是当前模板一个是对象示例，
6. 多线程中为防止虚假唤醒，避免使用if，使用while。
7. notify只会唤醒一个等待线程，notifyAll会唤醒所有的等待线程，notify使用不当会导致死锁，所以更推荐使用notifyAll。
8. CountDownLatch,当一个或多个线程调用await时，线程会阻塞，当其他线程调用countDown时，计数器会减一，值为0时，被await阻塞的线程会被唤醒。
9. CyclicBarrier,和CountDLatch相对，做加法，达到输入值后会执行定义好的方法。
10. Semaphore,信号量主要定义了两种操作，acquire和release。调用acquire时，如果信号量能成功获取到则继续执行，否则就等待。release则会将信号量加1，然后唤醒等待的线程。       
11. ReadWriteLock,读-读操作是可以共存的，读-写，写-写是不可以共存的，会破坏读写一致性，ReadWriteLock解决该问题。
11. 阻塞队列
    1. ArrayBlockingQueue 基于数组结构的有界阻塞队列，FIFO
    2. LinkedBlockingQueue 基于链表结构的可设置有界的阻塞队列 FIFO，put时使用了ReentrantLock保证线程安全。
    3. SynchronousQueue 不存储元素的阻塞队列，每个插入操作要等到另一个线程调用移除操作。
12. 线程池
    1. Executors.newFixedThreadPool()  固定线程数的线程池
    2. Executors.newSingleThreadExecutor() 只有一个线程的线程池
    3. Executors.newCachedThreadPool() 动态调整的线程池
    4. 三种方法底层调用的都是ThreadPoolExecutor，他的实现是阻塞队列。
    5. 七大参数
        1. corePoolSize:常驻核心线程数，
        2. maximumPoolSize：线程池中的最大线程数
        3. keepAliveTime：空闲线程存活时间，超过这个存活时间，多余线程会被销毁。
        4. unit：时间单位
        5. BlockingQueue<Runnable> workQueue：阻塞队列，被提交但还没有被执行的任务
        6. ThreadFactory threadFactory：线程池中工作线程的线程工厂
        7. RejectedExecutionHandler handler：拒绝策略，当超过最大线程数时如何拒绝新的请求，最大数为maximumPoolSize+队列大小。
    6. 四种拒绝模式
        1. AbortPolicy:直接抛出异常阻止系统正常运行。
        2. CallerRunsPolicy:不会抛出异常也不会抛弃任务。将任务回退到调用者。
        3. DiscardPolicy：直接丢弃无法处理的任务
        4. DiscardOldestPolicy:抛弃等待最久的任务，就是最先入队列的那几个任务。
    7. 实际使用中都不使用，而是自己通过ThreadPoolExecutor自定义。   
13. CAS
    1. 比较并交换。先从主内存拿到最新数据并比较，如果和期望值一直返回true，否则返回false；
    2. 主要由unsafe类实现，unsafe方法都是native修饰，所以可以直接调用操作系统底层资源执行相应的任务。
    3. ABA问题,一个线程将数据修改成功后又修改了回来。解决方法，添加版本号。使用AtomicStampedReference多维护一个版本号。
    4. 由于自旋的存在，可能由于一直尝试不成功，会给CPU带来较大开销。(这个线程在操作前总有线程先修改)
    5. 只能保证一个变量的原子操作，多个变量还是需要加锁。
14. 锁
    1. 公平锁按照先来后到，非公平锁高优先级的可能会优先执行，非公平锁的吞吐量比公平锁大。
    2. ReentrantLock默认为非公平锁，Synchronized也是非公平锁。
    3. 可重入锁(递归锁).就是线程可以进入仍和一个他已经拥有锁所同步的代码块。Synchronized和ReentrantLock都是可重入锁。
    4. 自旋锁。用循环替代堵塞，CAS。
    5. 读写锁。ReadWriteLock，保证读-写，写-写的并发安全。

## Redis
1. Redis是一种分布式的内存数据库，索引从0开始，默认有16个库，Select命令切换。
2. 五大数据类型
    1. String，Redis的最基本类型，可以包含仍和数据，比如图片和序列化对象，一个字符串value最多可以是512M。
    2. List，简单的字符串列表，底层是一个链表。
    3. Set，无序的string集合，是通过HashTable实现的。
    4. Hash,一个string类型的field和value映射表。
    5. Zset，有序的string集合，每个元素关联到一个double类型的分数。成员是唯一的，分数是可以重复的。
    6. bitmap 新特性
3. Key的基础知识
    1. keys * 显示当前库下的所有key
    2. move key db 移动某个key到指定库
    3. expire key 秒钟 设定某key过期时间
    4. ttl key -1表示永不过期 -2表示已过期
    5. type key 查看key是什么类型
    6. exists key,判断某个key是否存在，存在为1，没有为0
    6. 对于已有值的key，重复赋值会覆盖。
4. String的基础知识
    1. set/get/del/append/strlen 看名知用途
    2. INCR/DECR 自增1/自减1 INCRBY/DECRBY 指定大小的加减，只能用于数字
    3. get/setrange 获得/设置指定区间的数据 
    4. setex set的同时设置存活时间
    5. setnx key不存在才set
    6. mset/mget/msetnx m代表more 多值赋值，msetnx必须要全部都不存在才能正常插入
    7. getset 先get再set
5. List的基础知识
    1. lpush/rpush/lrange lpush和rpush区别就是lpush往左边插，可以看做是头插法，rpush是尾插法。
    2. lpop/rpop/lindex/llen 看名知用途
    3. lrem key n value 删除n个指定value,如果value数少于n则有多少删多少
    4. ltrim key 截取后再赋值给key
    5. rpoplpush 源列表 目的列表 源列表rpop后lpush到目的列表
    6. lset key index value 根据下标设置值
    7. linsert key before/after v1 v2 多个v1只会插在第一个前后
    8. 底层是链表，头尾插入效率高，对中间元素操作效率较差，因为查询是O(n)的。
6. Set的基础知识
    1. sadd/smembers/sismember 添加/查询/检查
    2. scard 获取集合里的元素个数
    3. srem key value 删除某个元素
    4. srandmember key 随机出几个数
    5. spop 随机出栈
    6. smove key1 key2 n 将key1中的n赋给key2
    7. sdiff/sinter/sunion 差集/交集/并集
7. Hash的基础知识
    1. kv模式不变，但v变成了键值对
    2. hset/hget/hmset/hmget/hgetall/hdel    
    3. hkeys/hvals 拿到所有的key或val
    4. hincrby/hincrbyfloat
    5. hsetnx
8. Zset的基础知识
    1. zadd/zrange
    2. zrangebyscore
        1. withscores
        2. ( 代表不包含
        3. limit index step 添加返回限制
    3. zrem key value 删除元素
    4. zcard/zcount/zrank/zscore 统计个数/带区间的统计/获得指定value下标/获得分数
    5. zrevrange/zrevrangebyscore 翻转
9. Redis的持久化
    1. rdb Redis DataBase
        1. 指定的时间间隔内将内存中的数据集快照到硬盘。
        2. redis会单独创建(复制)一个子进程进行持久化，先将数据写入到临时文件，持久化过程结束后，用临时文件替换上次持久化的文件。
        3. RDB方式比AOF的方式更高效，但最后一次持久化的数据可能丢失。
        4. 数据保存在dump.rdb，快照可以自己设置触发机制，规则为在N秒内发生过M次修改。
        5. 人为FlushAll,ShutDown时会自动执行快照保存，重启时会从指定文件加载数据。
        6. save命令可以手动创建快照,阻塞的。bgsave在后台异步进行快照。
        7. stop-writes-on-bgsave-error 表示保存出错时是否停止数据写入，设置为no则代表不在乎数据一致性，或者有其他方法修复
        8. rdbchecksum 存储快照后，增加数据校验
        9. rdbcompression 存储快照后，是否进行压缩存储
        10. 优点，适合大规模的数据恢复，缺点就是最后一次时间段可能还没有触发保存，那么这部分数据就丢失了，还有由于fork进程，需要两倍的内存空间。
        11. conf修改中主要在snapshot区域。
    2. aof Append only file
        1. 已日志形式记录写操作，只追加不改写文件，redis启动后会读取该文件重新构建数据。
        2. conf修改中主要在Append only model,默认是关闭的。
        3. 如果存在aof那么优先加载aof，可以使用Redis-check-aof--fix修复
        4. Appendfsync
            1. always：每次数据变更都会记录，性能差但是数据完整性好
            2. Everysec：异步操作，每秒记录，一秒内宕机会有数据丢失
            3. no: 不会自动同步
        5. Rewrite，为了避免文件过大，当超过阈值时会触发重写机制，启动内容的压缩，只保留可以恢复数据的最小数据集。
        6. aof恢复效率低于rdb，保存的文件远大于rdb。
    3. 建议同时开启两张持久化方式
        1. RDB文件作为后备用途，只要15分钟备份一次就可以了。
        2. AOF最恶劣情况的数据丢失不超过两秒，但带来了持续的IO操作压力。AOF rewrite会造成阻塞，为减少rewrite的次数，AOF需要修改默认的重写基础大小和默认超过原大小100%重写。
10. Redis的事务
    1. 一个事务中的所有命令会被序列化，按顺序的穿行执行而不会被其他命令插入。Redis对事务是部分支持，命令错误才会全部取消执行。
    2. DISCARD：放弃事务
    3. EXEC：提交事务
    4. MULTI：开启事务，如果语句错误就全部失败，如果是语句正确但运行失败，那不会影响其他语句。
    5. UNWATCH：出现了别人的修改后要取消监控，在重新进行一次WATCH监控。
    6. WATCH key：相当于加了一个乐观锁，出现别人的修改后，整个事务队列的操作都无法执行。    
    7. 乐观锁：自己维护一个version字段，更新过后就会修改version，保证不会被其他线程的修改覆盖。
    8. 悲观锁：往往是互斥锁，只有一人能处理资源，极大地影响并发性。
11. 发布和订阅
    1. 进程间的消息通信模式：发送者发送消息，订阅者接受消息。
12. 主从复制，读写分离
    1. 主机数据更新后，根据配置和策略，自动同步到备机的master/slaver，Master以写为主，Slave以读为主
    2. 配从不配主。
    3. 从库配置：slaveof 主库IP 主库端口
    4. 第一次连接是全量复制，后面是增量复制，复制会有延时。
    4. 一主多仆
        1. 一个master多个slaver。
        2. master负责写，slaver只负责读。
        3. 主机挂了后，从机原地待命，并不会自己转为主机，主机重连后可以直接连上。
        4. 从机挂了后，需要重新配置连接，除非写进配置文件。
        5. 主机压力较大。
    5. 薪火相传
        1. 部分从机也指向从机，降低主机的压力。
        2. 被从机连接的从机，身份上仍然是slaver。
    6. 反客为主
        1. slaveof no one
        2. 使当前数据库停止与其他数据库同步，转成主数据库
        3. 从库需要重新指向新的主库。
    7. 哨兵模式
        1. 反客为主的自动版，主机挂掉后，投票选出新主机，主机重连后变为从机。
        2. 新增sentinel.conf,用于配置监控主机挂掉后的投票数
        3. 使用redis-sentinel工具加载配置文件。    
        4. 哨兵是一个独立的进程，烧饼通过发送命令，等待Redis服务器响应，监控运行的多个Redis实例。
        5. 检测到master宕机后，投票选出新出及后通过发布订阅模式通知其他从机修改配置。   
13. 正常业务流程
    1. 先读cache，如果数据命中返回cache数据
    2. 如果没有命中，则去查db，将db读出来后放入缓存。 
13. 缓存击穿
    1. 一个存在的key，在缓存过期的一瞬间，大量请求击穿打到DB，造成瞬间DB请求压力过大。
    2. 采用互斥锁，没有拿到锁的线程自旋重新进入请求。
14. 缓存穿透
    1. 恶意访问一个不存在的key，缓存不起作用，直接打到db，造成大流量时DB挂掉。
    2. 设置一个存活时间较短的null值缓存，保证不会直接打到数据库。
15. 缓存雪崩
    1. 大量的key设置了相同的过期时间，导致缓存在同一时间全部失效。
    2. 缓存过期时间设置随机。

## mySql
1. MySql的存储引擎
    1. InnoDB
        1. 支持外键
        2. 支持事务
        3. 行锁，适合高并发
        4. 不仅缓存索引还要缓存真实数据，对内存要求较高
        5. 表空间大
        6. 关注点在于事务的控制
    2. MyISAM
        1. 不支持外键
        2. 不支持事务
        3. 表锁
        4. 缓存只缓存索引
        5. 表空间小
        6. 关注点在于性能，也就是查询更快
2. SQL慢的主要原因
    1. 查询语句写的烂
    2. 索引失效
    3. 关联查询太多join(设计不合理或不得已)
    4. 服务器调优
3. Join查询
    1. A INNER JOIN B ON A.key=B.key   A和B的交集，只有两者的公有部分
    2. A LEFT JOIN B ON A.key=B.key   全A,A的独有部分的B表数据补null
    3. A RIGHT JOIN B ON A.key=B.key   全B,B的独有部分的A表数据补null
    4. A LEFT JOIN B ON A.key=B.key where B.key is NULL   A独占,只查出A独有的部分
    5. A RIGHT JOIN B ON A.key=B.key where A.key is NULL   B独占,只查出B独有的部分
    6. A FULL OUTER JOIN B ON A.key=B.key A+B ,MySQL不支持这样的语法，可以用UNION实现 
    7. A FULL OUTER JOIN B ON A.key=B.key where A.Key is NULL or B.key is NULL A独占+B独占
4. 索引 (阿里一面题 谈谈你对索引的理解)
    1. 索引是一种帮助MySql高效获取数据的数据结构，可以简单理解为排好序的快速查找数据结构。
    2. 聚集索引，次要索引，覆盖索引，复合索引，前缀索引，唯一索引默认都是B+树索引。
    3. 优势：
        1. 提高数据检索的效率，降低数据库的IO成本。
        2. 降低数据排序的成本，降低了CPU的消耗。
    4. 劣势：
        1. 索引保存了准建和索引字段，所以索引列也要占空间。
        2. 索引能提高查询速度，同时会降低更新表的速度。MySQL在更新操作时，不仅要保存数据，还要更新索引。
        3. 索引需要花时间研究最优的索引，和业务环境有紧密联系。
    5. 单值索引：一个索引只包含单个列，一个表可以有多个单列索引。
    6. 唯一索引：索引列的值必须唯一，但允许有空值。
    7. 复合索引：一个索引有多个列,必须要按照顺序才能有效
    8. 覆盖索引：select的数据列只需要从索引中就能取得，不必读取数据行，也就是查询列被所建的索引覆盖。
    8. 创建索引的场景
        1. 主键自动建立唯一索引
        2. 频繁查询的字段应该创建索引。
        3. 查询中与其他表关联的字段，外键关系建立索引。
        6. 高并发下倾向于创建组合索引。
        7. 查询中排序的字段，排序字段若通过索引去访问，将提高排序速度。
        8. 查询中统计或者分组的字段，因为这两个操作都和排序有关。
    9. 不创建索引的场景
        1. 表记录太少
        2. 经常增删改的表
        3. 重复较多且分布平均，索引的选择性是指索引列中不同值的数目与表中记录数的比。
        4. where条件里用不到的字段不建立索引。
    10. Explain的使用
        1. id：表示查询中执行select子句或操作表的顺序。id相同执行顺序由上至下。id值越大，优先级越高，优先执行，所以要用小表驱动大表。
        2. select_type : 代表查询的类型  
            1. SIMPLE：不包含子查询和UNION
            2. PRIMARY：复杂查询中的最外层查询
            3. SUBQUERY：select或where中的子查询
            4. DERIVED:FROM中的子查询的临时表
            5. UNION：出现在UNION之后或包含UNION的子查询的最外层select。
            6. 从UNION表中获取结果的结果集。
        3. type：访问类型,最好到最差:system>const>eq_ref>ref>range>index>all，至少能达到range，最好能达到ref。
        4. possible_keys 可能应用到的索引，不一定被实际使用
        5. key：实际使用的索引。如果使用了覆盖索引，则该索引值出现在key中。
        6. key_len:索引中使用的字节数，可通过该列计算查询中使用的索引的长度。在不损失精确性的情况下，长度越短越好。
        7. ref：显示索引的哪一列被使用，并显示使用的是常量还是表数据。
        8. rows：每张表有多少行被优化器查询。
        9. extra:
            1. using filesort：会对数据使用一个外部的排序，而不是按照表内的索引。
            2. using tempory：使用了临时表保存中间结果，如order by，group by，极大影响性能。
            3. using index：使用了覆盖索引，避免了扫描数据行。
            4. using join buffer:多表连接时使用到的缓存
    11. 索引优化
        2. 双表分析：连接时都是相反的加索引，因为搜索的重点在于连接的表(左连接右表，右连接左表)，所以索引要加在搜索重点的表。
        3. 最佳左前缀法则：如果索引了多列，要遵循最佳左前缀法则，就是要从索引的最左前列开始，并且不能跳过中间的列。
        4. 不能在索引列上做任何计算。
        5. 范围查询会导致范围后的索引全部失效。可以考虑跳过排序字段建立索引，就是将可能要排序的字段放在索引的最后。
        6. 减少使用select*，只查询索引的字段效率会好一些，覆盖索引。
        7. 使用不等于符号会导致全表扫描。
        8. 涉及到is not null判断无法使用索引。
        9. like通配符%放左边会导致从当前开始的索引失效，放右边会比较好。如果左边一定要有%，使用覆盖索引优化。
        10. 字符串不加''会导致索引失效
        11. or会导致索引失效。
        12. order by的索引无法用于查找，但如果顺序一致可以用于排序，否则会导致fileSort.
        13. group by 分组之前必排序，所以会有临时表产生。规则和order by基本一致。
    12. 索引条件下推
    13. 主键索引
    14. 联合索引

## nginx
    1. 

## Spring 
1. 手写IOC:构造一个用于创建Bean对象的工厂
    1. 首先需要一个配置文件来配置我们的service和dao配置内容，唯一标识为全限定类名
    2. 读取配置文件内容，反射创建对象,解决对具体实现类的依赖。
    3. 工厂类加载时，将读取的内容涉及到的对象全部保存到map中，实现单例。
2. Bean的基础知识
    1. 三种创建方法
        1. 在spring的配置文件中使用bean标签，配以id和class属性后，且没有其他属性和标签。该方法要求必须要有默认构造函数。
        2. 使用普通工厂中的方法创建对象，并存入spring容器。
        3. 使用工厂中的静态方法创建对象，并存入spring容器。
    2. scope标签：singleton单例的,prototype多例的，request作用于请求范围，session作用于会话范围。
    3. 生命周期：
        1. 单例对象：和容器相同
        2. 多例对象：在使用时出生，使用过程中活着，由GC进行回收，spring不处理。
    4. 依赖注入：只需要在配置文件中说明，spring就能管理类之间的依赖关系。
        1. 构造函数注入：添加constructor-arg标签，优点在于注入数据时必须的操作，否则无法创建，缺点是改变了实例方法，造成参数的浪费。
        2. set方法注入：添加标签property，优点在于创建对象没有明确限制，可以直接使用默认构造函数，缺点在于如果某个成员必须有值，获取对象时可能出现值的缺失。
        3. 复杂数据类型，List结构和Map结构，List使用标签list array set，Map结构使用map,props。
2. 手写AOP：动态代理 (阿里一面题)
    1. 动态代理：字节码随用随创建，随用随加载，第一种可以使用Proxy类中的newProxyInstance方法第二种使用cglib。
    2. 方法参数：
        1. ClassLoader：类加载器，用于加载代理对象字节码,使代理对象和被代理对象用同样的类加载器代理谁就写谁
        2. Class[]: 字节码数组，让代理对象和被代理对象有相同的方法。
        3. InvocationHandler：用于提供增强的代码
    3. proxy：构造一个代理工厂，通过向工厂注入原始的对象，用动态代理的方式重写get方法，将代理对象放回容器。在invoke方法中，增加前置，后置，异常，最终四种方法。
    4. cglib：待补充
    
## 计算机网络
1. 传输层的TCP的三次握手和四次挥手
    1. 序列号seq：占4个字节，用于标记数据段的顺序
    2. 确认号ack：占4个字节，期待收到对方下一个报文段的第一个数据字节的序号，
    3. 确认ACK，占1为，仅当ACK=1时，确认号字段才有效。
    4. 同步SYN，连接建立时用于同步序号，当SYN=1，ACK=0时，表示这是一个连接请求的报文段，若同意链接，则在响应报文中使得SYN=1，ACK=1.因此SYN=1表示这是一个连接请求或连接接受报文，握手完成后被设置为0.
    5. 终止FIN，用于释放一个连接，FIN=1表示发送方的报文数据已经发送完毕，要求释放连接。
    6. 三次握手，连接确认
        1. 第一次握手：客户端发送SYN=1，初始序列号seq=x给服务器，并进入SYN_SENT状态，等待服务器确认。
        2. 第二次握手：服务器收到请求报文后，如果同意连接，发送报文SYN=1，ACK=1，服务器的初始序列号seq=y,确认号ack=x+1给客户端。服务器进入SYN_RECV状态。
        3. 第三次握手：客户端收到确认后，还要向服务器确认，发送ACK=1，序列号seq=x+1,确认号ack=y+1给服务器，都进入ESTABLISHED状态，建立连接，完成三次握手。
    7. 四次挥手
        1. 第一次挥手，客户端发出连接释放报文，FIN=1，seq=u，客户端进入FIN-WAIT-1状态。
        2. 第二次挥手，服务器收到连接释放报文，发送确认报文，ACK=1，ack=u+1，seq=v,服务端进入CLOSE-WAIT状态。
        3. 客户端收到服务器的确认请求后，客户端进入FIN-WAIY-2状态，等待服务器发送链接释放报文，在收到之前还需要接收服务器发送的最后的数据。
        4. 第三次挥手，服务器向客户端发送连接释放报文，FIN=1，ack=u+1，seq=w，服务器进入LAST-ACK状态，等待客户端确认。
        5. 第四次挥手，客户端收到连接释放报文后，发出确认，ACK=1，ack=w+1,seq=u+1,客户端进入TIME-WAIT状态，这时TCP连接还没释放，要经过2*MSL的时间，当客户端撤销相应的TCB，才进入CLOSED状态。
        6. 服务器收到客户端确认后，立即进入CLOSED。撤销TCB后，结束了此次的TCP连接。
    8. 为什么连接需要三次，而关闭需要四次
        1. 连接时，Server收到请求连接报文后，可以直接发送SYN+ACK报文，ACK用于应答，SYN用于同步。
        2. 关闭时，Server很可能不会立即关闭SOCKET，所以需要先回复一个ACK报文，告诉Client我收到了你的FIN报文，等到所有报文发送完，才能发送FIN报文。
    9. 为什么TIME_WAIT状态需要2MSL才能返回到CLOSE
        1. 我们需要假想网络是不可靠的，最后一个ACK可能丢失，TIME_WAIT状态就是用于重发可能丢失的ACK报文。
        2. Server如果没有收到ACK，将重复发送FIN片段，Client如果再次受到FIN，那么会重发ACK并重新计时。2MSL是一个发送一个回复所需要的最大时间，如果超过这个时间，就推断已经被接收，结束TCP。
    10. 为什么不能用两次握手
        1. 如果Server的应答在传输中被丢失了，那么会出现Server认为已经连接，但Client认为连接还未建立，会忽略Server的任何数据，只等待连接应答。
    11. 连接建立后，客户端出现问题会怎么办
        1. TCP设有保活计时器，如果客户端出现故障，服务器不会一直等下去。服务器每次收到客户端请求后都会重新复位计时器。
        2. 如果长时间，一般为2小时，服务器一直没有收到数据，服务器会发送一个探测报文，每隔75秒发送一次，如果10次还没有反应，服务器就认为客户端出故障了，关闭连接。