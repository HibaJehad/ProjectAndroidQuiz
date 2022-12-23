package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class BankQustions {

    private static List<qustion_list> javaQust(){


        final List<qustion_list> qustionlist = new ArrayList<>();

        final qustion_list qustlist1 = new qustion_list("What is the size of int variable","16bit","32 bit","64bit","8bit","32bit","");
        final qustion_list qustlist2 = new qustion_list("Which statement is not true in java language?","(a) A public member of a class can be accessed in all the packages.","(b) A private member of a class cannot be accessed by the methods of the same class.","(c) A private member of a class cannot be accessed from its derived class.","(d) A protected member of a class can be accessed from its derived class.","(b) A private member of a class cannot be accessed by the methods of the same class.","");
        final qustion_list qustlist3 = new qustion_list("To prevent any method from overriding, we declare the method as:","(a) static","(b) const","(c) final","(d) abstract","(c) final","");
        final qustion_list qustlist4 = new qustion_list(" Which of the following variable declaration would NOT compile in a java program?","(a) int var;","int VAR;","(c) int var1;","(e) int 1_var;.","(e) int 1_var;.","");
        final qustion_list qustlist5 = new qustion_list(" An overloaded method consists of,","(a) The same method name with different types of parameters","(b) The same method name with different number of parameters","(c) The same method name and same number and type of parameters with different return type","(d) Both (a) and (b) above","(d) Both (a) and (b) above","");

        qustionlist.add(qustlist1);
        qustionlist.add(qustlist2);
        qustionlist.add(qustlist3);
        qustionlist.add(qustlist4);
        qustionlist.add(qustlist5);


        return qustionlist;

    }

    //**********************************************

    //*/*/*/*/*/*/*/*/*/*

    private static List<qustion_list> phpQust(){


        final List<qustion_list> qustionlist = new ArrayList<>();

        final qustion_list qustlist1 = new qustion_list("Who is known as the father of PHP?","Drek Kolkevi","List Barely","Rasmus Lerdrof","None of the above","Rasmus Lerdrof","");
        final qustion_list qustlist2 = new qustion_list("Variable name in PHP starts with -","! (Exclamation)","$ (Dollar)","& (Ampersand)","# (Hash)","$ (Dollar)","");
        final qustion_list qustlist3 = new qustion_list("Which of the following is the default file extension of PHP?",".php",".hphp",".xml",".html",".php","");
        final qustion_list qustlist4 = new qustion_list(" Which of the following is not a variable scope in PHP?","& …… &","// ……","","/* …… */","// …… and /* …… */","");
        final qustion_list qustlist5 = new qustion_list("Which of the following is used for concatenation in PHP?","+ (plus)","* (Asterisk)",". (dot)","append()",". (dot)","");

        qustionlist.add(qustlist1);
        qustionlist.add(qustlist2);
        qustionlist.add(qustlist3);
        qustionlist.add(qustlist4);
        qustionlist.add(qustlist5);

        return qustionlist;

    }

    private static List<qustion_list> htmlQust(){


        final List<qustion_list> qustionlist = new ArrayList<>();

        final qustion_list qustlist1 = new qustion_list("HTML is the standard ____language for creating Web pages.","scripting","programming","styling","markup","markup","");
        final qustion_list qustlist2 = new qustion_list(" HTML stands for_______.","Hyperactive Text Markup Language","Hyper Text Markup Language","Hyper Text Machine Language","None of these"," Hyper Text Markup Language","");
        final qustion_list qustlist3 = new qustion_list("Which is the correct syntax to include comment in an HTML document?","//","/* Comment */","// Comment //","<!-- Comment -->","<!-- Comment -->","");
        final qustion_list qustlist4 = new qustion_list(" HTML stands for_______.","Hyperactive Text Markup Language","Hyper Text Markup Language","Hyper Text Machine Language","None of these"," Hyper Text Markup Language","");
        final qustion_list qustlist5 = new qustion_list("Which is the correct syntax to include comment in an HTML document?","//","/* Comment */","// Comment //","<!-- Comment -->","<!-- Comment -->","");

        qustionlist.add(qustlist1);
        qustionlist.add(qustlist2);
        qustionlist.add(qustlist3);
        qustionlist.add(qustlist3);
        qustionlist.add(qustlist3);

        return qustionlist;

    }

    private static List<qustion_list> androidQust(){


        final List<qustion_list> qustionlist = new ArrayList<>();

        final qustion_list qustlist1 = new qustion_list("Android is -","an operating system","a web browser","a web server","None of the above","an operating system","");
        final qustion_list qustlist2 = new qustion_list(" Under which of the following Android is licensed?","OSS","Sourceforge","Apache/MIT","None of the above","Apache/MIT","");
        final qustion_list qustlist3 = new qustion_list("For which of the following Android is mainly developed?","Servers","Desktops","Laptops","Mobile devices","Mobile devices","");
        final qustion_list qustlist4 = new qustion_list("Android is based on which of the following language?","Java","C++","C","None of the above","Java","");
        final qustion_list qustlist5 = new qustion_list("APK stands for -","Android Phone Kit","Android Page Kit","Android Package Kit","Android Package Kit\n" +
                "None of the above","Android Package Kit","");

        qustionlist.add(qustlist1);
        qustionlist.add(qustlist2);

        return qustionlist;

    }

    public static List<qustion_list> getQust(String selsectedTopicName){

        switch (selsectedTopicName){
            case "Java Quiz":
                return javaQust();
            case "HTML Quiz":
                return htmlQust();
            case "Android Quiz":
                return androidQust();
            case "PHP Quiz":
                return phpQust();
            default:
                return phpQust();
        }
    }



}
