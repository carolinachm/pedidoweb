package br.com.fdp.pedidos.enumerador;

public enum Modulo {
    ADMINISTRADOR("ROLE_ADMINISTRADOR"), USUARIO("ROLE_USUARIO");
    private String modulo;

    private Modulo(String modulo) {
        this.modulo = modulo;
    }

    @Override
    public String toString() {
        return this.modulo;
    }
}
