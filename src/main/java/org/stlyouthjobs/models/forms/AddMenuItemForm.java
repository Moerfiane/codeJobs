
package org.stlyouthjobs.models.forms;

import org.stlyouthjobs.models.Question;
import org.stlyouthjobs.models.Compare;

/**
 * Created by kevinstock on 4/12/17.
 */
public class AddMenuItemForm {

    private Compare menu;
    private Iterable<Question> cheeses;
    private int menuId;
    private int cheeseId;

    public AddMenuItemForm() {}

    public AddMenuItemForm(Compare menu, Iterable<Question> cheeses) {
        this.menu = menu;
        this.cheeses = cheeses;
    }

    public Compare getMenu() {
        return menu;
    }

    public void setMenu(Compare menu) {
        this.menu = menu;
    }

    public Iterable<Question> getCheeses() {
        return cheeses;
    }

    public void setCheeses(Iterable<Question> cheeses) {
        this.cheeses = cheeses;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }
}