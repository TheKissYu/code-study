package com.code.yhz.desgin_model.singleton;

/**
 * @Author yhz
 * @Date 2020/9/15 16:56
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton = null;
    private LazySingleton(){
        System.out.println ("懒汉式单例");
    }
    public static synchronized LazySingleton singleton(){
        if ( lazySingleton == null ){
            lazySingleton= new LazySingleton ();
        }
        return lazySingleton;
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
                    LazySingleton singleton = LazySingleton.singleton ();
                    singleton.sout ( k);
                }
            } ,i+"").start ();
        }

    }
}
