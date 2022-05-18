package com.example.menguita_multicalc.Model;

public class Formula {

    public String frequency (double velocity, double wavelength){
        return String.valueOf(velocity/wavelength);
    }

    public String kineticEnergy (double mass, double velocity){
        return String.valueOf(0.5 * mass * Math.pow(velocity, 2));
    }

    public String power (double work, double time){
        return String.valueOf(work/time);
    }

    public String pressure (double force, double area){
        return String.valueOf(force/area);
    }

    public String speed (double distance, double time){
        return String.valueOf(distance/time);
    }

    public String sphereVolume(double radius){
        return String.valueOf(4 * Math.PI * Math.pow(radius, 3.0) / 3);
    }

    public String coneVolume(double baseRadius, double height){
        return String.valueOf(Math.PI * Math.pow(baseRadius, 2.0) *  height / 3);
    }

    public String cylinderVolume(double baseRadius, double height){
        return String.valueOf(Math.PI * Math.pow(baseRadius, 2.0) *  height);
    }

    public String capsuleVolume(double baseRadius, double height){
        return String.valueOf(Math.PI * Math.pow(baseRadius, 2.0) *  ( 4 * baseRadius / 3 + height ));
    }

    public String rectangularPrismVolume(double length, double width, double height){
        return String.valueOf(length * width * height);
    }

    public String sphereSA(double radius){
        return String.valueOf(4 * Math.PI * Math.pow(radius, 2.0));
    }

    public String coneSA(double baseRadius, double height){
        return String.valueOf(Math.PI * baseRadius * (baseRadius + Math.sqrt(Math.pow(height, 2.0) + Math.pow(baseRadius, 2.0))));
    }

    public String cylinderSA(double baseRadius, double height){
        return String.valueOf((2 * Math.PI * baseRadius * height) + (2 * Math.PI * Math.pow(baseRadius, 2.0)));
    }

    public String capsuleSA(double baseRadius, double height){
        return String.valueOf((2 * Math.PI * baseRadius * height) + (4 * Math.PI * Math.pow(baseRadius, 2.0)));
    }

    public String rectangularPrismSA(double length, double width, double height){
        return String.valueOf((2 * length * width) + (2 * length * height) + (2 * width * height));
    }
}
