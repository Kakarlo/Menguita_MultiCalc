package com.example.menguita_multicalc.Controller;

import android.annotation.SuppressLint;
import android.view.View;

import com.example.menguita_multicalc.Model.Formula;
import com.example.menguita_multicalc.View.Calculator;

public class CalculatorController {
    private final Formula formula = new Formula();
    private final Calculator calc;

    public CalculatorController (Calculator calculator) {
        this.calc = calculator;
    }

    @SuppressLint("SetTextI18n")
    public void setCalc (String kind, String type) {
        calc.title.setText(type);
        switch (kind) {
            case "Physics":
                switch (type) {
                    case "Frequency":
                        calc.s1.setText("Velocity");
                        calc.s2.setText("Wavelength");
                        break;
                    case "Kinetic Energy":
                        calc.s1.setText("Mass");
                        calc.s2.setText("Velocity");
                        break;
                    case "Power":
                        calc.s1.setText("Work");
                        calc.s2.setText("Time");
                        break;
                    case "Pressure":
                        calc.s1.setText("Force");
                        calc.s2.setText("Area");
                        break;
                    case "Speed":
                        calc.s1.setText("Distance");
                        calc.s2.setText("Time");
                        break;
                }
                calc.o1.setText(type);
                calc.s3.setVisibility(View.GONE);
                calc.slot3.setVisibility(View.GONE);
                calc.o2.setVisibility(View.GONE);
                calc.output2.setVisibility(View.GONE);
                break;
            case "Geometry":
                switch (type) {
                    case "Sphere":
                        calc.s1.setText("Radius");
                        calc.s2.setVisibility(View.GONE);
                        calc.slot2.setVisibility(View.GONE);
                        calc.s3.setVisibility(View.GONE);
                        calc.slot3.setVisibility(View.GONE);
                        break;
                    case "Cone":
                    case "Cylinder":
                        calc.s1.setText("Base Radius");
                        calc.s2.setText("Height");
                        calc.s3.setVisibility(View.GONE);
                        calc.slot3.setVisibility(View.GONE);
                        break;
                    case "Cube":
                        calc.s1.setText("Edge Length");
                        calc.s2.setVisibility(View.GONE);
                        calc.slot2.setVisibility(View.GONE);
                        calc.s3.setVisibility(View.GONE);
                        calc.slot3.setVisibility(View.GONE);
                        break;
                    case "Rectangular Prism":
                        calc.s1.setText("Length");
                        calc.s2.setText("Width");
                        calc.s3.setText("Height");
                        break;
                }
                calc.o1.setText("Volume");
                calc.o2.setText("Surface Area");
                break;
        }
    }

    public void solve (String kind, String type, double num1, double num2, double num3){
        switch (kind) {
            case "Physics":
                switch (type) {
                    case "Frequency":
                        calc.output1.setText(formula.frequency(num1,num2));
                        break;
                    case "Kinetic Energy":
                        calc.output1.setText(formula.kineticEnergy(num1,num2));
                        break;
                    case "Power":
                        calc.output1.setText(formula.power(num1,num2));
                        break;
                    case "Pressure":
                        calc.output1.setText(formula.pressure(num1,num2));
                        break;
                    case "Speed":
                        calc.output1.setText(formula.speed(num1,num2));
                        break;
                }
                break;
            case "Geometry":
                switch (type) {
                    case "Sphere":
                        calc.output1.setText(formula.sphereVolume(num1));
                        calc.output2.setText(formula.sphereSA(num1));
                        break;
                    case "Cone":
                        calc.output1.setText(formula.coneVolume(num1, num2));
                        calc.output2.setText(formula.coneSA(num1, num2));
                        break;
                    case "Cylinder":
                        calc.output1.setText(formula.cylinderVolume(num1, num2));
                        calc.output2.setText(formula.cylinderSA(num1, num2));
                        break;
                    case "Cube":
                        calc.output1.setText(formula.cubeVolume(num1));
                        calc.output2.setText(formula.cubeSA(num1));
                        break;
                    case "Rectangular Prism":
                        calc.output1.setText(formula.rectangularPrismVolume(num1, num2, num3));
                        calc.output2.setText(formula.rectangularPrismSA(num1, num2, num3));
                        break;
                }
                break;
        }
    }

}
