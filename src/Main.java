import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String className = "";
    public static String useVariables = "";
    public static String var1Type = "";
    public static String var1Name = "";
    public static String useVar2 = "";
    public static String var2Type = "";
    public static String var2Name = "";
    public static String useVar3 = "";
    public static String var3Type = "";
    public static String var3Name = "";
    public static String useVar4 = "";
    public static String var4Type = "";
    public static String var4Name = "";
    public static String useVar5 = "";
    public static String var5Type = "";
    public static String var5Name = "";
    public static int varAmount = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter name of class: ");
        className = s.nextLine();  // Read user input
        if(className.equals(""))
            className = "DefaultClassName";

        useVariables = "";

        while(!(useVariables.equalsIgnoreCase("y") || useVariables.equalsIgnoreCase("n"))){
            System.out.print("Do you want to create variables? (y or n): ");
            useVariables = s.nextLine();  // Read user input
        }
        if(useVariables.equalsIgnoreCase("y")){
            while(!(var1Type.contains("boolean") || var1Type.contains("String") || var1Type.contains("int") || var1Type.contains("char") || var1Type.contains("double"))){
                System.out.print("What is your first variable type? (String, char, boolean, int, double): ");
                var1Type = s.nextLine();  // Read user input
            }
            varAmount++;
            System.out.print("What should be this variable's name?: ");
            var1Name = s.nextLine();  // Read user input

            while(!(useVar2.equalsIgnoreCase("y") || useVar2.equalsIgnoreCase("n"))){
                System.out.print("Would you like to create another variable? (y or n): ");
                useVar2 = s.nextLine();  // Read user input
            }
            if(useVar2.equalsIgnoreCase("y")){
                while(!(var2Type.contains("boolean") || var2Type.contains("String") || var2Type.contains("int") || var2Type.contains("char") || var2Type.contains("double"))){
                    System.out.print("What is your second variable type? (String, char, boolean, int, double): ");
                    var2Type = s.nextLine();  // Read user input
                }
                varAmount++;
                System.out.print("What should be this variable's name?: ");
                var2Name = s.nextLine();  // Read user input
                
                while(!(useVar3.equalsIgnoreCase("y") || useVar3.equalsIgnoreCase("n"))){
                    System.out.print("Would you like to create another variable? (y or n): ");
                    useVar3 = s.nextLine();  // Read user input
                }
                if(useVar3.equalsIgnoreCase("y")) {
                    while (!(var3Type.contains("boolean") || var3Type.contains("String") || var3Type.contains("int") || var3Type.contains("char") || var3Type.contains("double"))) {
                        System.out.print("What is your third variable type? (String, char, boolean, int, double): ");
                        var3Type = s.nextLine();  // Read user input
                    }
                    varAmount++;
                    System.out.print("What should be this variable's name?: ");
                    var3Name = s.nextLine();  // Read user input

                    while(!(useVar4.equalsIgnoreCase("y") || useVar4.equalsIgnoreCase("n"))){
                        System.out.print("Would you like to create another variable? (y or n): ");
                        useVar4 = s.nextLine();  // Read user input
                    }
                    if(useVar4.equalsIgnoreCase("y")) {
                        while (!(var4Type.contains("boolean") || var4Type.contains("String") || var4Type.contains("int") || var4Type.contains("char") || var4Type.contains("double"))) {
                            System.out.print("What is your forth variable type? (String, char, boolean, int, double): ");
                            var4Type = s.nextLine();  // Read user input
                        }
                        varAmount++;
                        System.out.print("What should be this variable's name?: ");
                        var4Name = s.nextLine();  // Read user input

                        while(!(useVar5.equalsIgnoreCase("y") || useVar5.equalsIgnoreCase("n"))){
                            System.out.print("Would you like to create another variable? (y or n): ");
                            useVar5 = s.nextLine();  // Read user input
                        }
                        if(useVar5.equalsIgnoreCase("y")) {
                            while (!(var5Type.contains("boolean") || var5Type.contains("String") || var5Type.contains("int") || var5Type.contains("char") || var5Type.contains("double"))) {
                                System.out.print("What is your forth variable type? (String, char, boolean, int, double): ");
                                var5Type = s.nextLine();  // Read user input
                            }
                            varAmount++;
                            System.out.print("What should be this variable's name?: ");
                            var5Name = s.nextLine();  // Read user input
                        }
                    }
                }
            }
        }

        createFile();
        writeFile();

    }
    public static void createFile(){
        try {
            File myObj = new File(className +".java");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void writeFile(){
        try {
            FileWriter myWriter = new FileWriter(className +".java");
            myWriter.write("class " + className + " {\n\n");
            if(useVariables.equalsIgnoreCase("y")){
                myWriter.write("\tprivate static " + var1Type + " " + var1Name + ";\n");
                if(useVar2.equalsIgnoreCase("y")) {
                    myWriter.write("\tprivate static " + var2Type + " " + var2Name + ";\n");
                    if(useVar3.equalsIgnoreCase("y")) {
                        myWriter.write("\tprivate static " + var3Type + " " + var3Name + ";\n");
                        if(useVar4.equalsIgnoreCase("y")) {
                            myWriter.write("\tprivate static " + var4Type + " " + var4Name + ";\n");
                            if(useVar5.equalsIgnoreCase("y")) {
                                myWriter.write("\tprivate static " + var5Type + " " + var5Name + ";\n");
                            }
                        }
                    }
                }
                myWriter.write("\n");
            }
            if(varAmount == 0)
                myWriter.write("\t" + className + "(){\n\n\t");
            else if(varAmount == 1)
                myWriter.write("\t" + className + "(" + var1Type + " " + var1Name + "){\n\n");
            else if(varAmount == 2)
                myWriter.write("\t" + className + "(" + var1Type + " " + var1Name + ", " + var2Type + " " + var2Name + "){\n\n");
            else if(varAmount == 3)
                myWriter.write("\t" + className + "(" + var1Type + " " + var1Name + ", " + var2Type + " " + var2Name + ", " + var3Type + " " + var3Name + "){\n\n");
            else if(varAmount == 4)
                myWriter.write("\t" + className + "(" + var1Type + " " + var1Name + ", " + var2Type + " " + var2Name + ", " + var3Type + " " + var3Name + ", " + var4Type + " " + var4Name + "){\n\n");
            else if(varAmount == 5)
                myWriter.write("\t" + className + "(" + var1Type + " " + var1Name + ", " + var2Type + " " + var2Name + ", " + var3Type + " " + var3Name + ", " + var4Type + " " + var4Name + ", " + var5Type + " " + var5Name + "){\n\n");

            if(varAmount >= 1)
                myWriter.write("\t\tthis." + var1Name + " = " + var1Name + ";\n");
            if(varAmount >= 2)
                myWriter.write("\t\tthis." + var2Name + " = " + var2Name + ";\n");
            if(varAmount >= 3)
                myWriter.write("\t\tthis." + var3Name + " = " + var3Name + ";\n");
            if(varAmount >= 4)
                myWriter.write("\t\tthis." + var4Name + " = " + var4Name + ";\n");
            if(varAmount >= 5)
                myWriter.write("\t\tthis." + var5Name + " = " + var5Name + ";\n");
            myWriter.write("\n\t}\n}");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}