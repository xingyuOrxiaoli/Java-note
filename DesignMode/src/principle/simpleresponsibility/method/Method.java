package principle.simpleresponsibility.method;

public class Method {

    private void modifyUserInfo(String username,String address){
        username = "xingyu";
        address  = "Beijing";
    }
    private void modifyUserInfo(String username,String ... fileds){

    }
}
