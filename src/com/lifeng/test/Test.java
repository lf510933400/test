package com.lifeng.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class Test {
	//单实例连接
	public void test() {
		//Jedis jedis=new Jedis("192.168.1", port);
	}
	public static void main(String[] args) {
		new Test().testCluster();
	}
	//redis连接池
	public void testpool() {
		//1、创建连接池
		JedisPool pool=new JedisPool("192.168.236.130", 6379);
		
		//2、获取连接
		Jedis jedis=pool.getResource();
		//3、赋值
		jedis.set("a", "adb");
		//取值
		String dd=jedis.get("a");
		System.out.println("得到的值是："+dd);
	}
	//集群连接redis
	public void testCluster() {
		//创建redis集群节点集合
		Set<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort("192.168.236.130", 6379));
		nodes.add(new HostAndPort("192.168.236.130", 6380));
		nodes.add(new HostAndPort("192.168.236.130", 6381));
		nodes.add(new HostAndPort("192.168.236.130", 6382));
		nodes.add(new HostAndPort("192.168.236.130", 6383));
		nodes.add(new HostAndPort("192.168.236.130", 6384));
		//创建redis集群
		JedisCluster cluster=new JedisCluster(nodes);
		cluster.set("key1", "你好世界");
		System.out.println(cluster.get("key1"));
		
		System.out.println("测试一下");
	}
	
}
