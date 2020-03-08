# Java基础知识与常见面试题 

* [单例模式](#单例模式)
* [异常](#异常)
* [Int 和 Integer](#int-和-integer)

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
    
