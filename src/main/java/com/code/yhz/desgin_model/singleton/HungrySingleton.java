package com.code.yhz.desgin_model.singleton;

/**
 * @Author yhz
 * @Date 2020/9/15 17:05
 */
public class HungrySingleton
{
    private static final HungrySingleton instance=new HungrySingleton();
    private HungrySingleton(){
        System.out.println ("单例模式");
    }
    public static HungrySingleton getInstance()
    {
        return instance;
    }
    public void sout(int i){
        System.out.println ("第"+i+"次");
    }
    public static void main( String[] args ) {
        for ( int i = 0 ; i < 10 ; i++ ) {
            int k= i;
            new Thread ( new Runnable () {
                @Override
                public void run() {
                    HungrySingleton singleton = HungrySingleton.getInstance ();
                    singleton.sout ( k);
                }
            } ,i+"").start ();
        }

    }
}