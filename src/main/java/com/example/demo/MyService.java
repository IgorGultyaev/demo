package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public class MyService implements MyInterfaceService{
@Override
    public Data getDate(){
        return new Data("112", "22");
    }
}
