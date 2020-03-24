package simplefactory;

/**
 * @author liuxin
 * @version 1.0
 * @date 2020/3/24 14:44
 */
public class FruitFactory {

//    public Fruit getApple(){
//        return new Apple();
//    }
//
//    public Fruit getBanana(){
//        return new Banana();
//    }

//    public Fruit getFruit(String type){
//        if(type.equals("apple")){
//            return new Apple();
//        }else if(type.equals("banana")){
//            return new Banana();
//        }else{
//            return null;
//        }
//    }
    public Fruit getFruit(String path) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class fruit = Class.forName(path);
        return (Fruit) fruit.newInstance();
    }

}
