//package com.skypro.library.aspect;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.stereotype.Component;
//
//@Component
//@Aspect
//@EnableAspectJAutoProxy
//public class LoggingAspect {
//
//    @Pointcut(value = "execution(* com.skypro.library.service.BookServiceImpl.addBook(..))")
//    private void addMethodFromBookServiceImpl(){
//    }
//
//    @Pointcut(value = "execution(* com.skypro.library.service.BookServiceImpl.updateBook(..))")
//    private void updateMethodFromBookServiceImpl(){
//    }
//
//    @Pointcut("addMethodFromBookServiceImpl() || updateMethodFromBookServiceImpl()")
//    private void allAddAndUpdateMethodFromBookServiceImpl(){
//    }
//
//
//    @Before("allAddAndUpdateMethodFromBookServiceImpl")
//    public void beforeAddAndUpdateBookAdvice() {
//
//
//    }
//
//}
