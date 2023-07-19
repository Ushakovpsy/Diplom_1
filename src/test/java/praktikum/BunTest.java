package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private String bunName;
    private float bunPrice;
    private Bun bun;

    public BunTest(String name, float price) {
        this.bunName = name;
        this.bunPrice = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Острая галактическая", 1.5f},
                {"Темная материя", 2.0f},
                {"Голубая бездна", 2.5f}
        });
    }

    @Before
    public void Bun() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void getName() {
        assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
