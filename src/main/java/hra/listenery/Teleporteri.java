package hra.listenery;

public enum Teleporteri {
    DUCH("Duch"), LUCISTNIK("Lucistnik"), GOLEM("Golem"), OHNIVAK("Ohnivak"), VIDLAK("Vidlak");

    private final String jmeno;

    Teleporteri(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getJmeno() {
        return jmeno;
    }


}