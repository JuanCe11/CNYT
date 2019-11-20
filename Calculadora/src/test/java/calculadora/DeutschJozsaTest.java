package calculadora;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DeutschJozsaTest {

    @Test
    public void simulacion1() {
        try {
            //double[][] ans = {{0.4999999999999998,0},{0.4999999999999998,0},{0,0},{0,0}};
            //Matriz ansM = new Matriz(4,1,ans);
            //assertEquals(Deutsch.simulacionU0(), ansM);
            System.out.println(DeutschJozsa.simulacionU0());
        } catch (CalculadoraException e) {
            e.printStackTrace();
        }
    }
}
