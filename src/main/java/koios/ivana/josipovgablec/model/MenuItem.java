package koios.ivana.josipovgablec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuitem_id;  //todo: prebaciti int id u LONG

    public Long getMenuitem_id() {
        return menuitem_id;
    }

    public void setMenuitem_id(Long menuitem_id) {
        this.menuitem_id = menuitem_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public MenuItem(Long menuitem_id, String name) {
        this.menuitem_id = menuitem_id;
        this.name = name;
    }

    public MenuItem() {
    }
}
