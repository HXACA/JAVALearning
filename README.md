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
5. 

## 方法重写和覆盖
1. 重写指子类中重写父类的方法，实现的功能不同。要求必须满足两同两小一大。
    1. 访问修饰符要大于等于父类。
    2. 方法名和参数相同。
    3. 返回值是引用数据类型要小于等于父类，基本数据类型的返回值必须相同。
    4. 抛出的异常更小。
2. 重载指方法名相同，参数类型和类型不同。
3. final方法，静态方法，private等子类不可见方法不可被重写。

## HashMap,HashTable
1. HashMap允许null的value或者key，但是HashTable不允许。
2. HashMap的默认大小为16，扩容因子为0.75。
2. HashMap在JDK1.7前和HashTable基本相同，但HashTable是线程安全的。
3. HashMap在JDK1.8时引入了红黑树。
4. JDK1.7中，HashMap为哈希表+链表，put为头插法，多线程时可能出现死循环。
5. JDK1.8中，HashMap引入了红黑树。当链表长度达到8，并且数组大小不小于64，就会将链表转为红黑树，如果是小于6就转回链表。多线程时可能出现数据被覆盖。
6. HashSet的底层是HashMap。相当于是一个只有key的HashMap,value是一个假的Object。

## ArrayList 和 LinkList
1. ArrayList是自扩容的动态数组实现，LinkList是双向链表实现。所以性能上随机访问Array比较好，指定位置删除添加Link好。
2. ArrayList线程不安全，多线程插入数据时会出问题。可以使用Collections.synchronizedList,CopyOnWriteArrayList解决。
3. Collections.synchronizedList写的效率高，CopyOnWriteArrayList有一个复制操作所以效率低。
4. CopyOnWriteArrayList的容器可以实现在读取的时候其他线程修改数据，因为他把要读取的和写的容器分开，实现了读写分离，不须加锁，所以读的效率更高。

## & 和 &&
1. &&具有短路功能，&当左右不是boolean数据时为位运算符，表示按位与运算。

## JVM
1. JVM结构
    1. https://blog.csdn.net/ocean_fan/article/details/79298076
2. 类加载器
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
6. JAVA栈
    1. 线程不共享。
    2. 栈管运行，堆管存储。
    3. 栈不存在垃圾回收，因为线程结束占内存也就释放。
    4. 8种基本类型变量+对象的引用变量+实例方法都是在函数的栈内存中分配。
    5. 每个方法执行的同时会创建一个栈帧，用于存储局部变量表，操作数栈，动态链接，方法出口等信息，栈的大小和具体的JVM实现有关。
7. 堆
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
    5. -Xms 初始分配大小，默认为物理内存的“1/64”  
       -Xmx 最大分配内存，默认为物理内存的“1/4"
       -XX:SurvivorRatio = Ratio ,设置Eden和一个Survivor的比例。  
       -XX:MaxTenuringThreshold 设置对象在新生代中的存活次数，默认是15,15是由JVM的年龄计数用的是0000决定的。
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
    2. 四种垃圾收集算法  
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
        4. 标记压缩
            1. 在标记清除的基础上，将存活对象滑动到连续区域，处理内存碎片问题。
            2. 可以和标记清除结合，多次GC后再压缩。
    3. 七种垃圾收集器
        1. 新生代：
            1. Serial
                1. 针对新生代，采用复制算法。
                2，单线程收集且垃圾收集时必须暂停所有工作线程。
                3. 依然是HotSpot在Client模式下的默认新生代收集器。
            2. ParNew
                1. 多线程收集,相当于是Serial收集器的多线程版本。
                2. 其他特点和Serial一样。
                3. 除了Serial只有ParNew可以和CMS收集器配合工作。
                4. 单CPU环境，不会比Serial效果更好，因为存在线程交互的开销。
            3. Parallel Scavenge
                1. 又被称为吞吐量收集器。
                2. 新生代收集器，采用复制算法，多线程收集。
                3. 他的关注点与其他收集器不同，他的目的是达到一个可控制的吞吐量。也就是控制用户代码在CPU总消耗中的比值。
                4. 适用场景:高吞吐量为目标，减少垃圾收集时间。
        2. 老年代：
            1. CMS
                1. 并发标记清理。
                2. 基于标记-清除，不进行压缩操作，产生内存碎片。可以设置参数"-XX:+CMSFullGCsBeforeCompaction"，在多次FGC后执行一次压缩操作。
                3. 目的是获取最短的回收停顿时间，并发收集。
            2. Serial Old(MSC)
                1. 是Serial的老年代版本
                2. 采用标记-整理(标记-清除，标记-压缩)方法，单线程收集，需要暂停所有用户线程。
            3. Parallel Old
                1. 采用标记-整理算法，多线程收集。
                2. 配合Parallel Scavenge，解决注重吞吐量和CPU资源敏感的场景。
        3. 整堆收集器:
            1. G1
                1. 并行与并发
                2. 分代收集，收集范围包括新生代和老年代。但这里的分代和Java堆的内存布局不一样。
                3. 整体上看是标记整理，从局部来看是基于复制的。不会产生碎片，有利于长时间运行。
                4. 可预测的停顿，实现了高吞吐量。可以明确指定M毫秒内，垃圾收集消耗的时间不超过N毫秒。
9. JMM
    1. 线程对变量的操作必须要在工作内存中，首先要把变量拷贝到线程自己的工作空间，然后对变量进行操作，操作完成后再将变量写会主内存。
    2. 可见性。由于工作内存和主内存分开，所以某个线程修改完某个变量后，在其他线程中，未必能观察到变量的修改。volatile修饰的变量具备对其他线程的可见通知性，因为他会立即更新到主内存，synchronized和final也能实现可见性。
    3. 原子性。操作不可分割，同时成功或同时失败。被synchronized关键字或其他锁包括起来的操作也可以认为是原子的。
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
    3. JDK5前synchronized的性能较低，JDK6后性能基本一致。
    4. ReentrantLock可以配合多个condition实现指定唤醒。
    5. 类中有多个synchronized方法，synchronized锁的是当前的实例对象this，所以同一时刻只能有一个线程能调用其中一个synchronized方法。
    6. 当锁上的是静态方法，锁的是当前Class对象，所以即使是多个实例，也只能有一个调用静态方法。
    7. 普通方法上锁和静态方法上锁，两者不会互相影响，因为锁的对象不一样，一个是当前模板一个是对象示例，
6. 多线程中为防止虚假唤醒，避免使用if，使用while。
7. notify只会唤醒一个等待线程，notifyAll会唤醒所有的等待线程，notify使用不当会导致死锁，所以更推荐使用notifyAll。
8. CountDownLatch,当一个或多个线程调用await时，线程会阻塞，当其他线程调用countDown时，计数器会减一，值为0时，被await阻塞的线程会被唤醒。
9. CyclicBarrier,和CountDLatch相对，做加法，达到输入值后会执行定义好的方法。
10. Semaphore,信号量主要定义了两种操作，acquire和release。调用acquire时，如果信号量能成功获取到则继续执行，否则就等待。release则会将信号量加1，然后唤醒等待的线程。       
11. ReadWriteLock,读-读操作是可以共存的，读-写，写-写是不可以共存的，会破坏读写一致性，ReadWriteLock解决该问题。
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
        1. AbortPolicy:直接抛出异常组织系统正常运行。
        2. CallerRunsPolicy:不会抛出异常也不会抛弃任务。将任务回退到调用者。
        3. DiscardPolicy：直接丢弃无法处理的任务
        4. DiscardOldestPolicy:抛弃等待最久的任务，就是最先入队列的那几个任务。
    7. 实际使用中都不使用，而是自己通过ThreadPoolExecutor自定义。
    
## Redis
1. Redis索引从0开始，默认有16个库，Select命令切换。
2. 五大数据类型
    1. String，Redis的最基本类型，可以包含仍和数据，比如图片和序列化对象，一个字符串value最多可以是512M。
    2. List，简单的字符串列表，底层是一个链表。
    3. Set，无序的string集合，是通过HashTable实现的。
    4. Hash,一个string类型的field和value映射表。
    5. Zset，有序的string集合，每个元素关联到一个double类型的分数。成员是唯一的，分数是可以重复的。
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
    
