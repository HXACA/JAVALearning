package producer;

import bean.OrderStep;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/31 16:25
 */
public class OrderProducer {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("192.168.198.128:9876;192.168.198.129:9876");
        producer.start();
        List<OrderStep> orderSteps = OrderStep.buildOrders();
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < orderSteps.size(); i++) {
            Message msg = new Message("OrderTopic", "Order", "i" + i, orderSteps.get(i).toString().getBytes());
            messages.add(msg);
//            SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
//                /**
//                 *
//                 * @param list 队列结合
//                 * @param message 消息对象
//                 * @param o 业务标识
//                 * @return
//                 */
//                @Override
//                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
//                    Long orderId = (Long) o;
//                    long index = orderId % list.size();
//                    return list.get((int) index);
//                }
//            }, orderSteps.get(i).getOrderId());
//            System.out.println(sendResult);
        }
        SendResult sendResult = producer.send(messages);
        producer.shutdown();
    }
}
