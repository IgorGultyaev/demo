package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("**/api")
public class MyController {

//    Создаёт {@link MyController}
   public MyController(){

   }
   @RequestMapping("hello({str})")
   public String hello(@PathVariable("str")String str){
       return str;
   }
@RequestMapping("data")
   public Data getData(){
      Data d = new Data("pr1", "pr2");
            return d;

   }

   @RequestMapping("concat")
   public String concat(@RequestBody Data d){
      return d.getProperty1() + "->" + d.getProperty2();

   }

//   @RequestMapping("svc")
//   public MyService svc(){
//      return ;
//
//   }
@Autowired
@Qualifier("myService")
private  MyInterfaceService myService1;

   @RequestMapping("Date")
   public Data data(){
      return myService1.getDate();
   }

@Qualifier("getSome")
@Autowired
   private  MyInterfaceService getSome1;

   @RequestMapping("getSome1")
   public Data data2(){
      return getSome1.getDate();
   }


   @InjectSome("test")
   private String strFiled;

   @RequestMapping("inject")
   public String inject(){
      return strFiled;
   };

//   @Qualifier("getSome")
//   @Autowired
//   private  MyInterfaceService getSome1;
//
//   @RequestMapping("GetSome")
//   public Data data2(){
//      return myService1.getDate();
//   }



}
