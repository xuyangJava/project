package com.siping.内部类;

/**
 * 内部类可以访问它外部类的所有成员
 * @author siping-yx
 * @date 2017年11月9日
 * @version 1.0
 *
 */
public class Parcell2 {

    class Contents{
        private int i = 11;
        Object o;
        public int value() {
            return i;
        }
    }
    class Destination {
        private String label;
        Destination(String whereTo){
            label = whereTo;
        }
        String readLabel(){
            return label;
        }
    }
    
    public Destination to(String s) {
        return new Destination(s);
    }
    
    public Contents contents(){
        return new Contents();
    }
    
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }
    
    public static void main(String[] args) {
        Parcell2 p = new Parcell2();
        p.ship("Tasmania");
        Parcell2 q = new Parcell2();
        Contents contents = q.contents();
        q.to("borneo");
    }
}
