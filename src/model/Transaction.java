package model;

public class Transaction extends EntityObject {

    private Long id_exp;
    private Long id_dest;
    private int money;

    public Long getId_exp() {
        return id_exp;
    }

    public void setId_exp(Long id_exp) {
        this.id_exp = id_exp;
    }

    public Long getId_dest() {
        return id_dest;
    }

    public void setId_dest(Long id_dest) {
        this.id_dest = id_dest;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
