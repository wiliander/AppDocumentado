package com.ronildo.myapplication.exception;

/**
 * essa classe é responsavel por avisar o usuario qual mensagem irá receber caso ocorra uma excessão
 *
 */
public class DivisaoPorZeroException extends Exception {
    public DivisaoPorZeroException() {
        super("Impossível dividir por 0");
    }
}
