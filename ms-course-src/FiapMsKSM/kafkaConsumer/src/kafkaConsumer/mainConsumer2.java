package kafkaConsumer;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class mainConsumer2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	    if (args.length != 0) 
	    {
	      System.out.println("Please provide command line arguments: numEvents schemaRegistryUrl");
	      System.exit(-1);
	    }
	    System.out.println("1");

	    System.out.println("2");
	    Properties props = new Properties(); //OK
	    props.put("bootstrap.servers", "localhost:9092"); //OK
	    props.put("group.id", "CountryCounter"); //Consumer Group
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); 
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("heartbeat.interval.ms", 100);
	    props.put("auto.offset.reset", "earliest");
	    props.put("enable.auto.commit", true);
	    
	    System.out.println("3");
	    KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props); //Criacao do consumer
	    consumer.subscribe(Collections.singletonList("meutopicos")); //Subscribe to a topic
	    //consumer.subscribe(Pattern.compile("meu.*")); //Consumer subscribed para todos os topicos em Test
	    consumer.seekToBeginning(consumer.assignment()); //Desde o inicio
	    
	    try 
	    {
	    	System.out.println("4 aqui");
	    		while (true) 
	    		{
	    			ConsumerRecords<String, String> records = consumer.poll(100);
	    			consumer.seekToBeginning(consumer.assignment());
	    			//consumer.commitAsync((OffsetCommitCallback) consumer.assignment());
	    				for (ConsumerRecord<String, String> record : records)
	    				{
	    					//System.out.println("6 aqui");
	    					System.out.println(record.value());
//	    					Logger.debug("topic = %s, partition = %d, offset = %d, consumer = %s, country = %s\n", record.topic(), record.partition(), record.offset(), record.key(), record.value());
//	    					int updateCount = 1;
//	    					if (custCountryMap.ContainsValue(record.value()))
//	    					{
//	    						updateCount = custCountryMap.get(record.value()+1);
//	    					}
//	    					custCountryMap.put (record.value(), updatedCount)
//	    					JsonObject json = new JSONObject(custCountryMap);	
//	    					System.out.println(json.toString(4))
	    				}
	    			
	    		}
	    }finally {
	    	consumer.close();
	    }
}
}
