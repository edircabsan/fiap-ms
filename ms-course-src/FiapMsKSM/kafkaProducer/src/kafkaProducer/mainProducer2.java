package kafkaProducer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

//import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class mainProducer2
{
	static String message = null;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	   
	       message = args[0].toString();
	      System.out.println(message);
	    
	    System.out.println("1");

	    System.out.println("2");
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("acks", "1"); //all
	    props.put("retries", 0);
	    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	    System.out.println("3");
	    Producer<String, String> producer = new KafkaProducer<String, String>(props);
	    //Producer<String, GenericRecord> producer = new KafkaProducer<String, GenericRecord>(props);
	    System.out.println("5");


	    //ProducerRecord<String, String> record = new ProducerRecord<>("meutopicos", "Precision Products", "FRANCEs"); 
	    ProducerRecord<String, String> record = new ProducerRecord<>("meutopicos", "Precision Products", message.toString()); 

	      try
		{
			RecordMetadata x = producer.send(record).get();
			System.out.println(x);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	      
	//    }

	  //  producer.close();
	}

}
