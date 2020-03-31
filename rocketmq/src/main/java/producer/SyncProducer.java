package producer;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.concurrent.TimeUnit;


/**
 * 发送同步消息
 *
 * @author liuxin
 * @version 1.0
 * @date 2020/3/31 15:21
 */
public class SyncProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
//        1. 创建生产者producer，并定制生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("group1");
//        2. 指定Nameserver地址
        producer.setNamesrvAddr("192.168.198.128:9876;192.168.198.129:9876");
//        3. 启动producer
        producer.start();
//        4. 创建消息对象，指定topic，tag和消息体
        for (int i = 1; i <= 10; i++) {
            /*
             * 参数1：Topic
             * 参数2：消息Tag
             * 参数3：消息内容
             */
            Message msg = new Message("base","tag1",("hello world"+ i).getBytes());
            //        5. 发送消息
            SendResult result = producer.send(msg);
            SendStatus sendStatus = result.getSendStatus();
            String msgId = result.getMsgId();
            int queueId = result.getMessageQueue().getQueueId();
            System.out.println("发送状态："+result+",消息ID"+msgId+",队列"+queueId);
            TimeUnit.SECONDS.sleep(1);
        }
//        6. 关闭生产者
        producer.shutdown();
    }
}
