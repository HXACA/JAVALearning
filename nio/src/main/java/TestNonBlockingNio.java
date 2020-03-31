import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/31 11:45
 */
public class TestNonBlockingNio {
    @Test
    public void Client() throws IOException, InterruptedException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));
        //2.切换为非阻塞模式
        sChannel.configureBlocking(false);
        //3.缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4.发送数据
        buf.put(new Date().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();
        //5.关闭通道
        sChannel.close();
    }

    @Test
    public void Server() throws IOException {
        //获取通道
        ServerSocketChannel ssChanel = ServerSocketChannel.open();
        //切换非阻塞模式
        ssChanel.configureBlocking(false);
        //绑定端口
        ssChanel.bind(new InetSocketAddress(9898));
        //获得选择器
        Selector selector = Selector.open();
        //注册通道，并设置监听事件
        ssChanel.register(selector, SelectionKey.OP_ACCEPT);
        //轮训获取已经准备就绪的事件
        while(selector.select() > 0){
            Iterator<SelectionKey>it = selector.selectedKeys().iterator();
            while(it.hasNext()){
                SelectionKey sk = it.next();
                //接收就绪
                if(sk.isAcceptable()){
                    SocketChannel sChanel = ssChanel.accept();
                    sChanel.configureBlocking(false);
                    sChanel.register(selector,SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    SocketChannel outChanel = (SocketChannel) sk.channel();
                    int len = 0;
                    while((len = outChanel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                it.remove();
            }
        }
    }
}
