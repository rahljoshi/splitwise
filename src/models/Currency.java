package models;

public enum Currency {
    DOLLAR(1),
    RUPEE(2);

    private int id;

    private Currency(int id){
        this.id = id;
    }
}
