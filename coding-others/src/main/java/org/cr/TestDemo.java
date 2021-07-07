package org.cr;

import java.io.*;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.cr.testClass.SubClass;
import org.junit.Test;

public class TestDemo implements Cloneable, Serializable{

    public static final int serialVersionUID = 123;

    /**
     * test
     */
    public static void test() {
        char c = '1';
        System.out.println((int) c);

        String str = "-03";
        int i = Integer.parseInt(str);
        System.out.println(i);
        System.out.println(Math.pow(10, i));
        String str2 = "1.23400";
        double j = Double.parseDouble(str2);
        System.out.println(j * Math.pow(10, i));

        String str3 = "1.59";
        // System.out.println(Integer.parseInt(str3));
        System.out.println(Math.round(Double.parseDouble(str3)));
    }

    /**
     * ���� String��ķ���
     *
     * @param
     */
    public static void testString(String str) {
        // System.out.println(str.value.length);
    }

    /**
     * ����С���ıȽ��ж�
     *
     * @param
     */

    @Test
    public void testDoubleCompare() {
        double a = 1.23;
        double b = 1.2300;
        System.out.println(a == b); // true
        System.out.println(0x1);    // 1
        System.out.println(077);
    }

    /**
     * ���� �ַ�
     *
     * @param
     */

    @Test
    public void testChar() {
        char mode[] = new char[]{1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
        System.out.println(mode[0] == '1'); // false
        System.out.println(mode[0]);    // ����1��Ӧ���ַ�Ϊ
    }

    /**
     * ���� String���replaceAll()����
     *
     * @param
     */
    public static void testReplaceAll() {
        String a = "chenruichenrui";
        a = a.replaceAll("c", "");
        System.out.println(a);
    }

    /**
     * ��װ�� 128����Ϊtrue Integer a = 100 �����ڲ����������ģ� Integer i = Integer.valueOf(100);
     * �Զ�װ�� ��valueOf�����ڲ���ȥȡ���棨Ĭ�Ϸ�Χ [-128, 127]�� �����ᴴ���¶��� (��Ԫģʽ,-128��127)
     */
    @Test
    public void testIntegerCompare() {
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true, �����128����false
        Integer c = new Integer(127);
        Integer d = new Integer(127);
        System.out.println(c == d); // false
        System.out.println(Integer.MAX_VALUE == ((1<<31)-1));
        System.out.println(Integer.MAX_VALUE);


        // �Զ����������
        int i = 127;
        System.out.println(c == i); // true ��Ϊ i Ϊ��������,c���Զ�����,����ֵ�Ƚ�,����true
        System.out.println(new Double(127.0) == i);   // true, �Զ�����??
    }

    @Test
    public void testIntegerCompare2() throws Exception {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Float g = 3.0f;
        System.out.println(c == d); // true
        System.out.println(e == f); // false
        System.out.println(c == (a + b));   // true ,"==" ��������������Զ�����
        System.out.println(c.equals(a + b));// true
        System.out.println(g == (a + b));   // true ,�������������Զ�����
        System.out.println(g.equals(a + b));// false
    }

    /**
     * �������ô���,�����൱��һ��ָ��
     */
    class SimInt {
        int value;

        public SimInt(int value) {
            this.value = value;
        }
    }

    public static void change1(SimInt si) {
        si = new TestDemo().new SimInt(3);// ����ָ�����µĶ���ԭ������Ӱ��
    }

    public static void change2(SimInt si) {
        si.value = 3;// ͨ�����ò��������ڲ���Ա��ԭ���󱻸ı�
    }

    // @Test
    public static void testPointer() {
        SimInt si1 = new TestDemo().new SimInt(1);
        System.out.println(si1.value);// ���1
        change1(si1);
        System.out.println(si1.value);// ���1
        change2(si1);
        System.out.println(si1.value);// ���3
    }

    @Test
    public void testLoop() throws Exception {
        loop:   // ��־λ,������������ѭ��
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            for (int j = 0; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (j == 5) break loop;
            }
        }

        int arr[][] = {{1, 2, 3}, {4, 5, 6, 7}, {9}};
        short c = 1;
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("i=" + i + ",j=" + j);
                if (arr[i][j] == 5) {
                    found = true;
                    break;
                }
            }
        }
    }

    /**
     * �����ַ���ֵ�ıȽ�
     */
    @Test
    public void testString() {
        String a= "";
        System.out.println(a.concat("Sd"));
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        System.out.println(s2 == "ab"); // false

        System.err.println(s2 == "ab"); // ��ӡ��ֵΪ��ɫ

        System.err.println(s2 == "ab");

        System.out.println(s3 == "ab"); // true
        // javac����ʱ���Զ��ַ�������ֱ����ӵı��ʽ�����Ż�,����Ҫ�ȵ�����ʱȥ���мӷ����㴦��,�����ڱ���ʱȥ�����еļӺ�,ֱ�ӽ�������һ����Щ���������Ľ��
        String cr = "chenrui"; // ���ַ�ʽ,java���Ȼ��ڻ����������Ƿ���"chenrui"�����������,�о�ֱ�ӽ����ַ��ֵ��cr,û�оʹ���һ��"chenrui",Ȼ���丳ֵ��cr
        String cr2 = "chenrui"; //
        System.out.println(cr == "chenrui"); // true
        System.out.println(cr == cr2); // true
        System.out.println(new String("cr") == new String("cr")); // false

        System.out.println("intern: " + (cr == cr.intern()));
    }

    public static void testMath() {
        double d1 = -0.5;
        System.out.println("Ceil d1=" + Math.ceil(d1));
        System.out.println("floor d1=" + Math.floor(d1));
        System.out.println(Math.ceil(0.5));
        System.out.println(Math.floor(0.5));
        System.out.println(Math.round(0.5));
    }

    /**
     * ����ʱ���
     */
    public static void testTimeString() {
        // ���� һ
        long currentTimeMillis1 = System.currentTimeMillis();
        // ���� ��
        long currentTimeMillis2 = Calendar.getInstance().getTimeInMillis();
        // ���� ��
        long currentTimeMillis3 = new Date().getTime();
        System.out.println(currentTimeMillis1);
        System.out.println(currentTimeMillis2);
        System.out.println(currentTimeMillis3);
    }

    @Test
    public void testEqual() {
        Integer a = 2;
        Long b = 2L;
        Double c = 2.0;
        // System.out.println(a == b); ��ͬ���͵�������Ƚ�,���뱨��
        System.out.println(a.equals(b)); // false,��ͬ����,����false
        System.out.println(a.equals(c)); // false
    }

    @Test
    public void testProtected() {
        SubClass sc = new SubClass();
        // System.out.println(sc.a); // �����protected��Ա,ֻ���������ͬһ�����ڱ�����,�����ǲ��ɼ���invisible
        sc.getSuperInfo();
    }

    /**
     * finallyһ������try
     * catch�е�return֮ǰִ��,�������finallyʹ����return����throw���,����ʹtrycatch�е�return����throwʧЧ
     * finally�е�return���Ḳ��try-catch�е�return���
     *
     * @param num
     * @return
     */
    public int getNumber(int num) {
        try {
            int result = 2 / num;
            return result;
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        } finally {
            if (num == 0)
                return -1;
            if (num == 1)
                return 1;
        }
    }

    @Test
    public void printNumber() {
        System.out.println(getNumber(0));
        System.out.println(getNumber(1));
        System.out.println(getNumber(2));
        System.out.println(getNumber(3));
    }

    /**
     * �����ַ���������
     */
    @Test
    public void testStringConnection() {
        String str = "hello world";
        str = str + 100;
        System.out.println(str);

        if (true) {
        }


        long i = 0xfffL;
        double x = 0.9239f;
        System.out.println(i);
        System.out.println(x);
        ThreadLocal threadLocal = new ThreadLocal();
    }

    /**
     * ����������ʽ 1.ʲô��������ʽ��̰�����̰��ƥ�� �磺String str="abcaxc"; Patter p="ab.*c";
     * ̰��ƥ��:������ʽһ����������󳤶�ƥ�䣬Ҳ������ν��̰��ƥ�䡣������ʹ��ģʽpƥ���ַ���str���������ƥ�䵽��abcaxc(ab.*c)��
     * ��̰��ƥ�䣺����ƥ�䵽����ͺã����ٵ�ƥ���ַ���������ʹ��ģʽpƥ���ַ���str���������ƥ�䵽��abc(ab.*c)�� 2.����������������ģʽ
     * Ĭ����̰��ģʽ�������ʺ���ֱ�Ӽ���һ���ʺţ����Ƿ�̰��ģʽ�� ���ʣ�{m,n}��m��n�� �������� +��һ������� ����0��һ��
     * �������Բ����Ĳ��ͣ�Ȼ�������Ŀ .��ʾ��\n֮��������ַ� ��ʾƥ��0-���� +��ʾƥ��1-���� (?=Expression)
     * ˳���ӣ�(?=\\()����ƥ�������� ����ģʽ���� src=".*? (?=\\()�� " �����������
     * ��Ϊƥ�䵽��һ��"�ͽ�����һ��ƥ�䡣����������ƥ�䡣��Ϊ�������
     */
    @Test
    public void testRegularExp() {
        String str = "������(������)(������)(������)";

        String patStr = ".*?(?=\\()"; // (?=Expression) ˳���ӣ�(?=\\()����ƥ��������; �����ʺ���ֱ�Ӽ���һ���ʺţ����Ƿ�̰��ģʽ��

        Pattern pattern = Pattern.compile(patStr);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testRegularExp2() {
        String text = "(content:\"rcpt to root\";pcre:\"word\";)";
        String rule1 = "content:\".+\""; // ̰��ģʽ
        String rule2 = "content:\".+?\""; // ��̰��ģʽ

        System.out.println("�ı���" + text);
        System.out.println("̰��ģʽ��" + rule1);
        Pattern p1 = Pattern.compile(rule1);
        Matcher m1 = p1.matcher(text);
        while (m1.find()) {
            System.out.println("ƥ������" + m1.group(0));
        }

        System.out.println("��̰��ģʽ��" + rule2);
        Pattern p2 = Pattern.compile(rule2);
        Matcher m2 = p2.matcher(text);
        while (m2.find()) {
            System.out.println("ƥ������" + m2.group(0));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testException() {
        String str = null;
        System.out.println(str.length());
        System.out.println("���Ե�Ԫ���Ե�expected");
    }

    @Test
    public void testAltInsert() throws Exception {
        System.out.println("idea ��ݼ������Ͱ�!");
    }

    /**
     * �����ַ�������ĳ�ʼ��
     *
     * @throws Exception
     */
    @Test
    public void testStringArray() throws Exception {
        String[] arr = new String[10];
        System.out.println(arr[0]); // null
        System.out.println(arr.length); // 10
    }

    /**
     * ����ArrayList
     * ��ָ��ArrayList���ͣ��������ݣ��ٴ�ȡ��ʱ��Ĭ����Object���ͣ�
     * �������Ĺؼ���instanceof�ؼ��֣�instanceofִ��ʱ��������java������ƣ�ʶ�������Ϣ��
     *
     * @throws Exception
     */
    @Test
    public void testList() throws Exception {
        List list1 = new ArrayList();
        list1.add(0);
        list1.add('c');
        List list2 = list1;
        System.out.println(list1 == list2); // true
        Object o = list1.get(0);    // �õ�����Object����
        System.out.println(o instanceof Integer);
        System.out.println(list1.get(0) instanceof Integer);    // true
        System.out.println(list2.get(0) instanceof Integer);    // true
        System.out.println(list2.get(1) instanceof Character);  // true
    }

    /**
     * @throws Exception
     */
    @Test
    public void testJVMMemory() throws Exception {
        int i = 0;
        i = i++;
        System.out.println(i);  // 0
    }

    public static void hello() {
        System.out.println("hello");
    }

    /**
     * ��̬���������������,���ᱨ��ָ���쳣
     *
     * @throws Exception
     */
    @Test
    public void testStaticMethod() throws Exception {
        TestDemo t = null;
        t.hello();  // ���ᱨ��
    }

    /**
     * ����ģ��
     */
    @Test
    public void testSomething() throws Exception {
        new TreeSet<>();
        TestDemo testDemo = new TestDemo();
        synchronized (testDemo) {
            // ����wait������Ҫ�Ȼ�ȡ������
            testDemo.wait();
        }
//        new LockSupport;
        new ReentrantReadWriteLock();
        new BufferedReader(new FileReader(""));
        new FileReader("");
        new PriorityQueue<>();
        new LinkedList<>();
        Arrays.asList(1, 2, 3);
        String str = "as";
        str.toCharArray();
        new Double(23);
        Stack<Object> objects = new Stack<>();
        Callable callable = new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        InputStream inputStream = new FileInputStream("");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ReentrantLock reentrantLock = new ReentrantLock();
        new Hashtable<>();
        Map<String, Integer> hashMap = new HashMap<>();
        new ArrayList<>();
        new Object();
        new Thread();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();

        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> entry :
                entries) {

        }
        new AtomicInteger();
        new ThreadLocal<>();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        int i = 0;
        int j = 0;
        String[] strings = {"������", "����", "��ԲԲ", "AngelaBaby"};
        while (true) {
            i++;
            j++;
            if (j == strings.length) j = 0;
            System.out.println(strings[j] + ", i wanna fuck you " + i + " times, suck my dick��");
            Thread.sleep(500);
            if (i == 100) break;
        }
    }

    @Test
    public void testHashCode() throws Exception {
        TestDemo testDemo = new TestDemo();
        TestDemo testDemo2 = new TestDemo();
        TestDemo testDemo3 = testDemo;
        new Object();
        System.out.println(testDemo.hashCode());
        System.out.println(testDemo2.hashCode());
        System.out.println(testDemo3.hashCode());
        int a = 4, b = 6;    // 100 110
        int i = a ^ b;  // ���
        System.out.println(i);
    }

    static int f = 3;

    @Test
    public void testAssignment() throws Exception {
        long t = 012;   // �˽���
        float f = -412;
        double d = 0x12345678;
//        byte b = 128;     // byte�ķ�ΧΪ-128-127
        System.out.println(d);
        System.out.println(t);
        System.out.println(this.f);
    }

    @Test
    public void testLambda() throws Exception {

        File file = new File("C:/Users\\hasee\\Downloads");
        /**
         * java8 lambda���ʽ
         */
        File[] files = file.listFiles((File f) -> f.getName().endsWith(".3gp"));
        /**
         * ԭʼд��
         */
        File[] files1 = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".3gp");
            }
        });
        for (File fi :
                files1) {
            System.out.println(fi.getName());
        }

        System.out.println("---------------�ָ���-------------------");
        for (File fi : files) {
            System.out.println(fi.getName());
        }

        System.out.println("-----------------�ָ���-----------------");
        File[] files2 = file.listFiles(f -> f.getName().endsWith(".3gp"));
        for (File fi :
                files2) {
            System.out.println(fi.getName());
        }
    }

    /**
     * ʹ��lambda���ʽ��������ڲ���
     * <p>
     * �ܽ᣺�������﷨��ʽ���Կ�����Lambda���ʽ����Ҫ���þ��Ǵ��������ڲ���ķ����﷨��������������ɡ�
     * 1.�β��б��β��б�����ʡ���β����͡�����β��б����ֻ��һ�������������������б��Բ����Ҳ����ʡ�ԡ�
     * 2.��ͷ(->).����ͨ��Ӣ�Ļ��ߺźʹ��ڷ�����ɡ�
     * 3.����顣��������ֻ����һ����䣬Lambda���ʽ����ʡ�Դ����Ļ����ţ���ô�������Ͳ�Ҫ�û����ű�ʾ��������
     * lambda�����ֻ��һ��return��䣬��������ʡ��return�ؼ��֡�
     *
     * @throws Exception
     */
    @Test
    public void testMode() throws Exception {
        System.out.println(100 % 3);  // 1
        System.out.println(100 % 3.0);// 1.0
        System.out.println(7.0 % 3);  // 1.0
    }

    @Test
    public void testThrowException() throws Exception {
        try {
            throwException(new int[]{0, 1, 2, 3, 4, 5});
        } catch (Exception e) {
            System.out.println("E");    // �����쳣
        }
    }

    public void throwException(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();   // ���쳣,��������ִ��
                } else {
                    System.out.println(i);
                }
            } finally {
                System.out.println("e");
            }
        }
    }

    @Test
    public void testFinally() throws Exception {
        System.out.println(f(3));   // 2
    }

    public int f(int num) {
        try {
            num = 2;
            return num;
        } finally {
            num = 564;
        }
    }

    public void changeArgs(Integer... a) {    // a��һ������
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /**
     * ���Ա䳤����,--->�﷨��,�ڱ䳤��������֮ǰ,����Ա����ʹ��������������ƹ��ܵ�
     *
     * @throws Exception
     */
    @Test
    public void testChangeArgs() throws Exception {
        changeArgs(1);
        changeArgs(2, 3);
        changeArgs(2, 3, 4, 5, 6);
    }

    public void testLambda2() throws Exception {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is original way!");
            }
        }).start();
        new Thread(() -> System.out.println("it's is a lambda function!")).start();
        System.out.println("this is main thread!");

        new Runnable() {
            @Override
            public void run() {
                System.out.println("this is not lambda way!");
            }
        }.run();
        Runnable r = () -> {
            System.out.println("this is lambda way!");
        };  // lambda���ʽ���������ڲ���
        r.run();
    }

    /**
     * ʹ��lambda���ʽ�Լ��Ͻ��е���
     */
    @Test
    public void iterTest() {
        List<String> languages = Arrays.asList("java", "scala", "python");
        //before java8
        for (String each : languages) {
//            languages.remove("scala");
            System.out.println(each);
        }

        System.out.println(languages);
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(languages.get(i));
//            languages.remove("python");
        }

        Iterator<String> iterator = languages.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println(str);
            if (str.equals("python"))
                iterator.remove();
        }

        //after java8
        languages.forEach(x -> System.out.println(x));
        languages.forEach(System.out::println);
    }

    @Test
    public void testCount() throws Exception {
        int count = 0;
        int num = 0;
        for (int i = 0; i <= 100; i++) {
            num = num + i;
            count = count++;  // count��ֵ����countֵ��������count�ԼӲ�Ӱ��count�����������ʽ��������
        }
        System.out.println("count*num: " + (count * num));
    }

    @Test
    public void testThreeMu() throws Exception {
        int a = 5;
        System.out.println("value is " + ((a < 5) ? 10.9 : 9)); // 9.0,�Զ�����ת��
    }

    @Test
    public void testMoveoper() throws Exception {
        int num = -10;
        System.out.println(Integer.toBinaryString(num));
        num = num << 1;
        System.out.println(Integer.toBinaryString(num));
        num = num >>> 1;
        System.out.println(Integer.toBinaryString(num));
    }

    @Test
    public void testSet() throws Exception {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(3);
        set.add(0);
        set.add(-1);
        set.add(1);
        for (Integer i:
             set) {
            System.out.print(i+" ");
        }
        System.out.println();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
    }

    @Test
    public void testAlibaba() throws Exception {
        int n = 3, m = 3;
        System.out.println(Math.pow(m-1,n)+Math.pow(-1,n)*(m-1));
    }

    @Test
    public void testJinzhi() throws Exception {
        int eight = 010;
        int six = 0xC;
        System.out.println(eight);
        System.out.println(six);
    }

    @Test
    public void testArrayList() throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.remove(0);
        Integer integer = arr.get(0);
        System.out.println(integer);
    }

    @Test
    public void testClassObject() throws Exception {
        Object o = new Object();
        System.out.println(o.hashCode());
        Class<?> aClass = o.getClass();
        System.out.println(aClass.hashCode());
        System.out.println(aClass.getName());
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());

        }
    }

    @Test
    public void testNull() throws Exception {
        new HashMap<String, String>().get(null);
        String.valueOf(null);   // ��ָ���쳣
    }

    @Test
    public void testRight() throws Exception {
        int i = -2000000000;
        int k = 2000000000;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(k));
        int j = i >>> 29;
        System.out.println(i >>> 30);   //???
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(0x10));   // ʮ�����ƣ�ÿһλ������λ������
    }

    @Test
    public void testShort() throws Exception {
        System.out.println(0xfff0);
    }

    public void testClone() throws CloneNotSupportedException {
        HashMap<Object, Object> map1 = new HashMap<>();
        Object map2 = map1.clone();
        System.out.println(map1 == map2);       // false, �½�һ�����󣬵��Ƕ���������ò�û��ʵ�ֿ�����Ϊǳ������
        System.out.println(map1.equals(map2));  // true
        TestDemo testDemo = new TestDemo();
        // ����Ҫʵ��Cloneable���ܵ���clone����
        Object clone = testDemo.clone();
        System.out.println(testDemo == clone);  // false
    }

    @Test
    public void testChinese() {
        char c = '��';
        System.out.println(c);
        System.out.println(Integer.valueOf(c));
        System.out.println(Integer.valueOf(Character.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1<<16);
    }

    @Test
    public void testSerialize() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d:/1.csv"));
        TestDemo testDemo = new TestDemo();
        out.writeObject(testDemo);
        out.close();
    }

    @Test
    public void testDeserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:/1.csv"));
        TestDemo testDemo = (TestDemo) in.readObject();
        System.out.println(testDemo);
    }

    @Test
    public void testBitCalculate() {
        // &&��||�ȣ�˫�������߼��������ֻ�����ڲ����ͱ�����&��|������λ�������������ʹ��
        System.out.println(3|9);
        System.out.println(true & false);
        System.out.println(true && false);
    }

    @Override
    public String toString() {
        return "org.cr.TestDemo{this is org.cr.TestDemo class, haha, fuck you}";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // testDoubleCompare();
        // System.out.println(Integer.parseInt("101",2)); //�Զ����ƽ���
        // testReplaceAll();

        // System.out.println(Math.pow(2, 23));
        // System.out.println(1<<23);
        // System.out.println(1.00==1.0);
        // System.out.println("�ύ��github");
        // System.out.println("a new message");

        // testIntegerCompare();
        // testString();
        // testMath();
        // testTimeString();
//        testPointer();
    }

}
