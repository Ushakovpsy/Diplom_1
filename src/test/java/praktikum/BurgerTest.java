package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Before
    public void Burger() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient firstIngredient, secondIngredient, thirdIngredient;

    @Test
    public void setBuns() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        assertEquals(3, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredient() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(1, 0);
        assertEquals(new ArrayList<>(Arrays.asList(secondIngredient, firstIngredient, thirdIngredient)), burger.ingredients);
    }

    @Test
    public void getPrice() {
        burger.setBuns(bun);
        burger.ingredients.add(firstIngredient);
        when(bun.getPrice()).thenReturn(10f);
        when(firstIngredient.getPrice()).thenReturn(20f);
        float actual = burger.getPrice();
        assertThat(actual, equalTo(40f));
    }

    @Test
    public void getReceipt() {
        Bun bun = new Bun("black bun", 100);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actual = burger.getReceipt();
        String expected = "(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 300,000000\n";
        assertThat(actual, equalTo(expected));
    }
}
