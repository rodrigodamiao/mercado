package com.damzik.mercado.enums;

public enum Cargo {
    GERENTE("GERENTE"),
    FUNCIONARIO("FUNCIONARIO");

    private String cargo;

    Cargo(String cargo){
        this.cargo = cargo;
    }

    public String getCargo(){
        return cargo;
    }
}
