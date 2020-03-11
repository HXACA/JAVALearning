# Java基础知识与常见面试题 

## 单例模式
1. 饿汉式：线程安全，反射不安全，反序列化不安全
2. 登记式：又称静态内部类式，线程安全，防止反射攻击，反序列化不安全
3. 枚举式：线程安全，支持序列化，反序列化安全，防止反射攻击
4. 懒汉式：线程不安全，延迟加载，可以加同步解决线程安全，效率低，加双捡锁优化，volatile避免由于指令重排出现的空对象。
5. ThreadLocal：在各个线程内式单例的，不同线程不保证单例
6. CAS：无锁乐观策略，线程安全

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
3.StringBuilder是没有线程安全的StringBuffer。

## HashMap,HashTable
1. HashMap允许null的value或者key，但是HashTable不允许。
2. HashMap在JDK1.7前和HashTable基本相同，但HashTable是线程安全的。
3. HashMap在JDK1.8时引入了红黑树。
4. JDK1.7中，HashMap为哈希表+链表，put为头插法，多线程时可能出现死循环。
5. JDK1.8中，HashMap引入了红黑树。当链表长度达到8，并且数组大小不小于64，就会将链表转为红黑树，如果是小于6就转回链表。多线程时可能出现数据被覆盖。

## ArrayList 和 LinkList
1. ArrayList是自扩容的动态数组实现，LinkList是双向链表实现。所以性能上随机访问Array比较好，指定位置删除添加Link好。

## & 和 &&
1. &&具有短路功能，&当左右不是boolean数据时为位运算符，表示按位与运算。

## 多线程的四种方式
1. 继承Thread，重写Run方法
2. 实现Runnable接口，重写call方法，可以用于处理同一资源以及多继承。
3. 实现Callable接口，重写call方法，可以拿到返回值，允许抛出异常。
4. 使用线程池，减少创建现成的时间，降低资源消耗，控制并发线程的数量，可以有返回值。

## synchronized 和 ReentrantLock
1. synchronized可以用来同步方法或代码块：
    1. 同步方法：给方法增加synchronized关键字，可以使静态方法，也可以是非静态方法，但不能是抽象方法。
    2. 同步代码块，通过锁定一个指定的对象，来对同步代码进行同步。
    3. 同步是高开销操作，减少使用同步方法，同步关键代码即可。
2. ReentrantLock：可重入锁，代码通过lock()方法获取锁，调用unlock释放锁。