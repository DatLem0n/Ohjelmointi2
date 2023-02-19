package main.Java.me.ville.minitentit;

public class minitentti5 {
    public static void main(String[] args) {    String str = "Bar";
        StringWrapper sw1 = new StringWrapper(str);
        StringWrapper sw2 = new StringWrapper(sw1.str + str);
        System.out.println(sw2.str += "Foo");
    }

}
class StringWrapper
{
    String str = "Foo";
    public StringWrapper(String istr)
    {
        str = istr;
    }
}
class IntWrapper
{
    public int val = 0;
}

