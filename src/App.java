import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class App {

    // camel_kata tranning
    public static String CamelString(String name){
        char[] chars = name.toLowerCase().toCharArray();
        boolean found = false;
        for(int i = 0 ; i< chars.length; i++){
            if(!found && Character.isLetter(chars[i])){
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            }else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i] =='\''){
                    found = false;
                }
        }
        return String.valueOf(chars);
    }

    // digPow kata
    public static long digPow(int n, int p){
        long temp =0;
        String[] value = String.valueOf(n).split("");
        for(int i =0;i< value.length;i++){
            temp += Math.pow(Double.parseDouble(value[i]), (p+i));
        }
        return temp % n == 0? temp/n : -1;
    }
    //digPow kata  clever using stream
    public static long DigPow(int n ,int p){
        int sum=0;
        int digit[] = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        for(int a:digit) sum += Math.pow(a, p++);
        return sum%n == 0 ? sum/n : -1;
    }


    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
    @Test
    public void TestingCamel(){
        assertEquals("Hello World", CamelString("hello wORLD"));
    }

    @Test
	public void Test1() {
		assertEquals(1, digPow(89, 1));
	}
	@Test
	public void Test2() {
		assertEquals(-1, digPow(92, 1));
	}
	@Test
	public void Test3() {
		assertEquals(51, digPow(46288, 3));
	}

}
