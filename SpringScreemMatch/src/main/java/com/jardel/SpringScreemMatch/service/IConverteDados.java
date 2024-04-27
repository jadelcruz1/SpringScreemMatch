package com.jardel.SpringScreemMatch.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe) ;

}
