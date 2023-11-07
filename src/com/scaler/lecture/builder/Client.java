package com.scaler.lecture.builder;

public class Client {
    public static void main(String[] args) {
//        Builder com.scaler.lecture.builder = new Builder();
//        com.scaler.lecture.builder.setName("abc");
//        com.scaler.lecture.builder.setAge(12);
//        com.scaler.lecture.builder.setPhone("1231231231");
//
//        Student student = new Student(com.scaler.lecture.builder);
//        System.out.println(student.getAge());
//        System.out.println(student.getName());

//        Builder com.scaler.lecture.builder = Student.getBuilder();
//        com.scaler.lecture.builder.setName("abc");
//        com.scaler.lecture.builder.setAge(12);
//        com.scaler.lecture.builder.setPhone("1231231231");
//
//        Student student = com.scaler.lecture.builder.build();

        Student student = Student.getBuilder()
                .setName("asa")
                .setAge(12)
                .setBatchName("asdas")
                .build();

    }
}
