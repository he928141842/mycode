package com.hh.myproject.base.面试题3.redis;

/**
 * @author hejiayuan
 * @create 2021-08-06-18:56
 */
public class RedisDemo {
    public static void main(String[] args) {
        /**
         * https://blog.csdn.net/u011863024/article/details/115270840
         * 小程序的投票功能，每个人只能投十票
         * 可以用hash结构  大体思路就是hset  项目id 张三 1 李四 2
         *                点击投票前 hget 项目id 张三 拿到数量 判断小于10 则
         *                使用HINCRBY 项目id 张三 1票
         *                大于10可以直接返回提示
         *
         *       redis实现分布式锁  1、注意设置超时时间 保证释放锁  2、保证删除的是自己的锁 value
         *          3、设置获取锁多长时间就返回  4、保证删除锁的操作是原子性的  推荐lua脚本  也可以通过redis事务
         *          redis集群环境下 可能出现主节点加锁了以后  没有来得及复制给其他节点 redisson也存在
         *          5、 超时时间到了业务还没做完 加时间  通过redisson启动开门狗后台线程去实现了
         *          6、为了防止特别高的并发下  自己的锁被别人解除 （可能性低）在finally中
         *          //添加后，更保险
         * 		    if(redissonLock.isLocked() && redissonLock.isHeldByCurrentThread()) {
         *     		redissonLock.unlock();
         *                }
         *
         *
         */


    }
}
