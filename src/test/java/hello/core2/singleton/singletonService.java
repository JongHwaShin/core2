package hello.core2.singleton;

public class singletonService {

    private static final singletonService instance = new singletonService();

    public static singletonService getInstance(){
        return instance;
    }

    private singletonService(){

    }
    public void logic(){
        System.out.println("싱글톤 로직을 호출");
    }
}
