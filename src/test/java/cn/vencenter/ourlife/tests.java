package cn.vencenter.ourlife;

import cn.vencenter.ourlife.thread.MyThread;
import javafx.scene.control.Alert;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @description:
 * @author: 1290274972@qq.com
 * @program: ourlife
 * @create: 2019-07-20 17:22
 * @version:
 **/
public class tests {
    @Test
    public void test() {
        user user = new user();
        user.username="ss";
        user.password="fdf";
        animal animal = new animal();
        animal.username="ss";
        animal.password="fdf";
        System.out.println(user+":"+animal);
        System.out.println(user.equals(animal));
    }

    class user{
        String username;
        String password;

        @Override
        public int hashCode() {
            int i = username.hashCode() + password.hashCode();
            return i;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj==null) {
                return false;
            }

            if(!(hashCode()==obj.hashCode())){
                return false;
            }

            if(obj instanceof animal) {
                return this.username==((animal) obj).username && this.password==((animal) obj).password;
            }
            return super.equals(obj);
        }
    }

    class animal {
        String username;
        String password;

        @Override
        public int hashCode() {
            int i = username.hashCode() + password.hashCode();
            return i;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj==null) {
                return false;
            }

            if(!(hashCode()==obj.hashCode())){
                return false;
            }

            if(obj instanceof user) {
                return this.username==((user) obj).username && this.password==((user) obj).password;
            }
            return super.equals(obj);
        }
    }

    @Test
    public void sd() {
        /*ArrayList<String> strings = new ArrayList<>(Arrays.asList("sd", "fff"));
        strings.add("d");
        strings.forEach(e-> System.out.println(e));
        String[] array = strings.toArray(new String[0]);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }*/
//        List<String> list = Arrays.asList("hello", "world", "thanks");
//        list.add("ppp");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        /*for (Integer i : list) {
            if(2==i) {
                list.remove(i);
            }
        }*/
        list.remove(list.size()-1);
        list.forEach(e-> System.out.println(e));
    }

    @Test
    public void ss() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            executorService.submit(new MyThread());
        }
        Future<String> future = executorService.submit(new MyThread());
        String s=null;
        try {
            s = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
