package com.java.collection.ArrayList;

import java.util.*;

public class SortList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(9);
        list.add(11);
        list.add(12);
        Collections.sort(list);
        System.out.println("sorted list with collection "+list);
        Collections.reverse(list);
        System.out.println("sorted list with collection in decending"+list);
        list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println("sorted list "+list);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Ram",15000));
        employeeList.add(new Employee(2,"Raj",14000));
        employeeList.add(new Employee(3,"Rk",200000));
        employeeList.add(new Employee(4,"Ram krishna",19000));
         // employeeList.sort((o);
       Collections.sort(employeeList,new MySort());//ascending
       System.out.println(employeeList);

        Collections.sort(employeeList,new MySort());//decending
        System.out.println(employeeList);


        Collections.sort(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getName().compareTo(o2.getName()));
            }
        });
       System.out.println("employee list"+ employeeList);//ascending Order

        Collections.sort(employeeList,(o1, o2) -> (o1.getName().compareTo(o2.getName())));
        System.out.println(employeeList);
    }
}

class MySort implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o2.getSalary() - o1.getSalary());
    }
}
