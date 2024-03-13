package cv.view;

import cv.model.CV;

public class Main {
    public static void main(String[] args) {
        CV cv = new CV("Viacheslav Shtohrin", "creating websites and applications", "ELIT SumDU", "student jobs at university", "Python, C, C++, C#, HTML and CSS, Javascript");
        System.out.println(cv);
    }
}