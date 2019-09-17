package offer.replacespace;

/**
 * @ClassName offer.replacespace.ReplaceSpace
 * @Description 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @Author chenkq
 * @Date 2019/9/18 0:57
 * @Version V1.0
 **/
public class ReplaceSpace {


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(getRepalceString(str));
    }

    public static String getRepalceString(StringBuffer str){
        return str.toString().replaceAll(" ","%20");
    }
}
