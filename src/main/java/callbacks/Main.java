package callbacks;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        hello("abdo","khaled",null);
        hello("sahar","ali",value ->{
            System.out.println("no last name provided for "+ value);
        });
        hello("hassan",null,value ->{
            System.out.println("no last name provided for "+ value);
        });

        hello2("ali",
                null,
                () -> System.out.println("no last name provided"));


    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else {
            callback.accept(firstName);
        }
    }
    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if(lastName != null){
            System.out.println(lastName);
        }else {
            callback.run();
        }
    }



    //call backs javaScript
//    function hello(firstName,lastName,callback){
//        console.log(firstName);
//        if(lastName){
//            console.log(lastName);
//        }else {
//            callback();
//        }
//    }

    // hello("john",null,function() {console.log("no last name provided")}
}
