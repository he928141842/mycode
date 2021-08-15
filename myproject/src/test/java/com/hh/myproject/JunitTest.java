package com.hh.myproject;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.hh.myproject.base.MyCollector;
import com.hh.myproject.bean.*;
import com.hh.myproject.service.TestService;
import com.hh.myproject.util.Equator;
import com.hh.myproject.util.FieldBaseEquator;
import com.hh.myproject.util.FieldInfo;
import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.io.TempDir;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Format;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author hejiayuan
 * @date 2020-09-22 9:55
 */

public class JunitTest {



    @Test
    public void test() {
        HashMap map = new HashMap();
        System.out.println(map.get("1"));


    }

    @Test
    public void test2() {

        User user1 = new User("tom1", 10, Arrays.asList("吃饭", "睡觉"));
        User user2 = new User("tom", 10, Arrays.asList("吃饭", "看电影"));
        Equator equator = new FieldBaseEquator();
        List<FieldInfo> diffFields = equator.getDiffFields(user1, user2);
        System.out.println(diffFields);

    }

    @Test
    public void test4() {

        User user1 = new User("一般", 10, Arrays.asList("吃饭", "睡觉"));
        User user2 = new User("正常", 10, Arrays.asList("吃饭", "看电影"));
        List<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);

        User user3 = new User("严重", 10, Arrays.asList("吃饭", "睡觉"));
        User user4 = new User("一般", 10, Arrays.asList("吃饭", "看电影"));

        List<User> list2 = new ArrayList<>();
        list2.add(user3);
        list2.add(user4);

        Equator equator = new FieldBaseEquator(Arrays.asList("name"), null);
        //集合不能直接往里面扔
        List<FieldInfo> diffFields = equator.getDiffFields(list1, list2);

        System.out.println(diffFields);

    }

    @Test
    public void test3() {
        List<User> a = Arrays.asList(new User("1"));
        List<User> b = new ArrayList<>();

        b.addAll(a.stream().map(user -> {
            User u = new User();
            BeanUtils.copyProperties(user, u);
            return u;
        }).collect(Collectors.toList()));
        for (User s : b) {
            if (s.getName().equals("1")) {
                s.setName("aaa");
            }
        }

        System.out.println(a);


    }

    @Test
    public void test5() {
        List<String> list1 = Arrays.asList("001", "002", "003");//before
        List<String> list2 = Arrays.asList("002", "001");//after
        int containsNum = 0;
        Set list3 = new HashSet();
//        for (String beforeMod : list1) {
//
//            for (String afterMod : list2) {
//                if (Objects.equals(afterMod,beforeMod)) {
//                    containsNum++;
//                    break;
//                }
//                //如果包含了则已经break掉了  没包含的话添加到集合中去
//                list3.add(beforeMod);
//            }
//
//        }

        System.out.println(list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList()));


        // System.out.println(list3);


    }

    @Test
    public void test9() {
//        AnnotationConfigApplicationContext app  = new AnnotationConfigApplicationContext();
        //定义long型count为1
        long count1 = 11;

        //实例化format，格式为“000”
        Format f1 = new DecimalFormat("000");
        //将1变为001
        String count = f1.format(count1);
        System.out.println(count);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 3, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(1));

        threadPoolExecutor.execute(() -> {
            System.out.println("进来了");
        });


    }

    /**
     * spring
     */
    @Test
    public void test10() {
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");
        applicationContext1.getBean("user");

    }

    @Test
    public void test11() {
        User u1 = new User("张三", 340);
        User u2 = new User("张三", 340);
        User u3 = new User("李四", 341);
        User u4 = new User("李四", 341);
        User u5 = new User("张五", 350);
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5);

        Map<User, Long> collect = users.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map<String, String>> re = new ArrayList<>();
        collect.forEach((i1, i2) -> {
            Map<String, String> result = new HashMap<>();
            if (i2 > 1) {
                result.put("i1", i1.toString());
            }
        });


        System.out.println(collect);

    }

    @Test
    public void test12() {
        LocalDateTime now = LocalDateTime.now();
        Instant now2 = Instant.now();
        long l = now2.toEpochMilli();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(0), ZoneId.systemDefault());

        System.out.println(LocalDate.now());


    }

    @Test
    public void test14() {
        String a = "s.s.xlsx";
        boolean xlsx = a.endsWith("xlsx");
        System.out.println(xlsx);


    }

    @Test
    public void test13() {
        Apple apple = null;//new Apple("yellow",0);

        Apple apple1 = Optional.ofNullable(apple).orElse(new Apple("red", 1));
        Apple apple2 = Optional.ofNullable(apple).orElseGet(() -> new Apple("white", 2));
        /*
            一般情况下使用orelse  和 使用orelseget是一样的效果（这里指给默认值的情况）
            但是如果需要根据前面的值来决定是否执行 方法  如对数据库操作 或者调用远程方法等时   使用orElseGet
         */
        String a = null;
        System.out.println(Optional.ofNullable(a).orElse(B()));
        System.out.println(Optional.ofNullable(a).orElseGet(() -> B()));

    }

    @Test
    public void test15() {
        List<? extends Number> numberArray = new ArrayList<Number>();  // Number 是 Number 类型的
        List<? extends Object> numberArray2 = new ArrayList<>(); // Integer 是 Number 的子类
        List<? extends Number> numberArray3 = new ArrayList<Double>();  // Double 是 Number 的子类

        List<?>  l1 ;

    }
    @Test
    public void test16() {
        String a = "[{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"10\",\"aaa103\":\"月最低生活保障\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20525},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"15\",\"aaa103\":\"上年度全国城镇居民人均可支配收入\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20526},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"16\",\"aaa103\":\"失业代扣医疗社平工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20527},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"17\",\"aaa103\":\"区县社平\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20528},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"18\",\"aaa103\":\"全市全口径从业人员平均工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20529},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"21\",\"aaa103\":\"市企业职工最低工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20530},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"22\",\"aaa103\":\"市当月最低生活保障标准\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20531},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"31\",\"aaa103\":\"省社平工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20532},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"32\",\"aaa103\":\"省在岗\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20533},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"33\",\"aaa103\":\"市社平\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20534},{\"aaa100\":\"AAA009\",\"aaa101\":\"工资类型\",\"aaa102\":\"34\",\"aaa103\":\"市在岗\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20535},{\"aaa100\":\"AAA019\",\"aaa101\":\"工资类别\",\"aaa102\":\"1\",\"aaa103\":\"职工工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20536},{\"aaa100\":\"AAA019\",\"aaa101\":\"工资类别\",\"aaa102\":\"2\",\"aaa103\":\"灵活就业工资\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20537},{\"aaa100\":\"AAA019\",\"aaa101\":\"工资类别\",\"aaa102\":\"3\",\"aaa103\":\"单位工资总额\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20538},{\"aaa100\":\"AAA025\",\"aaa101\":\"基数算法类别\",\"aaa102\":\"0\",\"aaa103\":\"取整\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20539},{\"aaa100\":\"AAA025\",\"aaa101\":\"基数算法类别\",\"aaa102\":\"1\",\"aaa103\":\"一位小数\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20540},{\"aaa100\":\"AAA025\",\"aaa101\":\"基数算法类别\",\"aaa102\":\"2\",\"aaa103\":\"二位小数\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20541},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320102\",\"aaa103\":\"玄武区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20542},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320104\",\"aaa103\":\"秦淮区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20543},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320105\",\"aaa103\":\"建邺区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20544},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320106\",\"aaa103\":\"鼓楼区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20545},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320111\",\"aaa103\":\"浦口区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20546},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320113\",\"aaa103\":\"栖霞区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20547},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320114\",\"aaa103\":\"雨花台区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20548},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320115\",\"aaa103\":\"江宁区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20549},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320116\",\"aaa103\":\"六合区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20550},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320124\",\"aaa103\":\"溧水区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20551},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320125\",\"aaa103\":\"高淳区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20552},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320131\",\"aaa103\":\"经济技术开发区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20553},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320140\",\"aaa103\":\"江北新区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20554},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320199\",\"aaa103\":\"南京市市本级\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20555},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320205\",\"aaa103\":\"锡山区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20556},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320206\",\"aaa103\":\"惠山区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20557},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320211\",\"aaa103\":\"滨湖区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20558},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320213\",\"aaa103\":\"梁溪区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20559},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320214\",\"aaa103\":\"新吴区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20560},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320281\",\"aaa103\":\"江阴市\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20561},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320282\",\"aaa103\":\"宜兴市\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20562},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320292\",\"aaa103\":\"经开区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20563},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320299\",\"aaa103\":\"无锡市市本级\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20564},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320302\",\"aaa103\":\"鼓楼区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20565},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320303\",\"aaa103\":\"云龙区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20566},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320304\",\"aaa103\":\"九里区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20567},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320305\",\"aaa103\":\"贾汪区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20568},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320311\",\"aaa103\":\"泉山区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20569},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320312\",\"aaa103\":\"铜山区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20570},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320321\",\"aaa103\":\"丰县\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20571},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320322\",\"aaa103\":\"沛县\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20572},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320324\",\"aaa103\":\"睢宁县\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20573},{\"aaa100\":\"AAA027\",\"aaa101\":\"统筹区\",\"aaa102\":\"320371\",\"aaa103\":\"徐州经济技术开发区\",\"aae013\":\"基础库\",\"aae100\":\"1\",\"bgez01\":\"320000\",\"bgz001\":20574}]";

        List<AA10> aa10s = JSONObject.parseArray(a, AA10.class);
        long start = System.currentTimeMillis();
        ConcurrentMap<String, List<ConcurrentHashMap<String, Object>>> collect = aa10s.parallelStream().map(item -> {
            ConcurrentHashMap<String, Object> map = new ConcurrentHashMap();
            map.put("code", item.getAaa100());
            map.put("value", item.getAaa102());
            map.put("content", item.getAaa103());
            return map;
        }).collect(Collectors.groupingByConcurrent(m -> {
            Map<String, Object> pa = m;
            return pa.get("code").toString();
        }));


        //aa10s.stream().collect(Collectors.groupingBy(AA10::getAaa100));

        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }

    @Test
    public void test17() {
        String t = "20201225";
        LocalDate parse = LocalDate.parse(t, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse.toString());
    }

    @Test
    public void test18() {
        List<Stu> studentDTOS = Lists.newArrayList();
        for (int i = 0; i < 2000000; i++) {
            Stu studentDTO = new Stu();
            studentDTO.setUserId(new Random().nextInt(20000) + 10);
            studentDTO.setFromClassId(String.valueOf(new Random().nextInt(2) + 10));
            studentDTOS.add(studentDTO);
        }

        long l = System.currentTimeMillis();
        Map<Integer, List<Stu>> map = studentDTOS.stream().collect(Collectors.groupingBy(Stu::getUserId));
        System.out.println(System.currentTimeMillis() - l);

        l = System.currentTimeMillis();
        ConcurrentMap<Integer, List<Stu>> map2 = studentDTOS.parallelStream().collect(Collectors.groupingByConcurrent(Stu::getUserId));
        System.out.println(System.currentTimeMillis() - l);
        
        l = System.currentTimeMillis();
        Map<Integer, List<Stu>> map3 = studentDTOS.parallelStream().collect(Collectors.groupingBy(Stu::getUserId));
        System.out.println(System.currentTimeMillis() - l);

        boolean result = mapCompar(studentDTOS, map, map2);
        System.out.println();
        System.out.println(result);

    }

    /**
     * 测试重写的collector
     */
    @Test
    public void  test19(){
        List<Stu> studentDTOS = new ArrayList<>();

        for (int i = 0; i < 2000000; i++) {
            Stu studentDTO = new Stu();
            studentDTO.setUserId(new Random().nextInt(20000) + 10);
            studentDTO.setFromClassId(String.valueOf(new Random().nextInt(2) + 10));
            studentDTOS.add(studentDTO);
        }
        //Map<String, String> collect = strings.stream().collect(new MyCollector<>());
        // 加 concurrent  8952ms
        long start = System.currentTimeMillis();
        Map<Stu, Stu> collect = studentDTOS.parallelStream().collect(new MyCollector<>());
        System.out.println(System.currentTimeMillis()-start);

    }
    @Test
    public void test20(){
        List<User> users = Arrays.asList(new User("jack", 11, null, "武汉")
                ,new User("jack", 11, null, "武汉")
                , new User("jack", 11, null, "日本")
                , new User("jack", 11, null, "安徽")
                , new User("jack", 11, null, "北京")
                , new User("tony", 11, null, "武汉")
                , new User("tom", 11, null, "武汉"));
        List<User> tom = users.stream().filter(item -> Objects.equals(item.getName(), "tom")).collect(Collectors.toList());
        System.out.println(tom);


        Map<String, List<String>> collect = users.stream().collect(Collectors.groupingBy(User::getCity, Collectors.mapping(User::getName, Collectors.toList())));
        collect.forEach((String,set)->{
            System.out.println(String+"；set:"+set);
        });

    }

    @Test
    public void test21(){
        List<User> users = Arrays.asList(new User("20210418"), new User("20210420"), new User("20210419"));
        List<User> collect = users.stream().sorted(Comparator.comparing(User::getName)).collect(Collectors.toList());
        Collections.reverse(collect);
        System.out.println(collect);
    }


    @Test
    public void test22(){

        SameUser user = new SameUser();
        user.setName("tom");
        SameUser user1 = new SameUser();
        user1.setName("tom2");

        //这样应该会落到一个
        HashMap map = new HashMap();
        map.put(user,user);
        map.put(user1,user1);


    }
    @Test
    public void test23(){
        User user = new User();
        StringUtils.isEmpty(user);

    }

    private static boolean mapCompar(List<Stu> studentDTOS, Map<Integer, List<Stu>> hashMap, Map<Integer, List<Stu>> hashMap2) {

        boolean isChange = false;
        for (Map.Entry<Integer, List<Stu>> entry1 : hashMap.entrySet()) {
            List<Stu> m1value = entry1.getValue();
            if (hashMap2.get(entry1.getKey()) == null) {
                break;
            }
            List<Stu> m2value = hashMap2.get(entry1.getKey());

            if (!CollectionUtils.isEqualCollection(m1value, m2value)) {
                List<Stu> stus = studentDTOS.stream().filter(stu -> Objects.equals(entry1.getKey(), stu.getUserId())).collect(Collectors.toList());

                System.out.println("key:" + entry1.getKey());
                System.out.println("1:" + CollectionUtils.isEqualCollection(stus, m1value));
                System.out.println("2:" + CollectionUtils.isEqualCollection(stus, m2value));
                System.out.println();
                System.out.println("样板数据：");
                stus.forEach(s -> System.out.print(s.fromClassId + ","));
                System.out.println();
                System.out.println("m1数据：");
                m1value.forEach(m1 -> System.out.print(m1.fromClassId + ","));
                System.out.println();
                System.out.println("m2数据：");
                m2value.forEach(m2 -> System.out.print(m2.fromClassId + ","));
                break;
            }
            isChange = true;
        }
        return isChange;
    }
    static String B() {
        System.out.println("B()...");
        return "B";
    }

}
