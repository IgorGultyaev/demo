package com.example.demo;


import org.springframework.stereotype.Service;

@Service
public class GetSome implements MyInterfaceService{



    @Override
    public Data getDate() {
        return new Data("12345", "12345");
    }
}
