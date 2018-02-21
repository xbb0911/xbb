package com.xbb.redis.jedistest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

/**
 * jedis连通性测试
 * @author xbb
 *
 */
public class JedisDemo {
	
	Jedis jedis = null;
	
	@Before
	public void init(){
		jedis = new Jedis("192.168.163.128");
	}
	
	
	@Test
	public void testSortedset(){
		//给有序集合添加元素
		/*Map<String, Double> map = new HashMap<String, Double>();
		map.put("zhangsan", 100D);
		map.put("lisi", 90D);
		map.put("wangwu", 80D);
		jedis.zadd("jedis-sort-01", map);*/
		
		//返回有序集合的元素个数
		Long zcard = jedis.zcard("jedis-sort-01");
		System.out.println("有序集合元素个数:");
		System.out.println(zcard);
		
		//返回有序集合指定下标范围的元素(包括分数)
		Set<String> zrange = jedis.zrange("jedis-sort-01", 0, -1);
		System.out.println("有序集合指定下标范围内的所有元素递增序列:");
		for(String s:zrange){
			System.out.println(s);
		}
		
		Set<String> zrevrange = jedis.zrevrange("jedis-sort-01", 0, -1);
		System.out.println("有序集合指定下标范围内的所有元素递减序列:");
		for (String string : zrevrange) {
			System.out.println(string);
		}
		
		
		//返回有序集合指定分数范围内的元素
		Set<String> zrangeByScore = jedis.zrangeByScore("jedis-sort-01", 80, 100);
		System.out.println("有序集合指定分数范围内的所有元素递增序列:");
		for (String string : zrangeByScore) {
			System.out.println(string);
		}
		
		Set<String> zrevrangeByScore = jedis.zrevrangeByScore("jedis-sort-01", 100, 80);
		System.out.println("有序集合指定分数范围内的所有元素递减序列:");
		for (String string : zrevrangeByScore) {
			System.out.println(string);
		}
		
	}
	
	
	
	@Test
	public void testSet(){
		//给集合中添加元素
		/*jedis.sadd("jedis-set-01", "zhangsan","lisi","wangwu");
		Set<String> smembers = jedis.smembers("jedis-set-01");
		for(String s:smembers){
			System.out.println(s);
		}*/
		
		//返回集合中的元素个数
		/*Long scard = jedis.scard("jedis-set-01");
		System.out.println(scard);*/
		
		//判断一个元素是否是集合中的元素
		/*Boolean sismember = jedis.sismember("jedis-set-01", "zhangsan");
		System.out.println(sismember);*/
		
		//随机移除并返回一个集合的元素
		/*String spop = jedis.spop("jedis-set-01");
		System.out.println(spop);*/
		
		//返回集合的所有元素
		Set<String> smembers = jedis.smembers("jedis-set-01");
		for(String s:smembers){
			System.out.println(s);
		}
		
		
	}
	
	
	@Test
	public void testHash(){
		//在哈希表中插入元素
		/*jedis.hset("jedis-h-key-01", "sex", "man");
		String hget = jedis.hget("jedis-h-key-01", "sex");
		System.out.println(hget);*/
		
		//在哈希表中插入field域不存在的元素
		/*jedis.hsetnx("jedis-h-key-01", "age", "25");
		String hget = jedis.hget("jedis-h-key-01", "age");
		System.out.println(hget);*/
		
		//返回哈希表key的域的个数
		/*Long hlen = jedis.hlen("jedis-h-key-01");
		System.out.println(hlen);*/
		
		//给哈希表key的field域增加值
		/*Long hincrBy = jedis.hincrBy("jedis-h-key-01", "age", 1);
		System.out.println(hincrBy);*/
		
		//返回哈希表key中所有域-值对
		System.out.println("哈希表中的所有域-值对:");
		Map<String, String> hgetAll = jedis.hgetAll("jedis-h-key-01");
		Set<String> keySet = hgetAll.keySet();
		for(String key:keySet){
			System.out.println(key+"--"+hgetAll.get(key));
		}
		
		//返回哈希表中所有的域
		System.out.println("哈希表中所有的域:");
		Set<String> hkeys = jedis.hkeys("jedis-h-key-01");
		for(String key:hkeys){
			System.out.println(key);
		}
		
		//返回哈希表中所有的域的值
		System.out.println("哈希表中所有域的值:");
		List<String> hvals = jedis.hvals("jedis-h-key-01");
		for(String s:hvals){
			System.out.println(s);
		}
		
		
	}
	
	
	
	@Test
	public void testList(){
		//在链表的头部插入元素
		/*Long count = jedis.lpush("jedis-l-key-01", "zhangsan","lisi","wangwu");
		System.out.println("插入的元素个数:"+count);*/
		
		List<String> lrange = jedis.lrange("jedis-l-key-01", 0, -1);
		System.out.println("创建的链表元素为:");
		for(String s:lrange){
			System.out.println(s);
		}
		
		//在链表的中间插入新元素
		/*jedis.linsert("jedis-l-key-01", LIST_POSITION.BEFORE, "zhangsan", "zhaoliu");
		System.out.println("插入新元素的链表为:");
		List<String> lrange2 = jedis.lrange("jedis-l-key-01", 0, -1);
		for(String s:lrange2){
			System.out.println(s);
		}*/
		
		Long count = jedis.lrem("jedis-l-key-01", 3, "zhangsan");
		System.out.println("成功删除了"+count+"个zhangsan");
		List<String> lrange3 = jedis.lrange("jedis-l-key-01", 0, -1);
		for(String s:lrange3){
			System.out.println(s);
		}
			
	}
	
	
	@Test
	public void testString(){
		//插入一条String类型的数据
		/*String set = jedis.set("jedis-s-key-001", "aaa");
		System.out.println(set);*/
		
		//获取一条String类型的数据
		/*String string = jedis.get("jedis-s-key-001");
		System.out.println(string);*/
		
		//子字符串的获取
		/*String getrange = jedis.getrange("jedis-s-key-001", 1, -1);
		System.out.println(getrange);*/
		
		//子字符串的替换
		/*jedis.setrange("jedis-s-key-001",0,"xbb");
		String string = jedis.get("jedis-s-key-001");
		System.out.println(string);*/
		
		//如果偏移量超出字符串的长度,则会自动补充\0x00
		/*jedis.setrange("jedis-s-key-001",6,"aaa");
		String string = jedis.get("jedis-s-key-001");
		System.out.println(string);*/
		
		//setnx会判断指定的key是否存在,如果已存在,则不会插入数据
		for(int i = 0; i < 5; i++){
			jedis.setnx("jedis-s-key-00"+i, "xbb-"+i);
		}
		
		for(int j = 0; j < 5; j++){
			String string = jedis.get("jedis-s-key-00"+j);
			System.out.println(string);
		}
		
	}
	
	
	
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("192.168.163.128");
		
		//连通性测试
		String ping = jedis.ping();
		System.out.println(ping);
	}
	

}
