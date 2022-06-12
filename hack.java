package codechef;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
class hack1{
	private String hax;
	public hack1() {
		hax="HackerEarth";
	}
	private void method() {
		System.out.println("Hello HackerEarth!");
	}

}
public class hack{
	public static void main(String args[]) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		hack1 ob =new hack1();
		Class clas = ob.getClass();
		Constructor cons = clas.getConstructor();
		Method[] methods = clas.getMethods();
		for(Method method: methods)
			System.out.println(method.getName());
		Method call = clas.getDeclaredMethod("hack_method");
		call.setAccessible(true);
		call.invoke(ob);
	}
}